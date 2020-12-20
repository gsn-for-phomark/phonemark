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
    public List<EssayComment> findEssayandCommentByEtype(EssayComment t) {
        return essayinfoMapper.findEssayandCommentByEtype(t.getTno());
    }

    @Override
    public List<EssayComment> findEssayandComment() {
        return essayinfoMapper.findEssayandComment();
    }

    @Override
    public List<EssayShow> showEssay(Integer eno) {
        return essayinfoMapper.showEssay(eno);
    }

    @Override
    public List<EssayList> findEssayList(EssayList t) {
        return essayinfoMapper.findEssayList(t.getMno());
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
    public int findByDateAndAnameTotal(String startDate, String endDate, String t) {

        return essayinfoMapper.findByDateAndAnameTotal(startDate,endDate,t);
    }

    @Override
    public List<Essayinfo> findByDateAndAname(String startDate, String endDate, String t, Integer pageNum, Integer pageSize) {
        Integer num=(pageNum-1)*pageSize;
        return essayinfoMapper.findByDateAndAname(startDate,endDate,t,num,pageSize);
    }

    @Override
    public int findByPageTotal( ) {
        return essayinfoMapper.findByPageTotal();
    }

    @Override
    public List<Essayinfo> findByPage( Integer pageNum, Integer pageSize) {
        Integer num=(pageNum-1)*pageSize;
        return essayinfoMapper.findByPage(num,pageSize);
    }

    @Override
    public List<EssayVO> findByEssayInfo() {
        return essayinfoMapper.findByEssayInfo();
    }

    @Override
    public List<EssayVO> findByEssayHeat() {
        return essayinfoMapper.findByEssayHeat();
    }

    @Override
    public List<EssayVO> findByEssayTime() {
        return essayinfoMapper.findByEssayTime();
    }

    @Override
    public List<EssayVO> findByPhotrix() {
        return essayinfoMapper.findByPhotrix();
    }
}
