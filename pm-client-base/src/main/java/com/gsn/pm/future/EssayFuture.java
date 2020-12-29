package com.gsn.pm.future;


import com.gsn.pm.entity.EssayType;
import com.gsn.pm.entity.Essayinfo;
import com.gsn.pm.service.EssayRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

// 对外公开的业务层
@Component
public class EssayFuture {


    @Autowired
    private EssayRestService essayRestService;//业务层

    @Async
    public CompletableFuture<String> findEssayInfo(){
        return  CompletableFuture.supplyAsync(()->{
           return essayRestService.findEssayInfo();
        });
    }

    @Async
    public CompletableFuture<String> findEssayHeat(){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.findEssayHeat();
        });
    }

    @Async
    public CompletableFuture<String> findEssayTime(){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.findEssayTime();
        });
    }

    @Async
    public CompletableFuture<String> findEssayPhotrix(){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.findPhotrix();
        });
    }

    @Async
    public CompletableFuture<String> findEssayandComment(){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.findEssayandComment();
        });
    }

    @Async
    public CompletableFuture<String> findEssayandCommentByEtype(Integer tno){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.findEssayandCommentByEtype(tno);
        });
    }

    @Async
    public CompletableFuture<String> showEssayDetail(Integer eno){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.showEssay(eno);
        });
    }

    @Async
    public CompletableFuture<String> addEssay(Essayinfo t){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.addEssay(t);
        });
    }

    @Async
    public CompletableFuture<String> essaytypeTotal(){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.essaytypeTotal();
        });
    }

    @Async
    public CompletableFuture<String> findByTnoEssay(Integer tno){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.findByTnoEssay(tno);
        });
    }

    @Async
    public CompletableFuture<String> findUserList(Integer mno){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.findEssayList(mno);
        });
    }

    @Async
    public CompletableFuture<String> delete(Integer eno){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.doDelete(eno);
        });
    }

    @Async
    public CompletableFuture<String> userfavoriteType(Integer mno){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.favoriteType(mno);
        });
    }
    @Async
    public CompletableFuture<String> addEssayType(EssayType t){
        return  CompletableFuture.supplyAsync(()->{
            return essayRestService.addType(t);
        });
    }




}
