package com.gsn.pm.web.controllers;


import com.alibaba.druid.support.json.JSONUtils;
import com.gsn.pm.domain.Token;
import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.future.BaseFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/base")
public class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class.getName());

    @Autowired
    private BaseFuture baseFuture;

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public CompletableFuture<String> Login(@RequestBody Memberinfo memberinfo) {
        return baseFuture.Login(memberinfo);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CompletableFuture<String> register(@RequestBody Memberinfo memberinfo) {
        return baseFuture.register(memberinfo);
    }

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public CompletableFuture<String> check(@RequestBody Token token){
//        HashMap s = (HashMap)JSONUtils.toJSONString(token);
        System.out.println("BaseController.check"+token);
        return baseFuture.check(token);
    }


}
