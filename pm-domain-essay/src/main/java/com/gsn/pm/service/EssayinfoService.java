package com.gsn.pm.service;

import com.gsn.pm.domain.EssayComment;
import com.gsn.pm.domain.EssayVO;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.domain.EssayShow;

import java.sql.SQLException;
import java.util.List;

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
    public List<EssayComment> findEssayandCommentByEtype(EssayComment t);

    /**
     * 查看精选status=3文章信息和评论信息
     **/
    public List<EssayComment> findEssayandComment();


    /**
     * 文章显示  前台
     */
    public List<EssayShow> ShowEssay (Integer eno);

    /**
     * 个人中心文章列表
     */
    public List<EssayList> findEssayList(EssayList t);

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
     * 返回文章数量
     */
    public int findByDateAndAnameTotal(String startDate,String endDate,String t);

    /**
     * 时间和名称的综合查询
     * @param startDate  开始时间
     * @param endDate	结束时间
     * @param t  查询词缀
     */
    public List<Essayinfo> findByDateAndAname (String startDate,String endDate,String t,Integer pageNum,Integer pageSize);


    /**
     * 分页时总条数
     */
    public int findByPageTotal( );

    /**
     * 分页查询
     */
    public List<Essayinfo> findByPage (Integer pageNum,Integer pageSize);


    /**
     * 首页查询
     *
     */
    public List<EssayVO> findByEssayInfo();

    /**
     * 首页查询（按照热度）
     *
     */
    public List<EssayVO> findByEssayHeat();

    /**
     * 首页查询（按照时间）
     */
    public List<EssayVO> findByEssayTime();

    /**
     * Photrix精选查询
     *
     */
    public List<EssayVO> findByPhotrix();

}
