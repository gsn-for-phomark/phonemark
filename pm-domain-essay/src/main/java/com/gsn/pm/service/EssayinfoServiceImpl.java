package com.gsn.pm.service;


import com.gsn.pm.dao.impl.EssayinfoMapper;
import com.gsn.pm.domain.EssayComment;
import com.gsn.pm.domain.EssayVO;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.domain.EssayShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EssayinfoServiceImpl implements EssayinfoService{


    @Autowired
    private EssayinfoMapper essayinfoMapper;

    @Override
    public int add(Essayinfo t) {
        return essayinfoMapper.add(t.getEname(),t.getMno(),t.getEpic(),t.getEdser(),t.getTno());
    }

    @Override
    public List<Essayinfo> findByTrem(Essayinfo t) {
        return null;
    }

    @Override
    public int update(Essayinfo t) {
        return 0;
    }

    @Override
    public Map<String, Object> findEssayandCommentByEtype(EssayComment t)  {
        List<EssayComment> list =essayinfoMapper.findEssayandCommentByEtype(t.getTno());
        Map<String, Object>  map = new HashMap<String,Object>();
        map.put("EACByType",list);
        return map;
    }

    @Override
    public Map<String, Object> findEssayandComment() {
        List<EssayComment> list =essayinfoMapper.findEssayandComment();
        Map<String, Object>  map = new HashMap<String,Object>();
        map.put("EAC",list);
        return map;
    }

    @Override
    public Map<String,Object> showEssay(Integer eno) {
        Map<String, Object>  map = new HashMap<String,Object>();
        List<EssayShow> list = essayinfoMapper.showEssay(eno);
        map.put("essay", list);
        return map;
    }

    @Override
    public Map<String, Object> findUserEassy(EssayList t) {
        Map<String, Object> map=new HashMap<String,Object>();
        List<EssayList> list=essayinfoMapper.findEssayList(t.getMno());
        map.put("elist", list);
        System.out.println(list.toString());
        return map;
    }

    @Override
    public int delete(Essayinfo t) {
        return essayinfoMapper.deleteByPrimaryKey(t.getEno());
    }

    @Override
    public int updateStatus(Essayinfo t) {
        return essayinfoMapper.updateStatus(t.getStatus(),t.getEno());
    }



    @Override
    public Map<String,Object> findByDateAndAname(String startDate,String endDate,String t,Integer pageNum,Integer pageSize){
        Integer num=(pageNum-1)*pageSize;
        Map<String, Object>  map = new HashMap<String,Object>();
        List<Essayinfo> list = essayinfoMapper.findByDateAndAname(startDate,endDate,t,num,pageSize);
        System.out.println(list);
        int total = essayinfoMapper.findByDateAndAnameTotal(startDate,endDate,t);
        map.put("essays", list);
        if(null==pageNum){
            return map;
        }
        System.err.println(total);
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
        System.err.println(pageNs);
        map.put("pageNs", pageNs);
        return map;
    }


    @Override
    public Map<String,Object> findByPage(Integer pageNum,Integer pageSize) {
        Integer num=(pageNum-1)*pageSize;
        Map<String, Object>  map = new HashMap<String,Object>();
        List<Essayinfo> list = essayinfoMapper.findByPage(num,pageSize);
        int total = essayinfoMapper.findByPageTotal();
        map.put("essays", list);
        if(null==pageNum){
            return map;
        }
        System.err.println(total);
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
        System.err.println(pageNs);
        map.put("pageNs", pageNs);
        return map;
    }

    @Override
    public Map<String, Object> findEssayInfo( ) {
        List<EssayVO> list = essayinfoMapper.findByEssayInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("infos", list);
        return map;
    }

    @Override
    public Map<String, Object> findEssayHeat() {
        List<EssayVO> list = essayinfoMapper.findByEssayHeat();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("heats", list);
        return map;
    }

    @Override
    public Map<String, Object> findEssayTime() {
        List<EssayVO> list = essayinfoMapper.findByEssayTime();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("times", list);
        return map;
    }

    @Override
    public Map<String, Object> findPhotrix() {
        List<EssayVO> list = essayinfoMapper.findByPhotrix();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("photrix", list);
        return map;
    }
}