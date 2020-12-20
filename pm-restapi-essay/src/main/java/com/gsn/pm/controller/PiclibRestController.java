package com.gsn.pm.controller;

import com.google.gson.Gson;
import com.gsn.pm.domain.*;
import com.gsn.pm.entity.EssayType;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.service.EssayTypeService;
import com.gsn.pm.service.EssayinfoService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/essay")
public class PiclibRestController {
    private static  Logger logger = LoggerFactory.getLogger(PiclibRestController.class);

    @Autowired
    private EssayinfoService essayinfoService;

    @Autowired
    private EssayTypeService et;


    /**
     * 主页推荐文章信息
     */
    @RequestMapping(value = "/findEinfo",method =RequestMethod.GET)
    public CompletableFuture<String> findByEssayInfo(){
        return CompletableFuture.supplyAsync(()->{
            List<EssayVO> essayVO=essayinfoService.findByEssayInfo();
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", essayVO);
            map.put("msg","主页推荐文章信息");
            return new Gson().toJson(map);
        });
    }


    /**
     * 主页最热文章信息
     */
    @RequestMapping(value = "/findEheat",method =RequestMethod.GET)
    public CompletableFuture<String> findByEssayHeat(){
        return CompletableFuture.supplyAsync(()->{
            List<EssayVO> essayVO=essayinfoService.findByEssayHeat();
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", essayVO);
            map.put("msg","主页最热文章信息");
            return new Gson().toJson(map);
        });
    }

    /**
     * 主页最新文章信息
     */
    @RequestMapping(value = "/findEtime",method =RequestMethod.GET)
    public CompletableFuture<String> findByEssayTime(){
        return CompletableFuture.supplyAsync(()->{
            List<EssayVO> essayVO=essayinfoService.findByEssayTime();
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", essayVO);
            map.put("msg","主页最新文章信息");
            return new Gson().toJson(map);
        });
    }

    /**
     * Photrix精选文章
     */
   @RequestMapping(value = "/findPhotrix",method = RequestMethod.GET)
   public CompletableFuture<String> findPhotrix(){
        return CompletableFuture.supplyAsync(() ->{
            List<EssayVO> essayVO=essayinfoService.findByPhotrix();
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", essayVO);
            map.put("msg","Photrix精选文章");
            return new Gson().toJson(map);
        });
   }

    /**
     * 查看精选status=3文章信息和评论信息
     */
    @RequestMapping(value = "/findEC",method = RequestMethod.GET)
    public CompletableFuture<String> findEssayandComment(){
        return CompletableFuture.supplyAsync(() ->{
            List<EssayComment> ec=essayinfoService.findEssayandComment();
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", ec);
            map.put("msg","查看精选status=3文章信息和评论信息");
            return new Gson().toJson(map);
        });
    }

    /**
     * 查看文章信息和评论信息 根据类型id
     */
    @RequestMapping(value = "/findECT",method = RequestMethod.GET)
    public CompletableFuture<String> findEssayandCommentByEtype(Integer tno){
        return CompletableFuture.supplyAsync(() ->{
            EssayComment essayComment=new EssayComment();
            essayComment.setTno(tno);
            List<EssayComment> ec=essayinfoService.findEssayandCommentByEtype(essayComment);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", ec);
            map.put("msg","查看文章信息和评论信息 根据类型id");
            return new Gson().toJson(map);
        });
    }

    /**
     * 显示文章详细内容
     */
    @RequestMapping(value = "/showEssay",method = RequestMethod.GET)
    public CompletableFuture<String> showEssay(Integer eno){
        return CompletableFuture.supplyAsync(() ->{
            List<EssayShow> es=essayinfoService.showEssay(eno);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", es);
            map.put("msg","显示文章详细内容");
            return new Gson().toJson(map);
        });
    }


    /**
     * 添加文章
     */
    @RequestMapping(value = "/add" )
    public CompletableFuture<String> addEssay(String ename,
                                         Integer mno,
                                         String epic,
                                         String edesr,
                                         Integer tno){
        return CompletableFuture.supplyAsync(() ->{
            Essayinfo ei=new Essayinfo();
            ei.setEname(ename);
            ei.setMno(mno);
            ei.setEpic(epic);
            ei.setEdser(edesr);
            ei.setTno(tno);
            int i=essayinfoService.add(ei);
            if(i==1){
                Map<String, Object> map = new HashMap<>();
                map.put("code", 1);
                map.put("data", ei);
                map.put("msg","文章添加成功");
                return new Gson().toJson(map);
            }else {
                Map<String, Object> map = new HashMap<>();
                map.put("code", 0);
                map.put("data", ei);
                map.put("msg","文章添加失败");
                return new Gson().toJson(map);
            }
        });
    }


    /**
     * 各个文章类型的文章数
     */
    @RequestMapping(value = "/typeTotal",method = RequestMethod.GET)
    public CompletableFuture<String> essaytypeTotal(){
        return CompletableFuture.supplyAsync(() ->{
            List<EssayType> essayTypeNum=et.essaytypeTotal();
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", essayTypeNum);
            map.put("msg","各个文章类型的文章数");
            return new Gson().toJson(map);
        });
    }

    /**
     *  根据文章类型id查找文章类型名
     */
    @RequestMapping(value = "/findByTno",method = RequestMethod.GET)
    public CompletableFuture<String> findByTnoEssay(Integer tno){
        return CompletableFuture.supplyAsync(() ->{
            EssayType essayType=new EssayType();
            essayType.setTno(tno);
            List<EssayType> essayTypeNum=et.findByTrem(essayType);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", essayTypeNum);
            map.put("msg","根据文章类型id查找文章类型名");
            return new Gson().toJson(map);
        });
    }

    /**
     * 个人中心文章列表
     */
    @RequestMapping(value = "/findElist",method = RequestMethod.GET)
    public CompletableFuture<String> findEssayList(Integer mno){
        return CompletableFuture.supplyAsync(() ->{
            EssayList essayList=new EssayList();
            essayList.setMno(mno);
            List<EssayList> essayTypeNum=essayinfoService.findEssayList(essayList);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", essayTypeNum);
            map.put("msg","mno号个人中心文章列表");
            return new Gson().toJson(map);
        });
    }

    /**
     * 文章删除
     * @param eno
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public CompletableFuture<String> delete(@PathVariable Integer eno) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            Essayinfo essayinfo=new Essayinfo();
            essayinfo.setEno(eno);
            essayinfoService.delete(essayinfo);

            logger.info("删除->ID=" + essayinfo.getMno());
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("msg","文章删除成功");
            return new Gson().toJson(map);
        });
    }

    /**
     * 常用专题
     * favoriteType
     */
    @RequestMapping(value = "/favoriteType", method = RequestMethod.GET)
    public CompletableFuture<String> favoriteType(Integer mno) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            ETypeList eTypeList=new ETypeList();
            eTypeList.setMno(mno);
            List<ETypeList> list=et.favoriteType(eTypeList);

            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", list);
            map.put("msg","常用专题");
            return new Gson().toJson(map);
        });
    }

    /**
     * 文章类型添加
     */
    @RequestMapping(value = "/addType", method = RequestMethod.POST)
    public CompletableFuture<String> addType(String tname,String typedesc) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            EssayType type=new EssayType();
            type.setTname(tname);
            type.setTypedesc(typedesc);
            int i=et.add(type);
            if(i==1){
                Map<String, Object> map = new HashMap<>();
                map.put("code", 1);
                map.put("data", type);
                map.put("msg","文章类型添加成功");
                return new Gson().toJson(map);
            }else {
                Map<String, Object> map = new HashMap<>();
                map.put("code", 0);
                map.put("data", type);
                map.put("msg","文章类型添加失败");
                return new Gson().toJson(map);
            }
        });
    }



//    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
//    public CompletableFuture<String> findAll(Integer page, Integer pageSize, String description) {
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                PicDomain picDomain = new PicDomain();
//
//                if (CommonUtils.isNotNull(page)) {
//                    picDomain.setPage(page);
//                }
//                if (CommonUtils.isNotNull(pageSize)) {
//                    picDomain.setPageSize(pageSize);
//                }
//                if (CommonUtils.isNotNull(description)) {
//                    picDomain.setDescription(description);
//                }
//                PageDomain<PicDomain> pageDomain = picService.listByPage(picDomain);
//
//                Map<String, Object> map = new HashMap<>();
//                map.put("code", 1);
//                map.put("data", pageDomain);
//
//
//                return new Gson().toJson(map);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        });
//    }


}
