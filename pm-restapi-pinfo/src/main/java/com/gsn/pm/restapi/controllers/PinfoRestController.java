package com.gsn.pm.restapi.controllers;

import com.gsn.pm.service.PinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * pinfo的基本业务
 * 包含：
 *      /pinfo/phone    绑定手机号
 *      /pinfo/email    绑定邮箱
 *      /pinfo/pwd      修改密码
 *      /pinfo/doCon    密码验证
 *      /pinfo/fans     关注与粉丝查询
 *      /pinfo/getEssayNums     计算用户文章
 *      /pinfo/finduser    查找用户
 *      /pinfo/doElist  显示自己发表的文章
 *      /doFavorite     查看个人常用专题
 */
@RestController
@RequestMapping("/pinfo")
public class PinfoRestController {
    
    private static Logger logger= LoggerFactory.getLogger(PinfoRestController.class);
    
    @Autowired
    private PinfoService pinfoService;



    
}
