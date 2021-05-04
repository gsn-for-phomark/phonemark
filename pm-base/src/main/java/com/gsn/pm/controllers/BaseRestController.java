package com.gsn.pm.controllers;


import com.google.gson.Gson;
import com.gsn.pm.dao.impl.MemberMapper;
import com.gsn.pm.domain.Token;
import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import com.gsn.pm.util.*;

@RestController
@RequestMapping("/base")
public class  BaseRestController {
    private static Logger logger = LoggerFactory.getLogger(BaseRestController.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private RedisTemplate redisTemplate;




    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    //  @HystrixCommand(fallbackMethod = "errorCallBack")   //模仿没有这个数据时，服务降级
    public CompletableFuture<String> Login(@RequestBody Memberinfo memberinfo) {
        //非阻塞式异步编程方法。因为在web ui的微服务对rest api的调用中将使用这种高并发的编程方法，所以为了保证与调用端保持同步，这里也使用这种方法.
        return CompletableFuture.supplyAsync(() -> {
                    try {

//                Memberinfo bean =parseRequest(request, Memberinfo.class);
                        Memberinfo bean = new Memberinfo();
                        Map<String, Object> map = new HashMap<>();
                        bean.setNickName(memberinfo.getNickName());
                        bean.setPwd(memberinfo.getPwd());
                        String uname = memberinfo.getNickName();
                        String upass = memberinfo.getPwd();
                        System.out.println(bean);
                        Memberinfo member=memberService.login(bean);
                        System.out.println(member);
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
                        }else {
                            if(member.getStatus()==0){

                                //用户被冻结
                                logger.info("登录失败,用户被冻结   -1");
                                map.put("code", -1);
                                map.put("msg","登录失败,用户被冻结");
                                map.put("data", member);
                            }else{
                                //存储登录用户
                                logger.info("登录成功   1");
                                String token = TokenUtil.sign(uname);
                                ValueOperations<String,Memberinfo> valueOperations = redisTemplate.opsForValue();
                                valueOperations.set(token,member,60, TimeUnit.MINUTES);
                                map.put("code", 1);
                                map.put("msg","登录成功");
                                map.put("data", member);
                                map.put("token",token);
                            }
                            return new Gson().toJson(map);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return  null;
        });
    }
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public CompletableFuture<String> check(@RequestBody Token token) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            ValueOperations<String,Memberinfo> valueOperations = redisTemplate.opsForValue();
            //Memberinfo member=(Memberinfo) request.getSession().getAttribute("member");
            logger.info("检查登录");
            Map<String, Object> map = new HashMap<>();
            if((valueOperations.get(token.getToken()))!=null){
                map.put("code", 1);
                map.put("msg","有用户登录");
                map.put("member",valueOperations.get(token.getToken()));
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


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CompletableFuture<String> register(@RequestBody Memberinfo memberinfo) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
//          Memberinfo bean=parseRequest(request, Memberinfo.class);
//            Memberinfo bean = new Memberinfo();
            Map<String, Object> map = new HashMap<>();
            String uname =memberinfo.getNickName();
            String upass =memberinfo.getPwd();
            String uemail =memberinfo.getEmail();
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
                int i=memberService.register(memberinfo);
                logger.info("注册成功   1");
                map.put("code", 1);
                map.put("msg","注册成功");
                map.put("data", memberinfo);
                return new Gson().toJson(map);
            }
        });
    }
}
