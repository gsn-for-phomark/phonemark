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
}
