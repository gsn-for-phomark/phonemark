package com.gsn.pm.service;


import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.entity.Followinfo;
import com.gsn.pm.entity.Memberinfo;

import java.util.List;
import java.util.Map;

public interface PinfoService {

    /**
     * 绑定用户号码
     * @param t
     * @return
     */
    int updateTel(Memberinfo t);

    /**
     * 绑定邮箱
     * @param t
     * @return
     */
    int updateEmail(Memberinfo t);

    /**
     * 修改密码
     * @param t
     * @return
     */
    int updatePwd(Memberinfo t);

    /**
     * 计算用户写的文章数
     * @param t
     * @return
     */
    Map<String,Object> countUserEssayNum(Memberinfo t);

    /**
     * 粉丝数查询
     * @param t
     * @return
     */
    Map<String,Object> followNum(Followinfo t);

    /**
     * 个人中心文章查询
     * @param t
     * @return
     */
    Map<String,Object> findUserEssay(EssayList t);

    /**
     * 常用专题
     * @param t
     * @return
     */
    Map<String, Object> FavoriteTypeList(ETypeList t);

    /**
     * 查询用户
     * @param t
     * @return
     */
    Map<String, Object> findIndex(Memberinfo t);


    /**
     * 密码验证
     * @param t
     * @return
     */
    Map<String, Object> doConn(Memberinfo t);


}
