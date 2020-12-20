package com.gsn.pm.controllers;


import com.google.gson.Gson;
import com.gsn.pm.entity.Commentinfo;
import com.gsn.pm.entity.Heatinfo;
import com.gsn.pm.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/comment")
public class CommentRestController {
    private static Logger logger = LoggerFactory.getLogger(CommentRestController.class);

    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public CompletableFuture<String> doAdd(Integer eno,String cdesr,Integer mno) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            Commentinfo comment= new Commentinfo();
            comment.setEno(eno);
            comment.setCdesr(cdesr);
            comment.setMno(mno);
            Map<String, Object> map = new HashMap<>();
            int i =commentService.addCom(comment);
            if(i==1){
                logger.info("一级评论发表成功   1");
                map.put("code", 1);
                map.put("msg","一级评论发表成功");
                map.put("data", comment);
                return new Gson().toJson(map);
            }else{
                logger.info("一级评论发表失败   0");
                map.put("code", 0);
                map.put("msg","一级评论发表失败");
                map.put("data", comment);
                return new Gson().toJson(map);
            }

        });
    }


    @RequestMapping(value = "/add2and3",method = RequestMethod.GET)
    public CompletableFuture<String> doAdd2and3(Integer eno,String cdesr,Integer mno,Integer flag,String spare1,String spare2) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            Commentinfo comment= new Commentinfo();
            comment.setEno(eno);
            comment.setCdesr(cdesr);
            comment.setMno(mno);
            comment.setFlag(flag);
            comment.setSpare2(spare2);
            comment.setSpare1(spare1);
            Map<String, Object> map = new HashMap<>();
            int i =commentService.addCom2(comment);
            if(i==1){
                logger.info("二三级评论发表成功   1");
                map.put("code", 1);
                map.put("msg","二三级评论发表成功");
                map.put("data", comment);
                return new Gson().toJson(map);
            }else{
                logger.info("二三级评论发表失败   0");
                map.put("code", 0);
                map.put("msg","二三级评论发表失败");
                map.put("data", comment);
                return new Gson().toJson(map);
            }

        });
    }


    /**
     * 文章评论总数
     * @param eno
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/countCom",method = RequestMethod.GET)
    public CompletableFuture<String> countCom(Integer eno) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> data = commentService.countCom(eno);
            if(data!=null){
                logger.info("文章评论数查找成功   1");
                map.put("code", 1);
                map.put("msg","文章评论数查找成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("文章评论数查找失败   0");
                map.put("code", 0);
                map.put("msg","文章评论数查找失败");
                map.put("data",data);
                return new Gson().toJson(map);
            }

        });
    }


    @RequestMapping(value = "/showCom",method = RequestMethod.GET)
    public CompletableFuture<String> showCom(Integer eno) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> data = commentService.findCom(eno);
            if(data!=null){
                logger.info("文章评论查找成功   1");
                map.put("code", 1);
                map.put("msg","文章评论查找成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("文章评论查找失败   0");
                map.put("code", 0);
                map.put("msg","文章评论查找失败");
                map.put("data",data);
                return new Gson().toJson(map);
            }

        });
    }


    @RequestMapping(value = "/heat",method = RequestMethod.GET)
    public CompletableFuture<String> doHeat(Integer eno,Integer cno,Integer mno) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            Heatinfo doheat = new Heatinfo();
            doheat.setMno(mno);
            doheat.setEno(eno);
            doheat.setCno(cno);
            Map<String, Object> map = new HashMap<>();
            int data = commentService.doHeat(doheat);
            if(data==1){
                logger.info("评论点赞成功   1");
                map.put("code", 1);
                map.put("msg","评论点赞成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else if(data==2){
                logger.info("评论取消点赞成功  2");
                map.put("code", 0);
                map.put("msg","评论取消点赞成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("评论点赞失败   0");
                map.put("code", 0);
                map.put("msg","评论点赞失败");
                map.put("data",data);
                return new Gson().toJson(map);
            }

        });
    }


}
