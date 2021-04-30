package com.gsn.pm.service;

import com.gsn.pm.dao.impl.CommentMapper;
import com.gsn.pm.dao.impl.HeatMapper;
import com.gsn.pm.entity.Commentinfo;
import com.gsn.pm.entity.Heatinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private HeatMapper heatMapper;

    /**
     * 添加一级评论
     * @param t
     * @return
     */
    @Override
    public int addCom(Commentinfo t) {
        return commentMapper.add(t.getEno(),t.getMno(),t.getCdesr());
    }

    /**
     * 添加二三级评论
     * @param t
     * @return
     */
    @Override
    public int addCom2(Commentinfo t) {
        return commentMapper.add2(t.getEno(),t.getMno(),t.getCdesr(),t.getFlag(),t.getSpare1(),t.getSpare2());
    }

    /**
     * 查找文章评论
     * @param eno
     * @return
     */
    @Override
    public Map<String, Object> findCom(Integer eno) {
        Map<String, Object>  map = new HashMap<>();
        List<Commentinfo> list  = commentMapper.findLevel1Com(eno);
        for(Commentinfo c:list){
            Integer cno1=c.getCno();
            List<Commentinfo> list2 = commentMapper.findLevel2Com(eno, cno1);
            c.setLevel2com(list2);
        }
        map.put("comments",list );
        return map;
    }


    /**
     * 计算文章评论数
     * @param eno
     * @return
     */
    @Override
    public Map<String, Object> countCom(Integer eno) {
        Map<String, Object>  map = new HashMap<String,Object>();

        Integer i = commentMapper.countCom(eno);
        if(i==null){
            i=0;
        }
        map.put("countCom", i);
        return map;
    }

    /**
     * 删除评论
     * @param t
     * @return
     */
    @Override
    public int delCom(Integer cno) {
        return commentMapper.deleteByPrimaryKey(cno);
    }

    /**
     * 时间名字综合查询
     * @param startDate
     * @param endDate
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> findByDateAndAname(String startDate, String endDate, String t, Integer pageNum, Integer pageSize) {
        Map<String, Object>  map = new HashMap<String,Object>();
        List<Commentinfo> list = commentMapper.findByDateAndAname(startDate, endDate, t, (pageNum-1)*pageSize, pageSize);
        System.out.println(list);
        int total = commentMapper.findByDateAndAnameTotal(startDate, endDate, t);
        map.put("comments", list);
        if(null==pageNum){
            return map;
        }
        int maxPage =0;
        if(total%pageSize==0){
            maxPage = total/pageSize;
        }else{
            maxPage = total/pageSize+1;
        }
        map.put("maxPage", maxPage);
        int pageNs[] = new int[maxPage] ;
        for(int i=1;i<=maxPage;i++){
            pageNs[i-1]=i;
        }
        map.put("pageNs", pageNs);
        return map;
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> findByPage( Integer pageNum, Integer pageSize) {
        Map<String, Object>  map = new HashMap<String,Object>();
        List<Commentinfo> list = commentMapper.findByPage((pageNum-1)*pageSize, pageSize);
        int total = commentMapper.findByPageTotal();
        map.put("comments", list);
        if(null==pageNum){
            return map;
        }
        int maxPage =0;
        if(total%pageSize==0){
            maxPage = total/pageSize;
        }else{
            maxPage = total/pageSize+1;
        }
        map.put("maxPage", maxPage);
        int pageNs[] = new int[maxPage] ;
        for(int i=1;i<=maxPage;i++){
            pageNs[i-1]=i;
        }
        map.put("pageNs", pageNs);
        return map;
    }

    /**
     * 点赞操作
     * @param t
     * @return
     */
    @Override
    public int doHeat(Heatinfo t) {
        List<Heatinfo> list =heatMapper.findByTrem(t.getEno(),t.getCno(),t.getMno());
        if(list.size()==0){
            //System.out.println(list);
            //System.out.println("add");
            int i=heatMapper.add(t.getEno(),t.getCno(),t.getMno());
            return 1;
        }else{
            //System.out.println(list);
            //System.out.println("delete");
            int i=heatMapper.deleteByParam(t.getEno(),t.getCno(),t.getMno());
            return 2;
        }
    }
}
