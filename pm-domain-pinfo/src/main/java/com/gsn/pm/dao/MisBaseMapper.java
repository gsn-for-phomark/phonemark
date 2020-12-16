package com.gsn.pm.dao;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.MySqlMapper;

//通用的操作接口：这个通用操作接口必须在不同的包中（与其他的Mapper不在一起）
public interface MisBaseMapper<T> extends BaseMapper<T>, ExampleMapper<T>, MySqlMapper {
}
