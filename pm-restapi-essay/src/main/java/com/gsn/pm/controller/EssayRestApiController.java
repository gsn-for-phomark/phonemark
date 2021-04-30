package com.gsn.pm.controller;

import com.google.gson.Gson;
import com.gsn.pm.dao.impl.EssayTypeMapper;
import com.gsn.pm.domain.ETypeList;
import com.gsn.pm.domain.EssayComment;
import com.gsn.pm.domain.EssayList;
import com.gsn.pm.entity.EssayType;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.service.EssayTypeService;
import com.gsn.pm.service.EssayinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/essay")
public class EssayRestApiController {
    private static  Logger logger = LoggerFactory.getLogger(EssayRestApiController.class);

    @Autowired
    private EssayinfoService essayinfoService;

    @Autowired
    private EssayTypeService et;

    @Autowired
    private EssayTypeMapper essayTypeMapper;

    /**
     * 主页推荐文章信息
     */
    @RequestMapping(value = "/findEinfo",method =RequestMethod.GET)
    public CompletableFuture<String> findByEssayInfo(){
        return CompletableFuture.supplyAsync(()->{
            Map<String,Object> essayVO=essayinfoService.findEssayInfo();
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
            Map<String,Object> essayVO=essayinfoService.findEssayHeat();
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
            Map<String,Object> essayVO=essayinfoService.findEssayTime();
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
            Map<String,Object> essayVO=essayinfoService.findPhotrix();
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
            Map<String,Object> ec=essayinfoService.findEssayandComment();
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
            Map<String,Object> ec=essayinfoService.findEssayandCommentByEtype(essayComment);
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
            Map<String,Object> es=essayinfoService.showEssay(eno);
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
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public CompletableFuture<String> addEssay(@RequestBody  Essayinfo t){
        return CompletableFuture.supplyAsync(() ->{
            int i=essayinfoService.add(t);
            if(i==1){
                Map<String, Object> map = new HashMap<>();
                map.put("code", 1);
                map.put("data", t);
                map.put("msg","文章添加成功");
                return new Gson().toJson(map);
            }else {
                Map<String, Object> map = new HashMap<>();
                map.put("code", 0);
                map.put("data", t);
                map.put("msg","文章添加失败");
                return new Gson().toJson(map);
            }
        });
    }

    /**
     * 文章类型添加
     */
    @RequestMapping(value = "/addType", method = RequestMethod.POST)
    public CompletableFuture<String> addType(@RequestBody EssayType t) throws Exception {
        return CompletableFuture.supplyAsync(() -> {

            int i=et.addTypeInEssay(t);
            if(i==1){
                Map<String, Object> map = new HashMap<>();
                map.put("code", 1);
                map.put("data", t);
                map.put("msg","文章类型添加成功");
                return new Gson().toJson(map);
            }else {
                Map<String, Object> map = new HashMap<>();
                map.put("code", 0);
                map.put("data", t);
                map.put("msg","文章类型添加失败");
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
            Map<String,Object> essayTypeNum=et.essaytypeTotal();
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
            Map<String,Object> essayTypeNum=et.findByTrem(essayType);
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
    @RequestMapping(value = "/findUserlist",method = RequestMethod.GET)
    public CompletableFuture<String> findEssayList(Integer mno){
        return CompletableFuture.supplyAsync(() ->{
            EssayList essayList=new EssayList();
            essayList.setMno(mno);
            Map<String,Object> essayTypeNum=essayinfoService.findUserEassy(essayList);
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
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public CompletableFuture<String> delete(Integer eno) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            Essayinfo essayinfo=new Essayinfo();
            essayinfo.setEno(eno);
            essayinfoService.delete(eno);

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
            Map<String,Object> list=et.favoriteTypeList(eTypeList);

            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", list);
            map.put("msg","常用专题");
            return new Gson().toJson(map);
        });
    }


    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fileUploadEssay", method = RequestMethod.POST)
    public CompletableFuture<String> FileUpload(@RequestBody HttpServletRequest request) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
           // FileDomain bean= null;
            try {
//                bean = com.gsn.util.FileUploadUtil.parseRequest(request, FileDomain.class);
//                bean.setUploaded(1);
//                bean.setUrl(bean.getUpload());
//                System.out.println("文件bean:"+bean);

                Essayinfo bean = com.gsn.util.FileUploadUtil.parseRequest(request, Essayinfo.class);
                EssayType type = new EssayType();
                String tno =bean.getSpare2();
                bean.setSpare2(null);
                type.setTname(tno);
                int i=et.addTypeInEssay(type);
                if(i==-1){
                    List<EssayType> list = essayTypeMapper.findByTrem(Integer.parseInt(tno));
                    i = list.get(0).getTno();
                }
                bean.setTno(i);
                int e =essayinfoService.add(bean);
                //toPrintJson(response, i);
                System.out.println(bean);

            } catch (Exception e) {
                e.printStackTrace();
            }
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            //map.put("data",);
            map.put("msg","文章文件上传");
            return new Gson().toJson(map);
        });

//        try{
//            Essayinfo bean = FileUploadUtil.parseRequest(request, Essayinfo.class);
//            Essaytype tp = new Essaytype();
//            String tno =bean.getSpare2();
//            bean.setSpare2(null);
//            Memberinfo member = (Memberinfo) request.getSession().getAttribute("member");
//            bean.setMno(member.getMno());
//            tp.setTname(tno);
//            int settno=ETbiz.addTypeInEssay(tp);
//            if(settno==-1){
//                List<Essaytype> list = ETdao.findByName(tno);
//                settno = list.get(0).getTno();
//            }
//            bean.setTno(settno);
//            int i =biz.add(bean);
//            toPrintJson(response, i);
//            System.out.println(bean);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }


}
