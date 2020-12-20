package com.gsn.pm.dao.impl;


import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.entity.Followinfo;
import com.gsn.pm.entity.Memberinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PinfoMapper extends MisBaseMapper<Memberinfo> {

    /**
     *  绑定手机号
     * @param mno
     * @param tel
     * @return
     */
    @Update("update memberinfo set tel=#{tel} where mno=#{mno}")
    int updateTel(@Param("mno") Integer mno, @Param("tel")String tel);

    /**
     * 绑定邮箱
     * @param mno
     * @param email
     * @return
     */
    @Update("update memberinfo set email=#{email} where mno=#{mno}")
    int updateEmail(@Param("mno")Integer mno,@Param("email")String email);

    /**
     * 修改密码
     * @param mno
     * @param pwd
     * @return
     */
    @Update("update memberinfo set pwd=MD5(#{pwd}) where mno=#{mno}")
    int updatePwd(@Param("mno")Integer mno,@Param("pwd")String pwd);

    /**
     * 查询关注数
     * @param mno
     * @param bno
     * @return
     */
    @Select("select ifnull(count(bno),0) fnum from followinfo where `status`=1 and mno= #{mno} GROUP BY mno " +
            "UNION all  select ifnull(count(bno),0) fnum from followinfo where `status`=2 and mno= #{mno} GROUP BY mno  " +
            "UNION all select ifnull(count(mno),0) fnum from followinfo where `status`=2 and bno= #{bno} GROUP BY bno ")
    List<Followinfo> followNum(@Param("mno")Integer mno,@Param("bno")Integer bno) ;

    /**
     * 查询粉丝数
     * @param mno
     * @param bno
     * @return
     */
    @Select(" select ifnull(count(bno),0) fnum from followinfo where `status`=1 and bno= #{bno} GROUP BY mno " +
            " UNION all  select ifnull(count(bno),0) fnum from followinfo where `status`=2 and mno= #{mno} GROUP BY mno " +
            " UNION all select ifnull(count(mno),0) fnum from followinfo where `status`=2 and bno= #{bno} GROUP BY bno ")
    List<Followinfo> befollowNum(@Param("mno")Integer mno,@Param("bno")Integer bno) ;

}
