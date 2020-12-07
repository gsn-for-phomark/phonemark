package com.gsn.pm.service;

import com.gsn.pm.dao.impl.MemberMapper;
import com.gsn.pm.entity.Memberinfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int register(Memberinfo t) {

        return 0;
    }

    @Transactional(readOnly = true)
    @Override
    public Memberinfo login(Memberinfo t) {
        List<Memberinfo> list = memberMapper.findByTrem(t.getMno(),t.getNickName(),t.getPwd(),t.getTel(),t.getStatus());
        if(null!=list&&list.size()==1){
            return list.get(0);
        }else if(list.size()>1||list.size()<0||list==null){
            return null;
        }
        return null;
    }


}
