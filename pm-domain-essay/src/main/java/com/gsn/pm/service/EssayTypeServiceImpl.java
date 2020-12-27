package com.gsn.pm.service;

import com.gsn.pm.dao.impl.EssayTypeMapper;
import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.entity.EssayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EssayTypeServiceImpl implements EssayTypeService{

    @Autowired
    private EssayTypeMapper essayTypeMapper;

//    @Override
//    public int add(EssayType t) {
//        return essayTypeMapper.add(t.getTypedesc(),t.getTname());
//    }

    @Override
    public int addTypeInEssay(EssayType t) {
        List<EssayType> list = essayTypeMapper.findByName(t.getTname());
        if(list.size()==1){
            return list.get(0).getTno();
        }
        t.setTypedesc("暂无描述");
        return essayTypeMapper.add(t.getTypedesc(),t.getTname());
    }

    @Override
    public Map<String, Object> findByTrem(EssayType t) {
        List<EssayType> list =essayTypeMapper.findByTrem(t.getTno());
        Map<String, Object>  map = new HashMap<String,Object>();
        map.put("typeList",list);
        return map;
    }

    @Override
    public Map<String, Object> essaytypeTotal() {
        List<EssayType> list =essayTypeMapper.essaytypeTotal();
        Map<String, Object>  map = new HashMap<String,Object>();
        map.put("typeTotal",list);
        return map;
    }

//    @Override
//    public List<EssayType> findByName(String t) {
//        return essayTypeMapper.findByName(t);
//    }

    @Override
    public Map<String, Object> favoriteTypeList(ETypeList t) {
        Map<String, Object> map=new HashMap<String,Object>();
        List<ETypeList> list=essayTypeMapper.favoriteType(t.getMno());
        if(list.size()<=0||list.isEmpty()){
            return null;
        }
        map.put("favorites", list);
        return map;
    }

    @Override
    public int delete(EssayType t) {
        return essayTypeMapper.deleteByPrimaryKey(t.getTno());
    }

    @Override
    public Map<String,Object> findByPage(Integer pageNum,Integer pageSize) {
        Integer num=(pageNum-1)*pageSize;
        Map<String, Object>  map = new HashMap<String,Object>();
        List<EssayType> list = essayTypeMapper.findByPage(num,pageSize);
        int total = essayTypeMapper.findByPageTotal();
        map.put("types", list);
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


}
