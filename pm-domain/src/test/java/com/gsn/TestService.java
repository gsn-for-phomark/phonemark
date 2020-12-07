package com.gsn;



import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.service.MemberService;
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
    private MemberService memberService;

    @Test
    public void testList() {
        logger.info("调用MemberService");
        Memberinfo memberinfo = new Memberinfo();
        memberinfo.setNickName("harswlgb");
        memberinfo.setPwd("a");
        Memberinfo member = memberService.login(memberinfo);
        System.out.println(member);
    }

    @Test
    public void findMember() {
        logger.info("调用findMember");
        Memberinfo memberinfo = new Memberinfo();
        memberinfo.setNickName("harswlgb");
        memberinfo.setPwd("a");
        Memberinfo member = memberService.login(memberinfo);
        System.out.println(member);
    }
}
