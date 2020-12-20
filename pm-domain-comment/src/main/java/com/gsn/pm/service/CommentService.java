package com.gsn.pm.service;

import com.gsn.pm.entity.Commentinfo;
import com.gsn.pm.entity.Heatinfo;

import java.util.Map;

public interface CommentService {

    /**
     * 添加一级评论
     *
     * @param t
     * @return
     */
    public int addCom(Commentinfo t);

    /**
     * 添加二级评论
     *
     * @param t
     * @return
     */
    public int addCom2(Commentinfo t);


    /**
     * 查找显示评论
     *
     * @param eno
     * @return
     */
    public Map<String, Object> findCom(Integer eno);


    /**
     * 计算文章评论总数
     *
     * @param eno
     * @return
     */
    public Map<String, Object> countCom(Integer eno);


    /**
     * 删除评论
     *
     * @param t
     * @return
     */
    public int delCom(Commentinfo t);


    /**
     * 时间名字综合查询
     *
     * @param startDate
     * @param endDate
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Map<String, Object> findByDateAndAname(String startDate, String endDate, String t, Integer pageNum, Integer pageSize);


    /**
     * 分页查询
     *
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws IllegalAccessException
     * @throws Exception
     */
    public Map<String, Object> findByPage(Integer pageNum, Integer pageSize);



    /**
     * 点赞操作
     * @param t
     * @return
     */
    int doHeat(Heatinfo t);

}