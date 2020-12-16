package com.gsn.pm;

import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.service.PinfoService;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

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

}
