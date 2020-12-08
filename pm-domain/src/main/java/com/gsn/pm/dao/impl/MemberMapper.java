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

}
