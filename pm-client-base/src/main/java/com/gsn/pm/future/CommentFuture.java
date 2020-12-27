package com.gsn.pm.future;

import com.gsn.pm.service.BaseRestService;
import com.gsn.pm.service.CommentRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.concurrent.CompletableFuture;


@Component
public class CommentFuture {
    @Autowired
    private CommentRestService commentRestService;

    @Async
    public CompletableFuture<String> doAdd(Integer eno,String cdesr,Integer mno) {
        return CompletableFuture.supplyAsync(() -> {
            return commentRestService.doAdd(eno, cdesr, mno);
        });
    }

    @Async
    public CompletableFuture<String> doAdd2and3(Integer eno,String cdesr,Integer mno,Integer flag,String spare1,String spare2) {
        return CompletableFuture.supplyAsync(() -> {
            return commentRestService.doAdd2and3(eno, cdesr, mno, flag, spare1, spare2);
        });
    }
    @Async
    public CompletableFuture<String> countCom(Integer eno) {
        return CompletableFuture.supplyAsync(() -> {
            return commentRestService.countCom(eno);
        });
    }
    @Async
    public CompletableFuture<String> showCom(Integer eno) {
        return CompletableFuture.supplyAsync(() -> {
            return commentRestService.showCom(eno);
        });
    }
    @Async
    public CompletableFuture<String> doHeat(Integer eno,Integer cno,Integer mno) {
        return CompletableFuture.supplyAsync(() -> {
            return commentRestService.doHeat(eno, cno, mno);
        });
    }

}
