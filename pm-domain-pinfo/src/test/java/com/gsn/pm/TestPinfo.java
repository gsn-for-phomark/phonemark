package com.gsn.pm;

import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.service.PinfoService;
import javafx.beans.binding.ObjectExpression;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestPinfo {

    private static final Logger logger = Logger.getLogger(TestPinfo.class);
    @Autowired
    private PinfoService pinfoService;

    @Test
    public void testUpdateTel(){
        logger.info("调用testUpdateTel");
        Memberinfo memberinfo=new Memberinfo();
        memberinfo.setMno(10);
        memberinfo.setTel("12121212");
        int member=pinfoService.updateTel(memberinfo);
        System.out.println(member);
    }

    @Test
    public void testUpdateEmail(){
        logger.info("调用testUpdateEmail");
        Memberinfo memberinfo=new Memberinfo();
        memberinfo.setMno(10);
        memberinfo.setEmail("12121212@qq.com");
        int member=pinfoService.updateEmail(memberinfo);
        System.out.println(member);
    }

    @Test
    public void testUpdatePwd(){
        logger.info("调用testUpdatePwd");
        Memberinfo memberinfo=new Memberinfo();
        memberinfo.setMno(10);
        memberinfo.setPwd("310383");
        int member=pinfoService.updatePwd(memberinfo);
        System.out.println(member);
    }

    @Test
    public void testcountUserEssayNum(){
        logger.info("调用testcountUserEssayNum");
        Memberinfo memberinfo=new Memberinfo();
        memberinfo.setMno(10);
        Map<String ,Object> map=pinfoService.countUserEssayNum(memberinfo);
        System.out.println(map);
    }


    @Test
    public void testfindUserEssay(){
        logger.info("调用testfindUserEssay");
        EssayList essayList=new EssayList();
        essayList.setMno(10);
        Map<String, Object> map=pinfoService.findUserEssay(essayList);
        System.out.println(map);
    }

    @Test
    public void testFavoriteTypeList(){
        logger.info("调用FavoriteTypeList");
        ETypeList list=new ETypeList();
        list.setMno(10);
        Map<String,Object> map=pinfoService.FavoriteTypeList(list);
        System.out.println(map);
    }


}
