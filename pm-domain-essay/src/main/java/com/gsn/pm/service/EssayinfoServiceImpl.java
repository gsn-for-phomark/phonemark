package com.gsn.pm.service;


import com.gsn.pm.dao.impl.EssayinfoMapper;
import com.gsn.pm.entity.Essayinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EssayinfoServiceImpl implements EssayinfoService{


    @Autowired
    private EssayinfoMapper essayinfoMapper;
    /**
     * 文章添加
     * @param t
     * @return
     */
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
    public int delete(Essayinfo t) {
        return 0;
    }

    @Override
    public int updateStatus(Essayinfo t) {
        return 0;
    }

    @Override
    public int findByDateAndAnameTotal(String startDate, String endDate, String t) {
        return 0;
    }

    @Override
    public List<Essayinfo> findByDateAndAname(String startDate, String endDate, String t, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public int findByPageTotal(Essayinfo t) {
        return 0;
    }

    @Override
    public List<Essayinfo> findByPage(Essayinfo t, Integer pageNum, Integer pageSize) {
        return null;
    }
}
