package com.gsn.pm.future;

import com.gsn.pm.entity.Memberinfo;
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
    public CompletableFuture<String> updateTel(Integer mno,String tel){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.updateTel(mno,tel);
        });
    }

    @Async
    public CompletableFuture<String> updateEmail(Integer mno,String email){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.updateEmail(mno, email);
        });
    }

    @Async
    public CompletableFuture<String> updatePwd(Integer mno,String pwd){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.updatePwd(mno, pwd);
        });
    }

    @Async
    public CompletableFuture<String> findUser(Memberinfo t){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.findUser(t);
        });
    }

    @Async
    public CompletableFuture<String> doCon(Memberinfo t){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.doCon(t);
        });
    }
}
