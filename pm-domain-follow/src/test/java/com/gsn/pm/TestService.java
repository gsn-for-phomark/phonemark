package com.gsn.pm;

import com.gsn.pm.dao.impl.FollowMapper;
import com.gsn.pm.entity.FollowList;
import com.gsn.pm.entity.Followinfo;
import com.gsn.pm.service.FollowService;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestService {
    private static final Logger logger = Logger.getLogger(TestService.class);
    @Autowired
    private FollowService followService;

    @Test
    public void TestFindFollowNum(){
        logger.info("调用TestFindFollowNum");
        Followinfo followinfo =new Followinfo();
        followinfo.setMno(3);
        followinfo.setBno(1);
        Map<String,Object> map=followService.findFollowNum(followinfo);
        System.out.println(map);


    }

    @Test
    public  void  TestCheckEssayUser(){
        logger.info("调用TestCheckEssayUser");
        Followinfo followinfo1 =new Followinfo();
        followinfo1.setMno(2);
        followinfo1.setBno(3);
        Map<String,Object> map2=followService.checkEssayUser(followinfo1);
        System.out.println(map2);
    }

    @Test
    public  void  TestCheckFollows(){
        logger.info("调用TestCheckFollows");
        Followinfo followinfo2 =new Followinfo();
        followinfo2.setMno(2);
        followinfo2.setBno(9);
        Map<String,Object> map3=followService.checkFollows(followinfo2);
        System.out.println(map3);
    }

    @Test
    public void  Testadd02(){
        logger.info("调用Testadd02");
        Followinfo followinfo3 =new Followinfo();
        followinfo3.setMno(2);
        followinfo3.setBno(9);
        Integer  info =followService.add02(followinfo3);
        System.out.println(info);
    }
    @Test
    public  void  TestAddFollow(){
        logger.info("调用TestAddFollow");
        Followinfo followinfo4 =new Followinfo();
        followinfo4.setMno(12);
        followinfo4.setBno(10);
        Integer info2 =followService.addFollow(followinfo4);
        System.out.println(info2);
    }
    @Test
    public  void  TestDelete01(){
        logger.info("调用TestDelete01");
        Followinfo followinfo5 =new Followinfo();
        followinfo5.setMno(12);
        followinfo5.setBno(10);
        followinfo5.setStatus(1);
        Integer info3 =followService.delete01(followinfo5);
        System.out.println(info3);
    }

    @Test
    public  void  TestDelete02(){
        logger.info("调用TestDelete02");
        Followinfo followinfo6 =new Followinfo();
        followinfo6.setMno(2);
        followinfo6.setBno(9);
        followinfo6.setStatus(1);
        followinfo6.setMno(2);
        followinfo6.setBno(9);
        followinfo6.setStatus(2);
        Integer info4 =followService.delete02(followinfo6);
        System.out.println(info4);

    }
    @Test
    public void TestFindFollow(){
        logger.info("调用TestFindFollow");
        FollowList followList = new FollowList();
        followList.setFollno(1);
        Map<String, Object> map=followService.findFollow(followList,1);
        System.out.println(map.toString());
//        Map<String,Object> map2=followService.findFollow(followinfo7.getBno(),followinfo7.getMno());

    }
    @Test
    public  void  TestFindBeFollowed(){
        logger.info("调用TestFindFollow");
        FollowList followList = new FollowList();
        followList.setFansno(1);
        Map<String, Object> map=followService.findBeFollowed(followList,1);
        System.out.println(map.toString());


    }


}
