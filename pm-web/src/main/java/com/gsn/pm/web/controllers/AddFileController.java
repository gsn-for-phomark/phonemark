package com.gsn.pm.web.controllers;

import com.gsn.pm.future.AddFileFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/upload")
public class AddFileController {
    //private static Logger logger = LoggerFactory.getLogger(UploadController.class.getName());

    @Autowired
    private AddFileFuture uploadFuture;

    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public CompletableFuture<String> fileUploadEssay(@RequestBody MultipartHttpServletRequest request){
        return uploadFuture.FileUpload(request);
    }
}
