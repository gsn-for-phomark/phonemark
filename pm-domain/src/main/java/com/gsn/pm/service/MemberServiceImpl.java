package com.gsn.pm.service;

import com.gsn.pm.dao.impl.MemberMapper;
import com.gsn.pm.entity.Memberinfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int register(Memberinfo t) {

        return memberMapper.add(t.getNickName(),t.getPwd(),t.getEmail());
    }

    @Transactional(readOnly = true)
    @Override
    public Memberinfo login(Memberinfo t) {
        List<Memberinfo> list = memberMapper.findByTrem(t.getMno(),t.getNickName(),t.getPwd(),t.getTel(),t.getStatus());
        if(null!=list&&list.size()==1){
            return list.get(0);
        }else if(list.size()>1||list.size()<0||list==null){
            return null;
        }
        return null;
    }

    @Override
    public int updateSta(Memberinfo t) {
        return memberMapper.updateStatus(t.getStatus(),t.getMno());
    }

    @Override
    public int delUser(Integer mno) {
        return memberMapper.delete(mno);
    }

    @Override
    public Map<String, Object> findByDateAndAname(String startDate, String endDate, String t, Integer pageNum, Integer pageSize) {
        Map<String, Object>  map = new HashMap<String,Object>();
        List<Memberinfo> list = memberMapper.findByDateAndAname(startDate, endDate, t, (pageNum-1)*pageSize, pageSize);
        System.out.println(list);
        int total = memberMapper.findByDateAndAnameTotal(startDate, endDate, t);
        map.put("members", list);
        if(null==pageNum){
            return map;
        }
        System.err.println(total);
        int maxPage =0;
        if(total%pageSize==0){
            maxPage = total/pageSize;
        }else{
            maxPage = total/pageSize+1;
        }
        map.put("maxPage", maxPage);
        int pageNs[] = new int[maxPage] ;
        for(int i=1;i<=maxPage;i++){
            pageNs[i-1]=i;
        }
        System.err.println(pageNs);
        map.put("pageNs", pageNs);
        return map;
    }

    @Override
    public Map<String, Object> findByDate(String startDate, String endDate, Integer pageNum, Integer pageSize) {
        Map<String, Object>  map = new HashMap<String,Object>();
        List<Memberinfo> list = memberMapper.findByDate(startDate, endDate, (pageNum-1)*pageSize, pageSize);
        int total = memberMapper.findByDateTotal(startDate, endDate);
        map.put("members", list);
        if(null==pageNum){
            return map;
        }
        System.err.println(total);
        int maxPage =0;
        if(total%pageSize==0){
            maxPage = total/pageSize;
        }else{
            maxPage = total/pageSize+1;
        }
        map.put("maxPage", maxPage);
        int pageNs[] = new int[maxPage] ;
        for(int i=1;i<=maxPage;i++){
            pageNs[i-1]=i;
        }
        System.err.println(pageNs);
        map.put("pageNs", pageNs);
        return map;
    }

    @Override
    public Map<String, Object> findByPage(Integer pageNum, Integer pageSize) {
        Map<String, Object>  map = new HashMap<String,Object>();
        List<Memberinfo> list = memberMapper.findByPage((pageNum-1)*pageSize, pageSize);
        int total = memberMapper.findByPageTotal();
        map.put("members", list);
        if(null==pageNum){
            return map;
        }
        System.err.println(total);
        int maxPage =0;
        if(total%pageSize==0){
            maxPage = total/pageSize;
        }else{
            maxPage = total/pageSize+1;
        }
        map.put("maxPage", maxPage);
        int pageNs[] = new int[maxPage] ;
        for(int i=1;i<=maxPage;i++){
            pageNs[i-1]=i;
        }
        System.err.println(pageNs);
        map.put("pageNs", pageNs);
        return map;
    }

    @Override
    public Map<String, Object> findByAname(String t, Integer pageNum, Integer pageSize) {
        Map<String, Object>  map = new HashMap<String,Object>();
        List<Memberinfo> list = memberMapper.findByAname(t,(pageNum-1)*pageSize , pageSize);
        int total = memberMapper.findByAnameTotal(t);
        map.put("members", list);
        if(null==pageNum){
            return map;
        }
        System.err.println(total);
        int maxPage =0;
        if(total%pageSize==0){
            maxPage = total/pageSize;
        }else{
            maxPage = total/pageSize+1;
        }
        map.put("maxPage", maxPage);
        int pageNs[] = new int[maxPage] ;
        for(int i=1;i<=maxPage;i++){
            pageNs[i-1]=i;
        }
        System.err.println(pageNs);
        map.put("pageNs", pageNs);
        return map;
    }


}
