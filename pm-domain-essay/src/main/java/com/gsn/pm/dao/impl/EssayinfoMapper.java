package com.gsn.pm.dao.impl;

import com.gsn.pm.dao.MisBaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.gsn.pm.entity.Essayinfo;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EssayinfoMapper extends MisBaseMapper<Essayinfo> {

    @Insert("insert into essayinfo(eno, ename, mno,status, edate,eheat,epic,edser,tno,spare1,spare2" +
            ") values(null, #{ename}, #{mno}, 1,NOW(),0,#{epic},#{edesr},#{tno},null,null)")
    public int add(@Param("ename") String ename, @Param("mno") Integer mno, @Param("epic") String epic,@Param("edesr") String edesr
    ,@Param("tno") Integer tno) ;


}
