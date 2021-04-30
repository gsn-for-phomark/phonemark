package com.gsn.pm.web.controllers;


import com.gsn.pm.entity.EssayType;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.future.EssayFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/essay")
public class EssayController {

    private static Logger logger = LoggerFactory.getLogger(EssayController.class.getName());

    @Autowired
    private EssayFuture essayFuture;

    @RequestMapping(value = "/findEinfo" ,method = RequestMethod.GET)
    public CompletableFuture<String> findEssayInfo(){
        return essayFuture.findEssayInfo();
    }

    @RequestMapping(value = "/findEheat",method = RequestMethod.GET)
    public CompletableFuture<String> findEssayHeat(){
        return essayFuture.findEssayHeat();
    }

    @RequestMapping(value = "/findEtime",method = RequestMethod.GET)
    public CompletableFuture<String> findEssayTime(){
        return essayFuture.findEssayTime();
    }

    @RequestMapping(value = "/findPhotrix",method = RequestMethod.GET)
    public CompletableFuture<String> findPhotrix(){
        return essayFuture.findEssayPhotrix();
    }

    @RequestMapping(value = "/findEC",method = RequestMethod.GET)
    public CompletableFuture<String> findEssayAndCommment(){
        return essayFuture.findEssayandComment();
    }

    @RequestMapping(value = "/findECT",method = RequestMethod.GET)
    public CompletableFuture<String> findEssayAndCommmentByTno(Integer tno){
        return essayFuture.findEssayandCommentByEtype(tno);
    }

    @RequestMapping(value = "/showEssay",method = RequestMethod.GET)
    public CompletableFuture<String> showEssayDetail(Integer eno){
        return essayFuture.showEssayDetail(eno);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public CompletableFuture<String> addEssay(@RequestBody Essayinfo t){
        return essayFuture.addEssay(t);
    }

    @RequestMapping(value = "/typeTotal",method = RequestMethod.GET)
    public CompletableFuture<String> essaytypeTotal(){
        return essayFuture.essaytypeTotal();
    }

    @RequestMapping(value = "/findByTno",method = RequestMethod.GET)
    public CompletableFuture<String> findByTnoEssay(Integer tno){
        return essayFuture.findByTnoEssay(tno);
    }

    @RequestMapping(value = "/findUserlist",method = RequestMethod.GET)
    public CompletableFuture<String> findUserList(Integer mno){
        return essayFuture.findUserList(mno);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public CompletableFuture<String> deleteEssay(Integer eno){
        return essayFuture.delete(eno);
    }

    @RequestMapping(value = "/favoriteType",method = RequestMethod.GET)
    public CompletableFuture<String> favoriteType(Integer mno){
        return essayFuture.userfavoriteType(mno);
    }

    @RequestMapping(value = "/addType",method = RequestMethod.POST)
    public CompletableFuture<String> addEssayType(@RequestBody EssayType t){
        return essayFuture.addEssayType(t);
    }



}
