package com.gsn.pm.web.controllers;


import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.future.BaseFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/base")
public class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class.getName());

    @Autowired
    private BaseFuture baseFuture;

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public CompletableFuture<String> Login(@RequestParam String uname, @RequestParam String upass) {
        return baseFuture.Login(uname, upass);
    }


}
