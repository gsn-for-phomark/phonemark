package com.gsn.pm.web.controllers;

import com.gsn.pm.future.EssayFuture;
import com.gsn.pm.future.FollowFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/follow")
public class FollowController {
    private static Logger logger = LoggerFactory.getLogger(FollowController.class.getName());

    @Autowired
    private FollowFuture followFuture;

    @RequestMapping(value = "/checkEssayUser" ,method = RequestMethod.GET)
    public CompletableFuture<String> checkEssayUser(Integer mno,Integer bno){
        return followFuture.checkEssayUser(mno, bno);
    }

    @RequestMapping(value = "/checkFollows" ,method = RequestMethod.GET)
    public CompletableFuture<String> checkFollows(Integer mno,Integer bno){
        return followFuture.checkFollows(mno, bno);
    }

    @RequestMapping(value = "/add02" ,method = RequestMethod.GET)
    public CompletableFuture<String> add02(Integer mno,Integer bno){
        return followFuture.add02(mno, bno);
    }

    @RequestMapping(value = "/addFollow" ,method = RequestMethod.GET)
    public CompletableFuture<String> addFollow(Integer mno,Integer bno){
        return followFuture.addFollow(mno, bno);
    }

    @RequestMapping(value = "/delete01" ,method = RequestMethod.GET)
    public CompletableFuture<String> delete01(Integer mno,Integer bno,Integer status){
        return followFuture.delete01(mno, bno,status);
    }

    @RequestMapping(value = "/delete02" ,method = RequestMethod.GET)
    public CompletableFuture<String> delete02(Integer mno,Integer bno,Integer status){
        return followFuture.delete02(mno, bno,status);
    }

    @RequestMapping(value = "/findFollow" ,method = RequestMethod.GET)
    public CompletableFuture<String> findFollow(Integer mno){
        return followFuture.findFollow(mno);
    }
    @RequestMapping(value = "/findBeFollowed" ,method = RequestMethod.GET)
    public CompletableFuture<String> findBeFollowed(Integer mno){
        return followFuture.findBeFollowed(mno);
    }


}
