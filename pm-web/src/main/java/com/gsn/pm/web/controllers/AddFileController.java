package com.gsn.pm.web.controllers;

import com.gsn.pm.future.AddFileFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/upload")
public class AddFileController {
    //private static Logger logger = LoggerFactory.getLogger(UploadController.class.getName());

    @Autowired
    private AddFileFuture uploadFuture;


    //formdata.append("file", file);
    //		formdata.append("ename",ename);
    //		formdata.append("edser",edser);
    //		formdata.append("tname",tname);
    //		formdata.append("mno",mid);
    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public CompletableFuture<String> fileUploadEssay(@RequestPart MultipartFile file,
                                                     @RequestParam("ename") String ename, @RequestParam("edser") String edser,
                                                     @RequestParam("tname") String tname, @RequestParam("mid") Integer mid){
        return uploadFuture.FileUpload(file,ename,edser,tname,mid);
    }
}
