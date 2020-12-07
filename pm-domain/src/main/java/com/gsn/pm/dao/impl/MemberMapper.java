package com.gsn.pm.dao.impl;

import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.entity.Memberinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper  extends MisBaseMapper<Memberinfo> {


    @Select("SELECT mno,nickName,msex,pwd,tel,email,`status`,mpic,msign,messaynums ,eno,fno,cno,spare1,spare2 from memberinfo" +
            " where 1 = 1 and mno = #{mno} and nickName = #{nickName}  and pwd = MD5(#{pwd})  and tel = #{tel}  and status = #{status}")
    List<Memberinfo> findByTrem(@Param("mno") Integer mno, @Param("nickName") String nickName, @Param("pwd") String pwd, @Param("tel") String tel, @Param("status") Integer status);

}
