package com.gsn.pm.service;

import com.gsn.pm.dao.impl.PinfoMapper;
import com.gsn.pm.entity.Memberinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PinfoServiceImpl implements PinfoService {

    @Autowired
    private PinfoMapper pinfoMapper;

    @Override
    public int updateTel(Memberinfo t) {
        return pinfoMapper.updateTel(t.getMno(),t.getTel());
    }
}
