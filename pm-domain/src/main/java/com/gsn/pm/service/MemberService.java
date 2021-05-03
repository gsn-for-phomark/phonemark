package com.gsn.pm.service;

import com.gsn.pm.entity.Memberinfo;

import java.util.Map;

public interface MemberService {


    /**
     *  用户注册
     * @param t member 类
     * @return
     */
    public int register(Memberinfo t);


    /**
     * 用户登录
     * @param t
     * @return
     */
    public Memberinfo login(Memberinfo t);


    /**
     * 修改用户状态
     * @param t
     * @return
     * @throws Exception
     */
    public int updateSta(Memberinfo t);

    /**
     * 用户删除
     * @return
     * @throws Exception
     */
    public int delUser(Integer mno);

    /**
     * 按照时间和姓名模糊查询
     * @param startDate
     * @param endDate
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     * @throws IllegalAccessException
     * @throws Exception
     */
    public Map<String,Object> findByDateAndAname(String startDate, String endDate, String t, Integer pageNum, Integer pageSize);

    /**
     * 按照时间查询
     * @param startDate
     * @param endDate
     * @param pageNum
     * @param pageSize
     * @return
     * @throws IllegalAccessException
     * @throws Exception
     */
    public Map<String,Object> findByDate(String startDate,String endDate,Integer pageNum,Integer pageSize);

    /**
     * 分页查询
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     * @throws IllegalAccessException
     * @throws Exception
     */
    public Map<String,Object> findByPage(Integer pageNum,Integer pageSize);

    /**
     * 按照用户名模糊查询
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     * @throws IllegalAccessException
     * @throws Exception
     */
    public Map<String,Object> findByAname(String t,Integer pageNum,Integer pageSize);



}
