package com.gsn.pm.service;

import com.gsn.pm.entity.Memberinfo;

public interface MemberService {


    /**
     *  用户注册
     * @param t member 类
     * @return
     */
    public int register(Memberinfo t);


    /**
     * 用户登录
     * @param t
     * @return
     */
    public Memberinfo login(Memberinfo t);




}
