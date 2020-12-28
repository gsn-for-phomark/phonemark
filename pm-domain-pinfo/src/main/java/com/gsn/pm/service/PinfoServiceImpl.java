package com.gsn.pm.service;

import com.gsn.pm.dao.impl.MemberMapper;
import com.gsn.pm.dao.impl.PinfoMapper;
import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.entity.Memberinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class PinfoServiceImpl implements PinfoService {

    @Autowired
    private PinfoMapper pinfoMapper;

    @Autowired
    private MemberMapper memberMapper;

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

    /**
     * 用户查询
     * @param t
     * @return
     */
    @Override
    public Map<String, Object> findIndex(Memberinfo t) {
        List<Memberinfo> list=memberMapper.findByTrem(t.getMno(),t.getNickName(),t.getPwd(),t.getTel(),t.getStatus());
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("user",list);
        return map;
    }

    /**
     * 密码验证
     */
    @Override
    public Map<String,Object> doConn(Memberinfo t) {
        List<Memberinfo> list= memberMapper.findByTrem(t.getMno(),t.getNickName(),t.getPwd(),t.getTel(),t.getStatus());
        if(null!=list&&list.size()==1){
            return (Map<String, Object>) list.get(0);
        }else if(list.size()>1||list.size()<0||list==null){
            return null;
        }
        return null;

    }



}
