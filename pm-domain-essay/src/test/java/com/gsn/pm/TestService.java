package com.gsn.pm;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.service.EssayinfoService;
import org.jboss.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestService {

    private static final Logger logger = Logger.getLogger(TestService.class);
    @Autowired
    private EssayinfoService essayinfoService;


    /**
     * 微服务测试
     */
    @Test
    public void testAddEssay(){
        Essayinfo essayinfo=new Essayinfo();
        essayinfo.setEname("微服务文章测试");
        essayinfo.setMno(1);
        essayinfo.setEpic("D://steam");
        essayinfo.setEdser("就这");
        essayinfo.setTno(2);
        int i=essayinfoService.add(essayinfo);
        System.out.println("添加文章状态返回："+i);
    }
}