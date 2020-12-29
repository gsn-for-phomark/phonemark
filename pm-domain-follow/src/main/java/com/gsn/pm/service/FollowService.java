package com.gsn.pm.service;

import com.gsn.pm.entity.FollowList;
import com.gsn.pm.entity.Followinfo;

import java.util.Map;

public interface FollowService {
    /**
     * 关注和粉丝数查询
     * @param t
     */
    public Map<String, Object> findFollowNum(Followinfo t);

    /**
     * 文章用户的关注关系
     * @param t
     */
    public Map<String, Object> checkEssayUser(Followinfo t);

    /**
     * 判断对方是否为登录用户粉丝
     * @param t
     */
    public Map<String, Object> checkFollows(Followinfo t);

    /**
     * 关注数据的修改
     * @param t
     */
    public int add02(Followinfo t);

    /**
     * 关注数据的添加
     * @param t
     */
    public int addFollow(Followinfo t);

    /**
     * 已关注的取关
     * @param t
     */
    public int delete01(Followinfo t);

    /**
     * 互相关注的取关
     * @param t
     */
    public int delete02(Followinfo t);

    /**
     * 关注列表
     * @param t
     */
    public Map<String, Object> findFollow(FollowList t, Integer mno);

    /**
     * 粉丝列表
     * @param t
     */
    public Map<String, Object> findBeFollowed(FollowList t,Integer mno);


}
