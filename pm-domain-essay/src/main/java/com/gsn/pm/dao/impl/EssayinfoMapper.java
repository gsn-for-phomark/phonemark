package com.gsn.pm.dao.impl;

import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.domain.EssayComment;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.domain.EssayShow;
import com.gsn.pm.domain.EssayVO;
import org.apache.ibatis.annotations.*;
import com.gsn.pm.entity.Essayinfo;

import java.util.List;

@Mapper
public interface EssayinfoMapper extends MisBaseMapper<Essayinfo> {

    /**
     * 添加文章
     * @param ename
     * @param mno
     * @param epic
     * @param edesr
     * @param tno
     * @return
     */
    @Insert("insert into essayinfo(eno, ename, mno,status, edate,eheat,epic,edser,tno,spare1,spare2" +
            ") values(null, #{ename}, #{mno}, 1,NOW(),0,#{epic},#{edesr},#{tno},null,null)")
    int add(@Param("ename") String ename, @Param("mno") Integer mno, @Param("epic") String epic,@Param("edesr") String edesr
    ,@Param("tno") Integer tno) ;


    /**
     * 根据文章类型
     * 查询文章和评论
     * @param tno
     * @return
     */
    @Select("SELECT * from (" +
            "select a.eno,a.ename,a.mno,a.status,a.epic,DATE_FORMAT(a.edate,'%m-%d')as edate,a.eheat,a.edser,a.nickName,a.mpic,b.commentcount,a.tno,et.tname from(" +
            "(select e.eno,e.ename,e.mno, e.status,e.epic,e.edate,e.eheat,e.edser,m.nickName,m.mpic,e.tno from " +
            "essayinfo e inner join memberinfo m on e.mno=m.mno )as a) left join (" +
            "(select eno,count(*)as commentcount from commentinfo group by eno)as b " +
            ")on a.eno=b.eno  LEFT join essaytype et ON et.tno=a.tno  ) g1   where 1=1 and status<>2 and tno=#{tno} ORDER BY edate desc ")
    List<EssayComment> findEssayandCommentByEtype(@Param("tno") Integer tno);


    /**
     * 查询精选文章类型
     * @return
     */
    @Select("select a.eno,a.ename,a.mno,a.status,a.epic,DATE_FORMAT(a.edate,'%m-%d')as edate,a.eheat,a.edser,a.nickName,a.mpic,b.commentcount from(" +
            "(select e.eno,e.ename,e.mno, e.status,e.epic,e.edate,e.eheat,e.edser,m.nickName,m.mpic from " +
            "essayinfo e inner join memberinfo m on e.mno=m.mno )as a) left join (" +
            "(select eno,count(*)as commentcount from commentinfo group by eno)as b" +
            ")on a.eno=b.eno where 1=1 and a.status=3 ORDER BY a.edate desc ")
    List<EssayComment> findEssayandComment();

    /**
     * 显示文章详细内容
     * @param eno
     * @return
     */
    @Select("SELECT eno,ename,e.mno,`status`,DATE_FORMAT(edate,'%Y-%m-%d %H:%I') edate,eheat,epic,edser,tno,m.nickName,m.mpic from essayinfo as e " +
            "left join (SELECT mno,nickName,mpic from memberinfo) AS m on e.mno=m.mno where eno = #{eno}")
    List<EssayShow> showEssay(@Param("eno") Integer eno);


    /**
     * 个人中心文章列表
     * @param mno
     * @return
     */
    @Select("<script>" +
            "select b.eno,ename,epic,m.mno,mpic,nickName," +
            " DATE_FORMAT(edate,'%m-%d') as edate,IFNULL(eheat,0) eheat,IFNULL(cnum,0) cnum from (" +
            " SELECT e.eno,ename,epic,e.mno,eheat,edate,cnum from (SELECT eno,COUNT(eno) cnum" +
            " from commentinfo GROUP BY eno) a right join essayinfo e on e.eno=a.eno) b" +
            " left join memberinfo m on m.mno=b.mno  where 1=1 " +
            " <if test='mno!=null '>"+
            "  and m.mno=#{mno}   " +
            " </if>"+
            " order by edate desc" +
            " </script>")
    List<EssayList> findEssayList(@Param("mno") Integer mno);


//    /**
//     * 文章删除
//     * @param eno
//     * @return
//     */
//    @Delete("delete from essayinfo where eno=#{eno}")
//    int delete(@Param("eno") Integer eno);

    /**
     * 后端文章状态值的修改(未测)
     * @param eno
     *
     * @return
     */
    @Update("update essayinfo set status=#{status}  where eno=#{eno] ")
    int updateStatus(@Param("status") Integer status,@Param("eno") Integer eno);


    /**
     * 时间和名称的综合查询
     * 返回文章数量
     * @param startDate
     * @param endDate
     * @param t
     * @return
     */
    @Select("<script>" +
            "SELECT COUNT(*) from ( SELECT * from (" +
            " SELECT a1.eno,a1.ename,a1.nickName,a1.`status`,a1.edate,a1.eheat,a1.epic,a1.edser,a1.tno,a1.ecomcount,a1.tname from(" +
            " SELECT eno,ename,d.nickName,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from (" +
            " SELECT a.eno,ename,mno,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from (" +
            " SELECT e1.eno,ename,mno,`status`,edate,eheat,epic,edser,e1.tno,t1.tname from essayinfo as e1 LEFT JOIN essaytype t1 on e1.tno=t1.tno " +
            " )a left join( select eno,count(*)as ecomcount from commentinfo  group by eno " +
            " )b on a.eno=b.eno)c left join ( SELECT mno,nickName from memberinfo " +
            ")d on c.mno=d.mno  where edate BETWEEN" +
            "<if test='startDate!=null or endDate != null '> " +
            "#{startDate} AND #{endDate} " +
            "</if>" +
            ")a1 RIGHT join( SELECT eno,ename,d.nickName,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from (" +
            " SELECT a.eno,ename,mno,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from (" +
            " SELECT e1.eno,ename,mno,`status`,edate,eheat,epic,edser,e1.tno,t1.tname from essayinfo as e1 LEFT JOIN essaytype t1 on e1.tno=t1.tno " +
            " )a left join( select eno,count(*)as ecomcount from commentinfo  group by eno  " +
            " )b on a.eno=b.eno)c left join (SELECT mno,nickName from memberinfo " +
            " )d on c.mno=d.mno  where ename like  " +
            "<if test='t!=null'>" +
            " concat('%', #{t},'%') " +
            " </if>" +
            " order by eno asc )a2  on a1.eno=a2.eno ) a3 WHERE 1=1 and eno IS NOT NULL) a4" +
            "</script>")
    int findByDateAndAnameTotal(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("t") String t);


    /**
     * 时间和名称的综合查询
     * @param startDate
     * @param endDate
     * @param t
     * @param num 页码
     * @param pageSize
     * @return
     */
    @Select("<script>" +
            "SELECT * from (" +
            " SELECT a1.eno,a1.ename,a1.nickName,a1.`status`,a1.edate,a1.eheat,a1.epic,a1.edser,a1.tno,a1.ecomcount,a1.tname from( " +
            " SELECT eno,ename,d.nickName,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from ( " +
            " SELECT a.eno,ename,mno,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from (" +
            " SELECT e1.eno,ename,mno,`status`,edate,eheat,epic,edser,e1.tno,t1.tname from essayinfo as e1 LEFT JOIN essaytype t1 on e1.tno=t1.tno" +
            " )a left join( select eno,count(*)as ecomcount from commentinfo  group by eno" +
            " )b on a.eno=b.eno)c left join ( SELECT mno,nickName from memberinfo" +
            " <if test='startDate!=null or endDate != null' >" +
            " )d on c.mno=d.mno  where edate BETWEEN #{startDate} AND #{endDate} ) a1" +
            " </if>" +
            " RIGHT join( SELECT eno,ename,d.nickName,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from ( " +
            " SELECT a.eno,ename,mno,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from ( " +
            " SELECT e1.eno,ename,mno,`status`,edate,eheat,epic,edser,e1.tno,t1.tname from essayinfo as e1 LEFT JOIN essaytype t1 on e1.tno=t1.tno " +
            " )a left join( select eno,count(*)as ecomcount from commentinfo  group by eno " +
            " )b on a.eno=b.eno)c left join (SELECT mno,nickName from memberinfo)d on c.mno=d.mno  where ename like " +
            " <if test='t!=null'>" +
            "concat('%',#{t},'%')" +
            " </if> " +
            " order by eno asc )a2  on a1.eno=a2.eno  " +
            " <if test='num!=null and pageSize!=null'>" +
            " limit    #{num},#{pageSize} " +
            " </if>" +
            ") a3 WHERE 1=1 and eno IS NOT NULL" +
            " </script>")
    List<Essayinfo> findByDateAndAname(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("t") String t,@Param("num") Integer num,@Param("pageSize") Integer pageSize);

    /**
     * 分页时总条数
     * @return
     */
    @Select(" SELECT COUNT(*) from (" +
            " SELECT eno,ename,d.nickName,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from (" +
            " SELECT a.eno,ename,mno,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from (" +
            " SELECT e1.eno,ename,mno,`status`,edate,eheat,epic,edser,e1.tno,t1.tname from essayinfo as e1 LEFT JOIN essaytype t1 on e1.tno=t1.tno " +
            " )a left join( select eno,count(*)as ecomcount from commentinfo  group by eno)b on a.eno=b.eno" +
            " )c left join (SELECT mno,nickName from memberinfo)d on c.mno=d.mno )g")
    int findByPageTotal();

    /**
     * 分页查询
     */
    @Select(" <script>" +
            " SELECT eno,ename,d.nickName,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from (" +
            " SELECT a.eno,ename,mno,`status`,edate,eheat,epic,edser,tno,ecomcount,tname from ( " +
            " SELECT e1.eno,ename,mno,`status`,edate,eheat,epic,edser,e1.tno,t1.tname from essayinfo as e1 LEFT JOIN essaytype t1 on e1.tno=t1.tno " +
            " )a left join( select eno,count(*)as ecomcount from commentinfo  group by eno)b on a.eno=b.eno" +
            " )c left join (SELECT mno,nickName from memberinfo)d on c.mno=d.mno " +
            " order by eno asc " +
            " <if test='num!=null and pageSize!=null'>" +
            " limit #{num},#{pageSize}" +
            " </if>" +
            " </script>")
    List<Essayinfo> findByPage(@Param("num") Integer num, @Param("pageSize") Integer pageSize);

    /**
     * 首页查询
     * @return
     */
    @Select("select a.eno,a.ename,a.mno,a.status,a.epic,DATE_FORMAT(a.edate,'%m-%d')as edate,a.eheat, " +
            " a.nickName,a.mpic,b.commentcount from((select e.eno,e.ename,e.mno," +
            " e.status,e.epic,e.edate,e.eheat,m.nickName,m.mpic " +
            " from essayinfo e inner join memberinfo m " +
            " on e.mno=m.mno )as a) left join (" +
            " (select eno,count(*)as commentcount from commentinfo group by eno)as b " +
            " )on a.eno=b.eno where 1=1 and a.status=4")
    List<EssayVO> findByEssayInfo();

    /**
     * 首页查询（按照热度）
     * @return
     */
    @Select("select a.eno,a.ename,a.mno,a.status,a.epic,DATE_FORMAT(a.edate,'%m-%d')as edate,a.eheat," +
            " a.nickName,a.mpic,b.commentcount from((select e.eno,e.ename,e.mno," +
            " e.status,e.epic,e.edate,e.eheat,m.nickName,m.mpic" +
            " from essayinfo e inner join memberinfo m " +
            " on e.mno=m.mno )as a) left join ( " +
            " (select eno,count(*)as commentcount from commentinfo group by eno)as b " +
            " )on a.eno=b.eno where 1=1 and a.status!=2 ORDER BY a.eheat desc")
    List<EssayVO> findByEssayHeat();

    /**
     * 首页查询（按照时间）
     * @return
     */
    @Select("select a.eno,a.ename,a.mno,a.status,a.epic,DATE_FORMAT(a.edate,'%m-%d')as edate,a.eheat, " +
            " a.nickName,a.mpic,b.commentcount from((select e.eno,e.ename,e.mno, " +
            " e.status,e.epic,e.edate,e.eheat,m.nickName,m.mpic" +
            " from essayinfo e inner join memberinfo m" +
            " on e.mno=m.mno )as a) left join (" +
            " (select eno,count(*)as commentcount from commentinfo group by eno)as b " +
            " )on a.eno=b.eno where 1=1 and a.status!=2 ORDER BY a.edate desc")
    List<EssayVO> findByEssayTime();


    /**
     * Photrix精选查询
     * @return
     */
    @Select("select a.eno,a.ename,a.mno,a.status,a.epic,DATE_FORMAT(a.edate,'%m-%d')as edate,a.eheat, " +
            " a.nickName,a.mpic,b.commentcount from((select e.eno,e.ename,e.mno," +
            " e.status,e.epic,e.edate,e.eheat,m.nickName,m.mpic " +
            " from essayinfo e inner join memberinfo m " +
            " on e.mno=m.mno )as a) left join (" +
            " (select eno,count(*)as commentcount from commentinfo group by eno)as b" +
            " )on a.eno=b.eno where 1=1 and a.status=3")
    List<EssayVO> findByPhotrix();

}
