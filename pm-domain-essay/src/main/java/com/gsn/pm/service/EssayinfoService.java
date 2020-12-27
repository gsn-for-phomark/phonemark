package com.gsn.pm.service;

import com.gsn.pm.domain.EssayComment;
import com.gsn.pm.domain.EssayVO;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.domain.EssayShow;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EssayinfoService {

    /**
     * 添加文章
     */
    public  int add(Essayinfo t);

    public List<Essayinfo> findByTrem(Essayinfo t);

    public int update(Essayinfo t);

    /**
     * 根据类型
     * 查看文章信息和评论信息
     *
     **/
    public Map<String, Object> findEssayandCommentByEtype(EssayComment t) ;

    /**
     * 查看精选status=3文章信息和评论信息
     **/
    public Map<String, Object> findEssayandComment();


    /**
     * 显示文章详细内容
     */
    public Map<String,Object> showEssay(Integer eno);

    /**
     * 个人中心文章列表
     */
    public Map<String, Object> findUserEassy(EssayList t);

    /**
     * 文章删除
     */

    public int delete(Essayinfo t);

    /**
     * 后端文章状态值的修改
     */
    public int updateStatus(Essayinfo t);


    /**
     * 时间和名称的综合查询
     * @param startDate  开始时间
     * @param endDate	结束时间
     * @param t  查询词缀
     */
    public Map<String,Object> findByDateAndAname(String startDate,String endDate,String t,Integer pageNum,Integer pageSize);



    /**
     * 分页查询
     */
    public Map<String,Object> findByPage(Integer pageNum,Integer pageSize);


    /**
     * 首页查询
     *
     */
    public Map<String, Object> findEssayInfo();

    /**
     * 首页查询（按照热度）
     *
     */
    public Map<String, Object> findEssayHeat( ) ;

    /**
     * 首页查询（按照时间）
     */
    public Map<String, Object> findEssayTime();

    /**
     * Photrix精选查询
     *
     */
    public Map<String, Object> findPhotrix( );

}
