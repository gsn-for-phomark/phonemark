package com.gsn.pm.controller;


import com.gsn.pm.dao.impl.EssayTypeMapper;
import com.gsn.pm.entity.EssayType;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.service.EssayTypeService;
import com.gsn.pm.service.EssayinfoService;
import com.gsn.pm.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private EssayTypeMapper essayTypeMapper;

    @Autowired
    private EssayinfoService essayinfoService;

    @Autowired
    private EssayTypeService et;

    /**
     * 图片上传
     * @return
     */
    @RequestMapping(value = "/image" ,method = RequestMethod.POST)
    public ResponseEntity<String> uploadImage(@RequestBody MultipartHttpServletRequest request){
        MultipartFile file=   request.getFile("file");
        String tname=request.getParameter("tname");
        String ename=request.getParameter("ename");
        String mno=request.getParameter("mno");
        String edser=request.getParameter("edser");
        String url = this.uploadService.upload(file);
        if (StringUtils.isBlank(url)) {
            return ResponseEntity.badRequest().build();
        }
        try {
//                bean = com.gsn.util.FileUploadUtil.parseRequest(request, FileDomain.class);
//                bean.setUploaded(1);
//                bean.setUrl(bean.getUpload());
//                System.out.println("文件bean:"+bean);

            Essayinfo bean =new Essayinfo();
            EssayType type = new EssayType();
            String tn = tname;
            type.setTname(tn);
            int i=et.addTypeInEssay(type);
            if(i==-1){
                List<EssayType> list = et.findByName(tname);
                i = list.get(0).getTno();
            }
            bean.setTno(i);
            bean.setMno(Integer.parseInt(mno));
            bean.setEname(ename);
            bean.setEpic(url);
            bean.setEdser(edser);
            int e =essayinfoService.add(bean);
            //toPrintJson(response, i);
            System.out.println("添加文章code:"+e);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(url);
        System.out.println("response:"+ResponseEntity.status(HttpStatus.CREATED).body(url));
        return ResponseEntity.status(HttpStatus.CREATED).body(url);
    }
}