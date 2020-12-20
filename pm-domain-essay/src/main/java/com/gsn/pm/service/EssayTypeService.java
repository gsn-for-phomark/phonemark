package com.gsn.pm.service;

import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.entity.EssayType;

import java.util.List;

public interface EssayTypeService {

    /**
     * 类型添加
     */
    public int add(EssayType t);

    /**
     * 根据tno查找文章类型表的所有内容
     */
    public List<EssayType> findByTrem(EssayType t);

    /*
     * 查看每个文章类型下的文章数量
     *
     * */
    public List<EssayType> essaytypeTotal();

    /**
     * 根据文章类型名精确查询
     */
    public List<EssayType> findByName (String t);

    /**
     * 常用专题
     */
    public List<ETypeList> favoriteType(ETypeList t);

    /**
     * 文章类型删除
     */
    public int delete(EssayType t);
    /**
     * 分页时总条数
     */
    public int findByPageTotal();

    /**
     * 分页查询
     */
    public List<EssayType> findByPage (Integer pageNum,Integer pageSize);


}
