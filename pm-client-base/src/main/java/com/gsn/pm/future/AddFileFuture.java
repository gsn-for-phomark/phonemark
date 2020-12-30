package com.gsn.pm.future;


import com.gsn.pm.service.AddFileRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

@Component
public class AddFileFuture {

    @Autowired
    private AddFileRestService uploadRestService;

    @Async
    public CompletableFuture<String> FileUpload(MultipartFile file,String ename,String edesr,String tname,Integer mid){
        return  CompletableFuture.supplyAsync(()->{
            return uploadRestService.FileUpload(file,ename,edesr,tname,mid);
        });
    }
}
