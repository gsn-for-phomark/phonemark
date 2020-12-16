package com.gsn.pm.service;


import com.gsn.pm.entity.Memberinfo;

public interface PinfoService {

    /**
     * 绑定用户号码
     * @param t
     * @return
     */
    public int updateTel(Memberinfo t);


}
