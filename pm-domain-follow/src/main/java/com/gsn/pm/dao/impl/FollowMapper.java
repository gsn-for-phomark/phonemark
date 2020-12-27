package com.gsn.pm.dao.impl;

import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.entity.FollowList;
import com.gsn.pm.entity.Followinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FollowMapper extends MisBaseMapper<Followinfo> {
    /**
     * 关注数查询
     * select ifnull(count(bno),0) fnum from followinfo where `status`=1 and mno= ? GROUP BY mno
     * @param mno,bno
     * @return
     */
    @Select("select ifnull(count(bno),0) fnum from followinfo where `status`=1 and mno= #{mno} GROUP BY mno " +
            "UNION all  select ifnull(count(bno),0) fnum from followinfo where `status`=2 and mno= #{mno} GROUP BY mno " +
            "UNION all select ifnull(count(mno),0) fnum from followinfo where `status`=2 and bno= #{bno} GROUP BY bno ")
    List<Followinfo> followNum(@Param("mno") Integer mno,@Param("bno") Integer bno);

    /**
     * 粉丝数查询
     * select ifnull(count(bno),0) fnum from followinfo where `status`=1 and bno= ? GROUP BY mno
     * @param mno,bno
     * @return
     */
    @Select("select ifnull(count(bno),0) fnum from followinfo " +
            "where `status`=1 "+"and bno= #{bno} GROUP BY mno " +
            "UNION all  select ifnull(count(bno),0) fnum from followinfo " +
            "where `status`=2 and mno= #{mno} GROUP BY mno " +
            "UNION all select ifnull(count(mno),0) fnum from followinfo " +
            "where `status`=2 and bno= #{bno} GROUP BY bno")
    List<Followinfo> befollowNum(@Param("mno") Integer mno,@Param("bno") Integer bno);

    /**
     * 登录用户与用户个人中心关注用户列表的关注关系查询
     * @param mno,bno
     * @return
     */
    @Select("SELECT status from followinfo"+
            " WHERE 1=1 "+
            " and mno= #{mno}"+
            " and bno= #{bno}"+
            " and `status`=1 UNION all"+
            " SELECT status from followinfo"+
            " WHERE 1=1 "+
            " and mno= #{mno}"+
            " and bno= #{bno}"+
            " and `status`=2 UNION all"+
            " SELECT status from followinfo "+
            " WHERE 1=1 "+
            " and mno= #{mno}"+
            " and bno= #{bno}"+
            " and `status`=2")
    List<Followinfo> findRelation(@Param("mno")Integer mno,@Param("bno")Integer bno);
    /**
     * 判断对方是否为登录用户粉丝
     * @param mno,bno
     * @return
     */
    @Select("select * from followinfo " +
            "where 1=1 " +
            "and mno= #{mno} " +
            "and bno= #{bno} " +
            "and status=1")
    List<Followinfo> checkFollow(@Param("mno")Integer mno,@Param("bno")Integer bno);



    /**
     * 互关
     * @param mno,bno
     * @return
     */
    @Update("update followinfo set status=2 where mno= #{mno} and bno= #{bno} and status=1")
    int add02(@Param("mno")Integer mno,@Param("bno")Integer bno);

    /**
     * 添加关注
     * @param mno,bno
     * insert into followinfo values(null,?,?,0,1)
     */
    @Insert("insert into followinfo values(null, #{mno}, #{bno},0,1)")
    int add(@Param("mno")Integer mno,@Param("bno")Integer bno);

    /**
    * 已关注的取关
    */
    @Delete("delete from followinfo where mno= #{mno} and bno= #{bno} and status= #{status}")
    int delete01(@Param("mno")Integer mno,@Param("bno") Integer bno,@Param("status") Integer status);
    /**
     * 互相关注的取关
     * @param  mno,bno,status
     * @return
     */
    @Update("update followinfo set mno= #{mno},bno= #{bno},status=1 where mno= #{mno} and bno= #{bno} and status= #{status} or mno= #{mno} and bno= #{bno} and status= #{status} ")
    int delete02(@Param("mno")Integer mno,@Param("bno") Integer bno,@Param("mno")Integer mno1,@Param("bno") Integer bno1,@Param("status") Integer status,@Param("mno")Integer mno2,@Param("bno") Integer bno2,@Param("status") Integer status2);

/**
 * 用户粉丝列表
 * @param mno,bno
 * @return
 */
    @Select("<script>"+
            " select  a1.mno as fansno ,a1.nickName,a1.mpic,a1.msign,IFNULL(a1.messaynums,0)  "+
            " messaynums,IFNULL(a1.fnum,0) fnum,IFNULL(a1.bnum,0) bnum from   "+
            " (select m.mno,nickName,mpic,msign,messaynums,f.fnum,b.bnum from memberinfo  m left join (  "+
            " select mno,sum(fnum) as fnum from(   "+
            " select mno,COUNT(bno) fnum from followinfo group by mno union all   "+
            " select bno as mno ,COUNT(mno) fnum from followinfo where status=2 group by bno) a "+
            " group by mno) f on f.mno=m.mno left join (select mno,sum(bnum) as bnum from ( "+
            " select bno as mno,count(mno) bnum from followinfo group by bno union all "+
            " select mno,count(bno) bnum from followinfo where status=2 group by mno) b "+
            " group by mno) b on m.mno=b.mno ) a1 right join (select mno from   "+
            " (select mno from followinfo where 1=1 and "+
            "<if test='bno!=null'>"
            + " bno = #{bno}"
            + "</if>"+
            " union all select bno as mno from followinfo where 1=1 and "+
            "<if test='mno!=null'>"
            + " mno = #{mno}"
            + "</if>"+
            " and status=2) f2 group by mno  ) a2 on a1.mno=a2.mno order by fansno asc "+
            "</script>")
    List<FollowList> findBeFollowedList(@Param("bno")  Integer bno,@Param("mno")Integer mno );
    /**
     * 关注用户列表
     * @param mno,bno
     * @return
     */
    @Select("<script>"+
            " select  a1.mno as follno,a1.nickName,a1.mpic,a1.msign,IFNULL(a1.messaynums,0) "+
            " messaynums,IFNULL(a1.fnum,0) fnum,IFNULL(a1.bnum,0) bnum from  "+
            " (select m.mno,nickName,mpic,msign,messaynums,f.fnum,b.bnum from memberinfo  m left join (  "+
            " select mno,sum(fnum) as fnum from(  "+
            " select mno,COUNT(bno) fnum from followinfo group by mno union all  "+
            " select bno as mno ,COUNT(mno) fnum from followinfo where status=2 group by bno) a "+
            "  group by mno) f on f.mno=m.mno left join (select mno,sum(bnum) as bnum from ( "+
            " select bno as mno,count(mno) bnum from followinfo group by bno union all "+
            " select mno,count(bno) bnum from followinfo where status=2 group by mno) b "+
            " group by mno) b on m.mno=b.mno ) a1 right join (select bno from "+
            " (select bno from followinfo where 1=1 and  "+
            " <if test='mno!=null'>"
            + " mno = #{mno}"
            + "</if>"+
            " union all  select mno as bno from followinfo where 1=1 and"+
            " <if test='bno!=null'>"
            + "  bno = #{bno}"
            + " </if>"+
            "  and status=2) f2 group by bno  ) a2 on a1.mno=a2.bno order by follno asc "+
            " </script>")
    List<FollowList> findFollowList(@Param("mno")Integer mno,@Param("bno") Integer bno);

}
