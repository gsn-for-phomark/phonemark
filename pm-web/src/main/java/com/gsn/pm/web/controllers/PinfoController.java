package com.gsn.pm.web.controllers;


import com.gsn.pm.entity.Followinfo;
import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.future.PinfoFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public CompletableFuture<String> findUser(@RequestParam("mno")Integer mno){
        return pinfoFuture.findUser(mno);
    }

    @RequestMapping("/doCon")
    public CompletableFuture<String> doCon(Integer mno,String nickName,String pwd,String tel,Integer status){
        return pinfoFuture.doCon(mno, nickName, pwd, tel, status);
    }

    @RequestMapping("/getEssayNums")
    public CompletableFuture<String> getEssayNums(Integer mno){
        return pinfoFuture.getEssayNums(mno);
    }

    @RequestMapping("/fans")
    public CompletableFuture<String> getEssayNums(Integer mno,Integer bno){
        return pinfoFuture.getFans(mno, bno);
    }

}
