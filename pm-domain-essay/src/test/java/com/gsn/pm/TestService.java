package com.gsn.pm;


import com.gsn.pm.domain.EssayComment;
import com.gsn.pm.domain.EssayVO;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.domain.EssayShow;
import com.gsn.pm.service.EssayinfoService;
import org.jboss.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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



    @Test
    public void testFindEssayandCommentByEtype(){
        EssayComment ec=new EssayComment();
        ec.setTno(2);
        List<EssayComment> list=essayinfoService.findEssayandCommentByEtype(ec);
        System.out.println(list);
    }

    @Test
    public void testFindEssayandComment(){
        List<EssayComment> list=essayinfoService.findEssayandComment();
        System.out.println(list);
    }

    @Test
    public void testShowEssay(){
        Integer eno=2;
        List<EssayShow> list=essayinfoService.ShowEssay(eno);
        System.out.println(list);
    }

    @Test
    public void testFindEssayList(){
        EssayList el=new EssayList();
        el.setMno(1);
//        el.setEno(2);
        List<EssayList> list=essayinfoService.findEssayList(el);
        System.out.println(list);
    }



    @Test
    public void testDelete(){
        Essayinfo ei=new Essayinfo();
        ei.setEno(55);
        int i=essayinfoService.delete(ei);
        System.out.println(i);
    }

    @Test
    public void testFindByDateAndAnameTotal(){
        String startDate="2020-02-04";
        String endDate="2020-07-01";
        String t="测试";
        int i=essayinfoService.findByDateAndAnameTotal(startDate,endDate,t);
        System.out.println(i);
    }

    @Test
    public void testFindByDateAndAname(){
        String startDate="2020-02-02";
        String endDate="2020-07-02";
        String t="测试";
        Integer pageNum=1;
        Integer pageSize=5;
        List<Essayinfo> list=essayinfoService.findByDateAndAname(startDate,endDate,t,pageNum,pageSize);
        System.out.println(list);
    }
    @Test
    public void testFindByPageTotal(){
        int i=essayinfoService.findByPageTotal();
        System.out.println(i);
    }

    @Test
    public void testFindByPage(){
        Integer pageNum=1;
        Integer pageSize=5;
        List<Essayinfo> list=essayinfoService.findByPage(pageNum,pageSize);
        System.out.println(list);
    }

    @Test
    public void testFindByEssayInfo(){
        List<EssayVO> list=essayinfoService.findByEssayInfo();
        System.out.println(list);
    }

    @Test
    public void testFindByEssayHeat(){
        List<EssayVO> list=essayinfoService.findByEssayHeat();
        System.out.println(list);
    }
    @Test
    public void testFindByEssayTime(){
        List<EssayVO> list=essayinfoService.findByEssayTime();
        System.out.println(list);
    }
    @Test
    public void testFindByPhotrix(){
        List<EssayVO> list=essayinfoService.findByPhotrix();
        System.out.println(list);
    }
}