package com.gsn.pm.service;

import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.entity.EssayType;

import java.util.List;
import java.util.Map;

public interface EssayTypeService {

//    /**
//     * 类型添加
//     */
//    public int add(EssayType t);

    /**
     * 在发表文章中添加文章类型           判断是否已存在改文章类型
     * @param t
     * @return
     * @throws Exception
     */
    public int addTypeInEssay(EssayType t);

    /**
     * 根据tno查找文章类型表的所有内容
     */
    public Map<String, Object> findByTrem(EssayType t );

    /*
     * 查看每个文章类型下的文章数量
     *
     * */
    public Map<String, Object> essaytypeTotal( );

    /**
     * 根据文章类型名精确查询
     */
    public List<EssayType> findByName (String tname);

    /**
     * 常用专题
     */
    public Map<String, Object> favoriteTypeList(ETypeList t);

    /**
     * 文章类型删除
     */
    public int delete(EssayType t);

    /**
     * 分页查询
     */
    public Map<String,Object> findByPage(Integer pageNum,Integer pageSize);


}
