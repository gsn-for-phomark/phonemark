package com.gsn.pm.service;

import com.gsn.pm.dao.impl.FollowMapper;
import com.gsn.pm.entity.FollowList;

import com.gsn.pm.entity.Followinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FollowServiceImpl implements FollowService{

    @Autowired
    private FollowMapper followMapper;

    /**
     * 关注和粉丝数查询
     * @param t
     * @return
     */
    @Override
    public Map<String, Object> findFollowNum(Followinfo t){
        Map<String, Object> map=new HashMap<String,Object>();
        List<Followinfo> list01= followMapper.followNum(t.getFnum(),t.getBno());
        Integer i=list01.get(0).getFnum();
        for(Followinfo f:list01){
            list01.get(0).setFnum(list01.get(0).getFnum()+f.getFnum());
        }
        list01.get(0).setFnum(list01.get(0).getFnum()-i);
        List<Followinfo> list02=followMapper.befollowNum(t.getMno(),t.getBno());
        Integer j=list02.get(0).getFnum();
        for(Followinfo f:list02){
            list02.get(0).setFnum(list02.get(0).getFnum()+f.getFnum());
        }
        list01.get(0).setFnum(list02.get(0).getFnum()-i);
        list02.get(0).setFnum(list02.get(0).getFnum()-j);
        map.put("fnums", list01.get(0));
        map.put("bnums", list02.get(0));
        System.out.println(j);
        System.out.println(list02.get(0));
        return map;
    }

    /**
     * 文章用户的关注关系
     * @param t
     * @return
     */
    @Override
    public Map<String, Object> checkEssayUser(Followinfo t) {
        Map<String, Object> map=new HashMap<String,Object>();
        Followinfo rel=new Followinfo();
        rel.setMno(t.getMno());
        rel.setBno(t.getBno());
        List<Followinfo> list =followMapper.findRelation( rel.getMno(),rel.getBno());
        if(list.size()==0){
            Followinfo rel1=new Followinfo();
            rel1.setStatus(0);
            list.add(rel1);
        }
        map.put("relation", list);
        return map;
    }

    /**
     * 判断对方是否为登录用户粉丝
     * @param t
     * @return
     */
    @Override
    public Map<String, Object> checkFollows(Followinfo t) {
        Map<String,Object> map=new HashMap<String,Object>();
        List<Followinfo> list=followMapper.checkFollow(t.getMno(), t.getBno());
        if(list.size()==0){
            return null;
        }else{
            map.put("checkF", list);
            return map;
        }
    }
    /**
     * 关注数据的修改
     * @param t
     * @return
     */
    @Override
    public int add02(Followinfo t) {
        return followMapper.add02(t.getMno(),t.getBno());
    }
    /**
     * 关注数据的添加
     * @param t
     * @return
     */
    @Override
   public int addFollow(Followinfo t){
        return followMapper.add(t.getMno(),t.getBno());
    }
    /**
     * 已关注的取关
     * @param t
     * @return
     */
    @Override
   public int delete01(Followinfo t) {
        return followMapper.delete01(t.getMno(),t.getBno(),t.getStatus());
    }
    /**
     * 互相关注的取关
     * @param t
     * @return
     */
    @Override
    public int delete02(Followinfo t){
        return followMapper.delete02(t.getMno(),t.getBno(),t.getMno(),t.getBno(),t.getStatus(),t.getMno(),t.getBno(),t.getStatus());
    }
    /**
     * 登录用户与用户个人中心关注用户列表的关注关系查询
     * @param t
     * @return
     */
//	public Map<String, Object> findUserAndListRelation(Followinfo t){
//		Map<String, Object> map=new HashMap<String,Object>();
//		List<Followinfo> list=dao.findRelation(t);
//
//	}

    /**
     * 关注列表
     * @param t
     * @return
     */
    @Override
    public Map<String, Object> findFollow(FollowList t, Integer mno) {


        Map<String, Object> map=new HashMap<String,Object>();
        Followinfo rel=new Followinfo();
        rel.setMno(mno);
        List<FollowList> list=followMapper.findFollowList(t.getFollno(),t.getFollno());
        for(int i=0;i<list.size();i++){
            rel.setBno(list.get(i).getFollno());
            List<Followinfo> list01=followMapper.findRelation(rel.getMno(), rel.getBno());
            if(list01.size()==0){
                Followinfo rel1=new Followinfo();
                rel1.setStatus(0);
                list01.add(rel1);
            }
            list.get(i).setRelation(list01);
        }
        map.put("follows", list);

        System.out.println("关注列表"+list.toString());
        return map;
    }

    /**
     * 粉丝列表
     * @param t
     * @return
     */
    @Override
    public Map<String, Object> findBeFollowed(FollowList t,Integer mno) {
        Map<String, Object> map=new HashMap<String,Object>();
        Followinfo rel=new Followinfo();
        rel.setMno(mno);
        List<FollowList> list=followMapper.findBeFollowedList(t.getFansno(),t.getFansno());
        for(int i=0;i<list.size();i++){
            rel.setBno(list.get(i).getFansno());
            List<Followinfo> list01=followMapper.findRelation(rel.getMno(), rel.getBno());
            if(list01.size()==0){
                Followinfo rel01=new Followinfo();
                rel01.setStatus(0);
                list01.add(rel01);
            }
            list.get(i).setRelation(list01);
        }
        map.put("followeds", list);
        System.out.println("粉丝列表"+list.toString());
        return map;
    }


}
