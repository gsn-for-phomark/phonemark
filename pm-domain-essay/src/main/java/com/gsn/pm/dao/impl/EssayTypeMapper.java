package com.gsn.pm.dao.impl;

import com.gsn.pm.dao.MisBaseMapper;
import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.entity.EssayType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EssayTypeMapper extends MisBaseMapper<EssayType> {

    /**
     * 添加文章类型
     * @return
     */
    @Insert("insert into essaytype values(null,#{typedesc},#{tname},null,null,null)")
    int add(@Param("typedesc") String typedesc,@Param("tname") String tname);

    /**
     * 根据tno查找文章类型
     * @return
     */
    @Select("select * from essaytype where tno= #{tno}")
    List<EssayType> findByTrem(@Param("tno") Integer tno);


    /*
     * 查看每个文章类型下的文章数量
     *
     * */
    @Select("SELECT tno,tname,COUNT(*) as totalNum from (" +
            " SELECT a.tname,b.tno FROM essayinfo b RIGHT JOIN essaytype a  ON a.tno=b.tno where b.tno is NOT NULL)c GROUP BY tno ")
    List<EssayType> essaytypeTotal();

    /**
     * 根据文章类型名精确查询
     */
    @Select("SELECT tno,typedesc,tname from essaytype  where 1=1 and tname= #{tname}")
    List<EssayType> findByName(@Param("tname") String tname);


    /**
     * 常用专题
     */
    @Select("select e.tno,tname from (" +
            " select mno,tno from essayinfo where 1=1 " +
            " and mno=#{mno} ) e left join essaytype t on e.tno=t.tno  group by e.tno limit 0,5")
    List<ETypeList> favoriteType(@Param("mno") Integer mno);


    /**
     * 分页时总条数
     * @return
     */
    @Select("SELECT COUNT(*) from ( " +
            " select tno,typedesc,tname,eno,spare1,spare2 from essaytype  where 1 = 1  order by tno asc)a")
    int findByPageTotal();


    @Select(" <script>" +
            " select tno,typedesc,tname,eno,spare1,spare2 from essaytype where 1 = 1 " +
            " order by tno asc " +
            " <if test='num!=null and size!=null'>" +
            " limit #{num} ,#{size}" +
            " </if>" +
            " </script>")
    List<EssayType> findByPage(@Param("num") Integer num,@Param("size") Integer size);

}
