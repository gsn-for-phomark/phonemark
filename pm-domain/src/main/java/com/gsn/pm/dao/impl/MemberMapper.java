package com.gsn.pm.dao.impl;

import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.entity.Memberinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper  extends MisBaseMapper<Memberinfo> {


    /**
     * 条件查询
     * @param mno
     * @param nickName
     * @param pwd
     * @param tel
     * @param status
     * @return
     */
    @Select("<script>"+
            "SELECT mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums ,eno,fno,cno,spare1,spare2 from memberinfo" +
            " where 1 = 1 " +
            "<if test='mno!=null'>"
            + "and mno = #{mno}"
            + "</if>"+
            "<if test='nickName!=null'>"
            + "and nickName = #{nickName}"
            + "</if>"+
            "<if test='pwd!=null'>"
            + "and pwd = MD5(#{pwd})"
            + "</if>"+
            "<if test='tel !=null'>"
            + " and tel = #{tel} "
            + "</if>"+
            "<if test='status !=null'>"
            + " and status = #{status} "
            + "</if>"+
            "</script>")
    List<Memberinfo> findByTrem(@Param("mno") Integer mno, @Param("nickName") String nickName, @Param("pwd") String pwd, @Param("tel") String tel, @Param("status") Integer status);

    @Insert("<script>" +
            "insert into memberinfo values(null,#{nickName},'男',MD5(#{pwd}),'未绑定',#{email},1,'img_all.png','这个人很懒什么也没有留下','0',NOW(),null,null,null,null)"+
            "</script>")
    int add( @Param("nickName") String nickName,@Param("pwd") String pwd,@Param("email") String email);


    /**
     * 修改用户状态
     * @param status
     * @param mno
     * @return
     */
    @Select("<script>"
            +"update memberinfo set"
            +"<if test='status!=null'>"
            +" status=#{status}   "
            +"</if> <if test='mno!=null'>"
            +" where mno=#{mno} "
            +"</if>"
            +"</script>")
    int updateStatus(@Param("status") Integer status,@Param("mno") Integer mno);


    /**
     * 用户删除
     * @param mno
     * @return
     */
    @Select("<script>" +
            "delete from memberinfo where" +
            "<if test='mno!=null'>"+
            " mno=#{mno}"+
            "</if>"+
            "</script>")
    int delete(@Param("mno") Integer mno);

    /**
     * 时间和名称的综合查询 总数
     * @param startDate
     * @param endDate
     * @param t
     * @return
     */
    @Select("<script>" +
            " SELECT COUNT(*) from (  SELECT * from ( " +
            " select a.mno,a.nickName,a.msex,a.pwd,a.tel,a.email,a.`status`,a.mpic,a.msign,a.messaynums,a.eno,a.fno,a.cno,a.spare1,a.spare2 FROM( " +
            " select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2" +
            " from memberinfo  where spare1 BETWEEN #{startDate} AND #{endDate} )a " +
            " right join ( select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2 from memberinfo where 1 = 1 and nickName like  concat('%', #{t} ,'%')  order by mno asc " +
            " )b  on a.mno=b.mno )c  WHERE 1=1 and mno IS NOT NULL ) d"+
            "</script>")
    int findByDateAndAnameTotal(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("t") String t);

    /**
     * 时间和名称的综合查询
     * @param startDate
     * @param endDate
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Select("<script>" +
            "SELECT * from (" +
            " select a.mno,a.nickName,a.msex,a.pwd,a.tel,a.email,a.`status`,a.mpic,a.msign,a.messaynums,a.eno,a.fno,a.cno,a.spare1,a.spare2 FROM(" +
            " select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2" +
            " from memberinfo  where spare1 BETWEEN #{startDate} AND #{endDate} )a " +
            " right join ( select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2 from memberinfo where 1 = 1 and nickName like  " +
            " concat('%',#{t},'%')  order by mno asc " +
            " )b  on a.mno=b.mno limit #{pageNum},#{pageSize}" +
            " )c  WHERE 1=1 and mno IS NOT NULL" +
            "</script>")
    List<Memberinfo> findByDateAndAname (@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("t") String t,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    /**
     * 按照时间查询总数
     * @param startDate
     * @param endDate
     * @return
     */
    @Select("<script>" +
            "  SELECT COUNT(*) from (" +
            " select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2 from memberinfo  " +
            " where spare1 BETWEEN #{startDate} and #{endDate} " +
            " order by mno asc )a" +
            "</script>")
    int findByDateTotal(@Param("startDate") String startDate,@Param("endDate") String endDate);

    /**
     *  按照时间查询
     * @param startDate
     * @param endDate
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Select("<script>" +
            " select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2 from memberinfo  " +
            " where spare1 BETWEEN #{startDate} and #{endDate}" +
            " order by mno asc " +
            " limit #{pageNum},#{pageSize}" +
            "</script>")
    List<Memberinfo> findByDate (@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    /**
     * 模糊查询分页时总条数
     * @param t
     * @return where 1 = 1 and
     */
    @Select("<script>" +
            " SELECT COUNT(*) from (" +
            " select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2 from memberinfo " +
            " nickName like  concat('%', #{t},'%')  )a" +
            "</script>")
    int findByAnameTotal(@Param("t") String t);

    /**
     * 根据用户名模糊查询
     * @param t
     * @param pageNum
     * @param pageSize
     * @return where 1 = 1 and
     */
    @Select("<script>" +
            " select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2 from memberinfo " +
            "  nickName like  concat('%',#{t},'%')  order by mno asc " +
            " limit #{pageNum},#{pageSize}" +
            "</script>")
    List<Memberinfo> findByAname (@Param("t") String t,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    /**
     * 分页时总条数
     * @return where 1 = 1
     */
    @Select("<script>" +
            " SELECT COUNT(*) from (" +
            " select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2 from memberinfo  order by mno asc)a " +
            "</script>")
    int findByPageTotal();

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return where 1 = 1
     */
    @Select("<script>" +
            " select mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums,eno,fno,cno,spare1,spare2 from memberinfo " +
            " order by mno asc " +
            " limit #{pageNum},#{pageSize}" +
            "</script>")
    List<Memberinfo> findByPage (@Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize);
}
