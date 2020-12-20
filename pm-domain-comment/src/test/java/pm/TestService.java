package pm;


import com.gsn.pm.entity.Commentinfo;
import com.gsn.pm.entity.Heatinfo;
import com.gsn.pm.service.CommentService;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DaoConfiguration.class})
public class TestService {

    private static final Logger logger = Logger.getLogger(TestService.class);
    @Autowired
    private CommentService commentService;

    /**
     * 测试       添加一级评论
     */
    @Test
    public void testAddCom() {
        logger.info("调用testAddCom");
        Commentinfo commentinfo = new Commentinfo();
        commentinfo.setEno(54);
        commentinfo.setMno(19);
        commentinfo.setCdesr("三期测试评论");
        int code =commentService.addCom(commentinfo);
        System.out.println(code);
    }


    /**
     * 测试       添加二三级评论
     * //t.setEno(),  文章编号
     * t.setMno(),  评论人编号
     * t.setCdesr(),    评论内容
     * t.setFlag(),     评论级数   1，2，3级
     * t.setSpare1(),   String类  二级评论需要   回复的对象cno
     * t.setSpare2()    String类  三级评论需要   回复的对象cno
     */
    @Test
    public void testAddCom2() {
        logger.info("调用testAddCom2");
        Commentinfo commentinfo = new Commentinfo();
        commentinfo.setEno(54);
        commentinfo.setMno(19);
        commentinfo.setCdesr("三期测试三级评论");
        commentinfo.setFlag(2);
        commentinfo.setSpare1("60");
        commentinfo.setSpare2("64");
        int code =commentService.addCom2(commentinfo);
        System.out.println(code);
    }

    /**
     * 测试       查找文章评论
     */
    @Test
    public void testFindCom() {
        logger.info("调用testFindCom");
        Integer eno = 54;
        Map<String, Object> commentList = commentService.findCom(eno);
        System.out.println(commentList);
    }

    /**
     * 测试       查找文章评论总数
     */
    @Test
    public void testCountCom() {
        logger.info("调用testCountCom");
        Integer eno = 54;
        Map<String, Object> countCom = commentService.countCom(eno);
        System.out.println(countCom);
    }

    /**
     * 测试 删除评论
     */
    @Test
    public void testDelCom() {
        logger.info("调用testDelCom");
        Commentinfo commentinfo = new Commentinfo();
        commentinfo.setCno(65);
        int i=commentService.delCom(commentinfo);
        System.out.println(i);
    }

    /**
     * 测试       时间名字综合查询
     * String startDate,
     * String endDate,
     * String t,    模糊查询的文字
     * Integer pageNum,
     * Integer pageSize
     */
    @Test
    public void testFindByDateAndAname() {
        logger.info("调用testFindByDateAndAname");
        String startDate = "2020-1-20";
        String endDate = "2020-9-20";
        String t = "h";
        Integer pageNum =2;
        Integer pageSize=3;
        Map<String, Object>  map = commentService.findByDateAndAname(startDate,endDate,t,pageNum,pageSize);
        System.out.println(map);
    }

    /**
     * 测试       分页查找
     */
    @Test
    public void testFindByPage() {
        logger.info("调用testFindByPage");

        Integer pageNum =2;
        Integer pageSize=3;
        Map<String, Object>  map = commentService.findByPage(pageNum,pageSize);
        System.out.println(map);
    }


    /**
     * 测试点赞
     */
    @Test
    public void testDoHeat() {
        logger.info("调用testDoHeat");
        Heatinfo t = new Heatinfo();
        t.setCno(64);
        t.setEno(54);
        t.setMno(19);
        int i = commentService.doHeat(t);
        System.out.println(i);
    }
}
