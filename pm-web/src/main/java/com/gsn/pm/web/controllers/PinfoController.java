package com.gsn.pm.web.controllers;


import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.future.PinfoFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/pinfo")
public class PinfoController {
    private static Logger logger = LoggerFactory.getLogger(PinfoController.class.getName());

    @Autowired
    private PinfoFuture pinfoFuture;


    @RequestMapping("/phone")
    public CompletableFuture<String> updateTel(Integer mno,String tel) {
        return pinfoFuture.updateTel(mno, tel);
    }


    @RequestMapping("/email")
    public CompletableFuture<String> updateEmail(Integer mno,String email) {
        return pinfoFuture.updateEmail(mno, email);
    }

    @RequestMapping("/pwd")
    public CompletableFuture<String> updatePwd(Integer mno,String pwd) {
        return pinfoFuture.updatePwd(mno, pwd);
    }

    @RequestMapping("/finduser")
    public CompletableFuture<String> findUser(Memberinfo t){
        return pinfoFuture.findUser(t);
    }

    @RequestMapping("/doCon")
    public CompletableFuture<String> doCon(Memberinfo t){
        return pinfoFuture.doCon(t);
    }

}
