package com.gsn.pm;


import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.service.MemberService;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestService {

    private static final Logger logger = Logger.getLogger(TestService.class);
    @Autowired
    private MemberService memberService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testLogin() {
        logger.info("调用testLogin");
        Memberinfo memberinfo = new Memberinfo();
        memberinfo.setNickName("harswlgb");
        memberinfo.setPwd("a");
        Memberinfo member = memberService.login(memberinfo);
        System.out.println(member);
    }

    @Test
    public void testRegister() {
        logger.info("调用testRegister");
        Memberinfo memberinfo = new Memberinfo();
        memberinfo.setNickName("三期测试");
        memberinfo.setPwd("a");
        memberinfo.setEmail("harswlgb@123.com");
        int member = memberService.register(memberinfo);
        System.out.println(member);
    }

    @Test
    public void test(){

    }
}
