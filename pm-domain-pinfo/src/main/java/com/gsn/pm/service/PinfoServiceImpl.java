package com.gsn.pm.service;

import com.gsn.pm.dao.impl.PinfoMapper;
import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.entity.Memberinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class PinfoServiceImpl implements PinfoService {

    @Autowired
    private PinfoMapper pinfoMapper;

    @Override
    public int updateTel(Memberinfo t) {
        return pinfoMapper.updateTel(t.getMno(),t.getTel());
    }

    @Override
    public int updateEmail(Memberinfo t) {
        return pinfoMapper.updateEmail(t.getMno(),t.getEmail());
    }

    @Override
    public int updatePwd(Memberinfo t) {
        return pinfoMapper.updatePwd(t.getMno(),t.getPwd());
    }

    @Override
    public Map<String,Object> countUserEssayNum(Memberinfo t) {
        List<Memberinfo> list= pinfoMapper.countUserEssayNum(t.getMno());
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("EssayNum",list);
        return map;
    }

    @Override
    public Map<String,Object> findUserEssay(EssayList t) {
        Map<String,Object> map=new HashMap<String,Object>();
        List<EssayList> list=pinfoMapper.findEssayList(t.getEno(),t.getMno());
        map.put("elist",list);
        System.out.println(list.toString());
        return map;
    }

    @Override
    public Map<String, Object> FavoriteTypeList(ETypeList t) {
        Map<String,Object> map=new HashMap<String,Object>();
        List<ETypeList> list=pinfoMapper.FavoriteType(t.getMno());
        if(list.size()<=0||list.isEmpty()){
            return null;
        }
        map.put("favorites",list);
        return map;
    }

}
