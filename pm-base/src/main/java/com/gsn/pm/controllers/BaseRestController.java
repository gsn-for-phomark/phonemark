package com.gsn.pm.controllers;


import com.google.gson.Gson;
import com.gsn.pm.dao.impl.MemberMapper;
import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/base")
public class BaseRestController {
    private static Logger logger = LoggerFactory.getLogger(BaseRestController.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberMapper memberMapper;


    @RequestMapping(value = "/Login")
    //  @HystrixCommand(fallbackMethod = "errorCallBack")   //模仿没有这个数据时，服务降级
    public CompletableFuture<String> Login(HttpServletRequest request, HttpServletResponse response) {
        //非阻塞式异步编程方法。因为在web ui的微服务对rest api的调用中将使用这种高并发的编程方法，所以为了保证与调用端保持同步，这里也使用这种方法. 
        return CompletableFuture.supplyAsync(() -> {
//                Memberinfo bean =parseRequest(request, Memberinfo.class);
                Memberinfo bean = new Memberinfo();
                Map<String, Object> map = new HashMap<>();
                String uname =request.getParameter("uname");
                String upass =request.getParameter("upass");
                bean.setNickName(uname);
                bean.setPwd(upass);
                System.out.println(bean);
                Memberinfo member=memberService.login(bean);
                System.out.println(member);
                HttpSession session = request.getSession();
                if((uname==""||upass=="")||(uname==null||upass==null)){
                    //账号密码为空
                    logger.info("登录失败,账号密码为空   2");
                    map.put("code", 2);
                    map.put("msg","登录失败,账号密码为空");
                    map.put("data", member);
                    return new Gson().toJson(map);

                }else if(null==member){
                    //账号密码错误
                    logger.info("登录失败,账号密码错误   0");
                    map.put("code", 0);
                    map.put("msg","登录失败,账号密码错误");
                    map.put("data", member);
                    return new Gson().toJson(map);
                }else if(member.getStatus()==0){

                    //用户被冻结
                    logger.info("登录失败,用户被冻结   -1");
                    map.put("code", -1);
                    map.put("msg","登录失败,用户被冻结");
                    map.put("data", member);
                    return new Gson().toJson(map);
                }else{
                    //存储登录用户
                    logger.info("登录成功   1");
                    session.setAttribute("member", member);
                    map.put("code", 1);
                    map.put("msg","登录成功");
                    map.put("data", member);
                    return new Gson().toJson(map);
                }
        });
    }

    //    //指定一个降级的方法
//    public String errorCallBack(@PathVariable("id") Integer id) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", 404);
//        map.put("msg", "查无此图片");
//        //map.put("msg","");
//        return new Gson().toJson(map);
//    }
    @RequestMapping(value = "/check",method = RequestMethod.GET)
    public CompletableFuture<String> check(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            Memberinfo member=(Memberinfo) request.getSession().getAttribute("member");
            logger.info("检查登录");
            Map<String, Object> map = new HashMap<>();
            if(member!=null){
                map.put("code", 1);
                map.put("msg","有用户登录");
                logger.info("有用户登录1");
                return new Gson().toJson(map);
            }else {
                map.put("code", 0);
                map.put("msg","无用户登录");
                logger.info("无用户登录0");
                return new Gson().toJson(map);
            }
        });
    }


    @RequestMapping(value = "/register")
    public CompletableFuture<String> register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
//          Memberinfo bean=parseRequest(request, Memberinfo.class);
            Memberinfo bean = new Memberinfo();
            Map<String, Object> map = new HashMap<>();
            String uname =request.getParameter("uname");
            String upass =request.getParameter("upass");
            String uemail =request.getParameter("uemail");
            bean.setNickName(uname);
            bean.setPwd(upass);
            bean.setEmail(uemail);
            List<Memberinfo> list = memberMapper.findByTrem(null,uname,null,null,null);//查找用户名是否被注册
            if((uname==""||upass==""||uemail=="")||(uname==null||upass==null||uemail==null)){
                logger.info("注册失败,必填中项有为空值   2");
                map.put("code", 2);
                map.put("msg","注册失败,必填中项有为空值");
                return new Gson().toJson(map);
            }else if(1==list.size()){
                logger.info("注册失败,用户名已被注册   3");
                map.put("code", 3);
                map.put("msg","注册失败,用户名已被注册");
                return new Gson().toJson(map);
            }else{
                int i=memberService.register(bean);
                logger.info("注册成功   1");
                map.put("code", 1);
                map.put("msg","注册成功");
                map.put("data", bean);
                return new Gson().toJson(map);
            }
        });
    }
}
