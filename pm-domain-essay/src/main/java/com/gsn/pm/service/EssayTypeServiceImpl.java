package com.gsn.pm.service;

import com.gsn.pm.dao.impl.EssayTypeMapper;
import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.entity.EssayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EssayTypeServiceImpl implements EssayTypeService{

    @Autowired
    private EssayTypeMapper essayTypeMapper;

    @Override
    public int add(EssayType t) {
        return essayTypeMapper.add(t.getTypedesc(),t.getTname());
    }

    @Override
    public List<EssayType> findByTrem(EssayType t) {
        return essayTypeMapper.findByTrem(t.getTno());
    }

    @Override
    public List<EssayType> essaytypeTotal() {
        return essayTypeMapper.essaytypeTotal();
    }

    @Override
    public List<EssayType> findByName(String t) {
        return essayTypeMapper.findByName(t);
    }

    @Override
    public List<ETypeList> favoriteType(ETypeList t) {
        return essayTypeMapper.favoriteType(t.getMno());
    }

    @Override
    public int delete(EssayType t) {
        return essayTypeMapper.deleteByPrimaryKey(t.getTno());
    }

    @Override
    public int findByPageTotal() {
        return essayTypeMapper.findByPageTotal();
    }

    @Override
    public List<EssayType> findByPage(Integer pageNum, Integer pageSize) {
        Integer num=(pageNum-1)*pageSize;
        return essayTypeMapper.findByPage(num,pageSize);
    }


}
