package com.gsn.pm.service;

import com.gsn.pm.entity.Essayinfo;

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
     * 查看文章信息和评论信息  根据类型
     * @throws Exception
     * @throws IllegalAccessException
     *
     **/
    //public List<EssayComment> findEssayandCommentByEtype(EssayComment t);

    /**
     * 查看文章信息和评论信息
     * @throws Exception
     * @throws IllegalAccessException
     *
     **/
    //public List<EssayComment> findEssayandComment(EssayComment t);


    /**
     * 文章显示  前台
     * @param eno
     * @return
     * @throws IllegalAccessException
     * @throws Exception
     */
    //public List<EssayShow> ShowEssay (Integer eno)

    /**
     * 个人中心文章列表
     * @param t
     * @return
     * @throws IllegalAccessException
     * @throws Exception
     */
    //public List<EssayList> findEssayList(EssayList t);

    /**
     * 文章删除
     */

    public int delete(Essayinfo t);

    /**
     * 后端文章状态值的修改
     * @param t
     * @return
     * @throws Exception
     */
    public int updateStatus(Essayinfo t);

    /**
     * 时间和名称的综合查询 总数
     * @param startDate
     * @param endDate
     * @param t
     * @return
     * @throws SQLException
     */
    public int findByDateAndAnameTotal(String startDate,String endDate,String t);

    /**
     * 时间和名称的综合查询
     * @param startDate  开始时间
     * @param endDate	结束时间
     * @param t  查询词缀
     * @param pageNum
     * @param pageSize
     * @return
     * @throws IllegalAccessException
     * @throws Exception
     */
    public List<Essayinfo> findByDateAndAname (String startDate,String endDate,String t,Integer pageNum,Integer pageSize);


    /**
     * 分页时总条数
     * @param t
     * @return
     * @throws SQLException
     */
    public int findByPageTotal(Essayinfo t);

    /**
     * 分页查询
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     * @throws IllegalAccessException
     * @throws Exception
     */
    public List<Essayinfo> findByPage (Essayinfo t,Integer pageNum,Integer pageSize);


    /**
     * 首页查询
     *
     * @param t
     * @return
     * @throws Exception
     */
    ///public List<EssayVO> findByEssayInfo(EssayVO t);

    /**
     * 首页查询（按照热度）
     *
     * @param t
     * @return
     * @throws Exception
     */
    //public List<EssayVO> findByEssayHeat(EssayVO t)

    /**
     * 首页查询（按照时间）
     *
     * @param t
     * @return
     * @throws Exception
     */
    //public List<EssayVO> findByEssayTime(EssayVO t)

    /**
     * Photrix精选查询
     *
     */
    //public List<EssayVO> findByPhotrix(EssayVO t)

}
