package com.gsn.pm.future;

import com.gsn.pm.service.PinfoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class PinfoFuture {

    @Autowired
    private PinfoRestService pinfoRestService;

    @Async
    public CompletableFuture<String> updateTel(){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.updateTel();
        });
    }

    @Async
    public CompletableFuture<String> updateEmail(){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.updateEmail();
        });
    }

    @Async
    public CompletableFuture<String> updatePwd(){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.updatePwd();
        });
    }

    @Async
    public CompletableFuture<String> findUser(){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.findUser();
        });
    }
}
