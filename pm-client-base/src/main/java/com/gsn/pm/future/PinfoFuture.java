package com.gsn.pm.future;

import com.gsn.pm.entity.Followinfo;
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
    public CompletableFuture<String> findUser(Integer mno){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.findUser(mno);
        });
    }

    @Async
    public CompletableFuture<String> doCon(Integer mno,String nickName,String pwd,String tel,Integer status){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.doCon(mno, nickName, pwd, tel, status);
        });
    }

    @Async
    public CompletableFuture<String> getEssayNums(Integer mno){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.dogetEssayNums(mno);
        });
    }

    @Async
    public CompletableFuture<String> getFans(Integer mno,Integer bno){
        return  CompletableFuture.supplyAsync(()->{
            return pinfoRestService.dogetFans(mno, bno);
        });
    }

}
