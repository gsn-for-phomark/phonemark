package com.gsn.pm.service;


import com.gsn.pm.entity.Followinfo;
import com.gsn.pm.entity.Memberinfo;

import java.util.List;

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
     * 关注和粉丝数查询
     * @param t
     * @return
     */
    List getFansAndFollow(Followinfo t);


}
