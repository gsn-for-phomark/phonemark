package com.gsn.pm.dao.impl;


import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.entity.Memberinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PinfoMapper extends MisBaseMapper<Memberinfo> {

    @Update("update memberinfo set tel=#{tel} where mno=#{mno}")
    int updateTel(@Param("mno") Integer mno, @Param("tel")String tel);

}
