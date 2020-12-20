package com.gsn.pm;

import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.entity.EssayType;
import com.gsn.pm.service.EssayTypeService;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestEssayType {

    private static final Logger logger = Logger.getLogger(TestEssayType.class);
    @Autowired
    private EssayTypeService essayTypeService;

    @Test
    public void testAdd()
    {
        EssayType et=new EssayType();
        et.setTypedesc("非洲一霸");
        et.setTname("菠萝");
        int i=essayTypeService.add(et);
        System.out.println(i);
    }

    @Test
    public void testFindBytrem(){
        EssayType et=new EssayType();
        et.setTno(1);
        List<EssayType> list=essayTypeService.findByTrem(et);
        System.out.println(list);
    }

    @Test
    public void testEssaytypeTotal(){
        List<EssayType> list=essayTypeService.essaytypeTotal();
        System.out.println(list);
    }

    @Test
    public void testFindByName(){
        List<EssayType> list=essayTypeService.findByName("系统");
        System.out.println(list);
    }

    @Test
    public void testFavoriteType(){
        ETypeList ep=new ETypeList();
        ep.setMno(1);
        List<ETypeList> list=essayTypeService.favoriteType(ep);
        System.out.println(list);
    }

    @Test
    public void testDelete(){
        EssayType ep=new EssayType();
        ep.setTno(17);
        int i=essayTypeService.delete(ep);
        System.out.println(i);
    }

    @Test
    public void testFindByPageTotal(){
        int i=essayTypeService.findByPageTotal();
        System.out.println(i);
    }

    @Test
    public void testFindByPage(){
        Integer pageNum=1;
        Integer pageSize=6;
        List<EssayType> list=essayTypeService.findByPage(pageNum,pageSize);
        System.out.println(list);
    }
}
