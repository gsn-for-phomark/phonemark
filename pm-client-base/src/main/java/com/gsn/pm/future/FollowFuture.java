package com.gsn.pm.future;

import com.gsn.pm.service.FollowRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

// 对外公开的业务层
@Component
public class FollowFuture {
    @Autowired
    private FollowRestService followRestService;//业务层 checkFollows add02 addFollow delete01 delete02 findFollow findBeFollowed

    @Async
    public CompletableFuture<String> checkEssayUser(Integer mno,Integer bno){
        return  CompletableFuture.supplyAsync(()->{
            return followRestService.checkEssayUser(mno, bno);
        });
    }
    @Async
    public CompletableFuture<String> checkFollows(Integer mno,Integer bno){
        return  CompletableFuture.supplyAsync(()->{
            return followRestService.checkFollows(mno,bno);
        });
    }
    @Async
    public CompletableFuture<String> add02(Integer mno,Integer bno){
        return  CompletableFuture.supplyAsync(()->{
            return followRestService.add02(mno, bno);
        });
    }
    @Async
    public CompletableFuture<String> addFollow(Integer mno,Integer bno){
        return  CompletableFuture.supplyAsync(()->{
            return followRestService.addFollow(mno, bno);
        });
    }
    @Async
    public CompletableFuture<String> delete01(Integer mno,Integer bno,Integer status){
        return  CompletableFuture.supplyAsync(()->{
            return followRestService.delete01(mno, bno, status);
        });
    }
    @Async
    public CompletableFuture<String> delete02(Integer mno,Integer bno,Integer status){
        return  CompletableFuture.supplyAsync(()->{
            return followRestService.delete02(mno, bno, status);
        });
    }
    @Async
    public CompletableFuture<String> findFollow(Integer mno){
        return  CompletableFuture.supplyAsync(()->{
            return followRestService.findFollow(mno);
        });
    }
    @Async
    public CompletableFuture<String> findBeFollowed(Integer mno){
        return  CompletableFuture.supplyAsync(()->{
            return followRestService.findBeFollowed(mno);
        });
    }

}
