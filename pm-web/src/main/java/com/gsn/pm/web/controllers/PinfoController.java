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
    public CompletableFuture<String> updateTel() {
        return pinfoFuture.updateTel();
    }


    @RequestMapping("/email")
    public CompletableFuture<String> updateEmail() {
        return pinfoFuture.updateEmail();
    }

    @RequestMapping("/pwd")
    public CompletableFuture<String> updatePwd() {
        return pinfoFuture.updatePwd();
    }

    @RequestMapping("/finduser")
    public CompletableFuture<String> findUser(){
        return pinfoFuture.findUser();
    }

}
