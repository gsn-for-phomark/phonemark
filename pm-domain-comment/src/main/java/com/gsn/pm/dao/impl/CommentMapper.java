package com.gsn.pm.dao.impl;

import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.entity.Commentinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CommentMapper extends MisBaseMapper<Commentinfo> {
    /**
     * 添加一级评论
     * @param eno
     * @param mno
     * @param cdesr
     * @return
     */
    @Insert("insert into commentinfo values(NULL,#{eno},#{mno},#{cdesr},0,NOW(),1,1,null,null,0)")
    int add(@Param("eno") Integer eno, @Param("mno") Integer mno, @Param("cdesr") String cdesr);


    /**
     * 添加二级评论
     * @param eno
     * @param mno
     * @param cdesr
     * @param flag      判断评论层数  1，2，3 对应一,二，三级
     * @param spare1  为三级评论所用的字段： 回复对象的回复id（cno）
     * @param spare2   为二级评论所用的字段： 回复对象的回复id（cno）
     * @return
     */
    @Insert("insert into commentinfo values(NULL,#{eno},#{mno},#{cdesr},0,NOW(),1,#{flag},#{spare1},#{spare2},null)")
    int add2(@Param("eno") Integer eno, @Param("mno") Integer mno, @Param("cdesr") String cdesr, @Param("flag") Integer flag, @Param("spare1") String spare1, @Param("spare2") String spare2);


//    /**
//     * 删除评论
//     * @param cno
//     * @return
//     */
//    @Delete("delete from commentinfo where cno=#{cno}")
//    int delete(@Param("cno") Integer cno);


    /**
     * 查询一级评论
     * @param eno
     * @return
     */
    @Select("\n" +
            "SELECT h1.cno,h1.eno,h1.mno,cdesr,cdate,cheat,cstatus,flag,spare1,spare2,nickName,mpic,countcom1,showandhid,h2.heat FROM (\n" +
            "\t\t\tSELECT cno,eno,mno,cdesr,cdate,cheat,cstatus,flag,a.spare1,spare2,nickName,mpic,b.countcom1,a.showandhid from (\n" +
            "\t\t\t\t\t\tSELECT cno,eno,c.mno,cdesr,DATE_FORMAT(cdate,'%Y-%m-%d %H:%I') as cdate,cheat,cstatus,flag,spare1,spare2,m.nickName,m.mpic,c.showandhid from commentinfo as c \n" +
            "\t\t\t\t\t\t LEFT join\n" +
            "\t\t\t\t\t\t(select  mno,nickName,mpic from memberinfo) as m  on c.mno=m.mno where flag=1 and cstatus=1 and eno = #{eno}\n" +
            "\t\t\t) a\n" +
            "\t\t\tLEFT join(\n" +
            "\t\t\t\t\tSELECT spare1,COUNT(*) countcom1 from commentinfo   where spare1 IS NOT NULL GROUP BY spare1\n" +
            "\t\t\t) b on a.cno=b.spare1  order by cdate desc\n" +
            "\n" +
            ")h1 LEFT join(\t\n" +
            "\t\t\tSELECT eno,cno,COUNT(cno) heat FROM heatinfo GROUP BY cno,eno\n" +
            ") h2 on h1.eno=h2.eno and h1.cno=h2.cno    order by cdate desc")
    List<Commentinfo> findLevel1Com(@Param("eno") Integer eno);


    /**
     * 二，三级评论查询
     * @param eno
     * @param spare1  回复对象的回复id（cno）
     * @return
     */
    @Select("SELECT h1.cno,h1.eno,h1.mno,cdesr,cdate,cheat,cstatus,flag,spare1,spare2,nickName,mpic,replyid,replyname,h2.heat FROM (\n" +
            "\t\t\t\tSELECT a.cno,a.eno,a.mno,a.cdesr,a.cdate,a.cheat,a.cstatus,a.flag,a.spare1,a.spare2,a.nickName,a.mpic,a.replyid,b.replyname from (\n" +
            "\n" +
            "\t\t\t\tSELECT c.cno,eno,c.mno,cdesr,cdate,cheat,cstatus,flag,spare1,spare2,m.nickName,m.mpic,c2.mno replyid from commentinfo as c \n" +
            "\n" +
            "\t\t\t\t LEFT join\n" +
            "\t\t\t\t(select  mno,nickName,mpic from memberinfo) as m  on c.mno=m.mno \n" +
            "\n" +
            "\n" +
            "\t\t\t\tleft join\n" +
            "\t\t\t\t(SELECT cno,mno from commentinfo )as c2 on c2.cno=c.spare2   where flag<>1 and cstatus=1 and eno = #{eno} and  spare1= #{spare1}\n" +
            "\t\t\t\t)a\n" +
            "\t\t\t\tleft join (\n" +
            "\t\t\t\t\tSELECT mno,nickName replyname from memberinfo)b   on a.replyid=b.mno\n" +
            "\n" +
            ")h1 LEFT join(\t\n" +
            "\t\t\tSELECT eno,cno,COUNT(cno) heat FROM heatinfo GROUP BY cno,eno\n" +
            ") h2 on h1.eno=h2.eno and h1.cno=h2.cno")
    List<Commentinfo> findLevel2Com(@Param("eno") Integer eno, @Param("spare1") Integer spare1);


    /**
     * 查询评论总数
     * @param eno
     * @return
     */
    @Select("SELECT COUNT(*),eno comcount from commentinfo WHERE eno=#{eno} GROUP BY eno")
    Integer countCom(@Param("eno") Integer eno);


    /**
     *  评论 时间和名称的综合查询
     * @param startDate
     * @param endDate
     * @param t         查询词缀
     * @return
     */
    @Select("SELECT * from (\n" +
            "\n" +
            "SELECT f3.cno,f3.nickName,f3.tel,f3.email,f3.cdate,f3.cdesr,f3.ename,f3.cstatus from (\n" +
            "\n" +
            "\t\t\t\tSELECT * from (\t\n" +
            "\t\t\t\t\t\t\tSELECT a.cno,b.nickName,b.tel,b.email,a.cdate,a.cdesr,a.ename,a.cstatus from\n" +
            "\t\t\t\t\t\t(SELECT c.cno,c.eno,c.mno,cdesr,cheat,cdate,cstatus,flag,e.ename from commentinfo as c LEFT join essayinfo as e on c.eno=e.eno)a\n" +
            "\t\t\t\t\t\tleft join \n" +
            "\t\t\t\t\t\t\t(select nickName,mno,tel,email from  memberinfo ) b on a.mno=b.mno\n" +
            "\t\t\t\t)f1 where cdate BETWEEN #{startDate} AND #{endDate} \n" +
            ")f3 RIGHT join (\n" +
            "\t\t\t\tSELECT * from (\t\n" +
            "\t\t\t\t\t\t\tSELECT a.cno,b.nickName,b.tel,b.email,a.cdate,a.cdesr,a.ename,a.cstatus from\n" +
            "\t\t\t\t\t\t(SELECT c.cno,c.eno,c.mno,cdesr,cheat,cdate,cstatus,flag,e.ename from commentinfo as c LEFT join essayinfo as e on c.eno=e.eno)a\n" +
            "\t\t\t\t\t\tleft join \n" +
            "\t\t\t\t\t\t\t(select nickName,mno,tel,email from  memberinfo ) b on a.mno=b.mno\n" +
            "\t\t\t\t)f2 where  nickName like  concat('%',#{t},'%') \n" +
            "\n" +
            ")f4 on f3.cno=f4.cno limit #{num},#{size} \n" +
            "\n" +
            ")f5 WHERE cno IS NOT NULL")
    List<Commentinfo> findByDateAndAname(
            @Param("startDate") String startDate, @Param("endDate") String endDate,
            @Param("t") String t, @Param("num") Integer num, @Param("size") Integer size);





    /**
     *  评论 时间和名称的综合查询   总数
     * @param startDate
     * @param endDate
     * @param t         查询词缀
     * @return
     */
    @Select(" SELECT COUNT(*) from (  SELECT * from (\n" +
            "\n" +
            "SELECT f3.cno,f3.nickName,f3.tel,f3.email,f3.cdate,f3.cdesr,f3.ename,f3.cstatus from (\n" +
            "\n" +
            "\t\t\t\tSELECT * from (\t\n" +
            "\t\t\t\t\t\t\tSELECT a.cno,b.nickName,b.tel,b.email,a.cdate,a.cdesr,a.ename,a.cstatus from\n" +
            "\t\t\t\t\t\t(SELECT c.cno,c.eno,c.mno,cdesr,cheat,cdate,cstatus,flag,e.ename from commentinfo as c LEFT join essayinfo as e on c.eno=e.eno)a\n" +
            "\t\t\t\t\t\tleft join \n" +
            "\t\t\t\t\t\t\t(select nickName,mno,tel,email from  memberinfo ) b on a.mno=b.mno\n" +
            "\t\t\t\t)f1 where cdate BETWEEN #{startDate} AND #{endDate} \n" +
            ")f3 RIGHT join (\n" +
            "\t\t\t\tSELECT * from (\t\n" +
            "\t\t\t\t\t\t\tSELECT a.cno,b.nickName,b.tel,b.email,a.cdate,a.cdesr,a.ename,a.cstatus from\n" +
            "\t\t\t\t\t\t(SELECT c.cno,c.eno,c.mno,cdesr,cheat,cdate,cstatus,flag,e.ename from commentinfo as c LEFT join essayinfo as e on c.eno=e.eno)a\n" +
            "\t\t\t\t\t\tleft join \n" +
            "\t\t\t\t\t\t\t(select nickName,mno,tel,email from  memberinfo ) b on a.mno=b.mno\n" +
            "\t\t\t\t)f2 where  nickName like  concat('%',#{t},'%') \n" +
            "\n" +
            ")f4 on f3.cno=f4.cno \n" +
            "\n" +
            ")f5 WHERE cno IS NOT NULL ) f6")
    int findByDateAndAnameTotal(
            @Param("startDate") String startDate, @Param("endDate") String endDate,
            @Param("t") String t);





    /**
     * 评论分页查询
     * @return
     */
    @Select("SELECT a.cno,b.nickName,b.tel,b.email,a.cdate,a.cdesr,a.ename,a.cstatus from\n" +
            "(SELECT c.cno,c.eno,c.mno,cdesr,cheat,cdate,cstatus,flag,e.ename from commentinfo as c LEFT join essayinfo as e on c.eno=e.eno)a\n" +
            "left join (select nickName,mno,tel,email from  memberinfo ) b on a.mno=b.mno order by cno asc limit #{num},#{size}")
    List<Commentinfo> findByPage(@Param("num") Integer num, @Param("size") Integer size);


    /**
     * 评论分页查询  总数
     * @return
     */
    @Select("SELECT COUNT(*) from (\n" +
            "SELECT a.cno,b.nickName,b.tel,b.email,a.cdate,a.cdesr,a.ename,a.cstatus from\n" +
            "(SELECT c.cno,c.eno,c.mno,cdesr,cheat,cdate,cstatus,flag,e.ename from commentinfo as c LEFT join essayinfo as e on c.eno=e.eno)a \n" +
            "left join (select nickName,mno,tel,email from  memberinfo ) b on a.mno=b.mno )s")
    int findByPageTotal();


}

