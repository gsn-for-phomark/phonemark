package com.gsn.pm.dao.impl;

import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.entity.Heatinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface HeatMapper extends MisBaseMapper<Heatinfo> {

    /**
     * 点赞
     * @param eno
     * @param cno
     * @param mno
     * @return
     */
    @Insert("INSERT into heatinfo VALUES(null,#{eno},#{cno},#{mno})")
    int add(@Param("eno") Integer eno, @Param("cno") Integer cno, @Param("mno") Integer mno);

    /**
     *  取消点赞
     * @param eno
     * @param cno
     * @param mno
     * @return
     */
    @Delete("delete from heatinfo where eno=#{eno} and cno=#{cno} and mno=#{mno}")
    int deleteByParam(@Param("eno") Integer eno, @Param("cno") Integer cno, @Param("mno") Integer mno);


    /**
     * 查看点赞
     * @param eno
     * @param cno
     * @param mno
     * @return
     */
    @Select("SELECT * FROM heatinfo WHERE eno=#{eno}  and cno=#{cno} and mno=#{mno} ")
    List<Heatinfo> findByTrem(@Param("eno") Integer eno, @Param("cno") Integer cno, @Param("mno") Integer mno);
}
