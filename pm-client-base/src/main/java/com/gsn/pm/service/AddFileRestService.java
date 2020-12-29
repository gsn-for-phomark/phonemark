package com.gsn.pm.service;

import com.google.gson.Gson;
import com.gsn.pm.client.AddFileCilent;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//Hystrix服务层:  调用 PiclibClient,实现断路器功能
@Service
public class AddFileRestService {

    @Autowired
    private AddFileCilent uploadCilent;

    @HystrixCommand(fallbackMethod = "FileUploadFallback")
    public String FileUpload(MultipartFile file,String ename,String edesr,String tname,Integer mno) {

        try{
            return uploadCilent.FileUpload(file,ename,edesr,tname,mno);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    private String FileUploadFallback(MultipartFile file,String ename,String edesr,String tname,Integer mno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","FileUpload异步服务异常");
        return new Gson().toJson(map);
    }
}
