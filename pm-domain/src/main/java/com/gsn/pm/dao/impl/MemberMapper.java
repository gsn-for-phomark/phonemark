package com.gsn.pm.dao.impl;

import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper  extends MisBaseMapper<Member> {
}
