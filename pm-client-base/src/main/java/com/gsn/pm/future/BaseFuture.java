package com.gsn.pm.future;

import com.gsn.pm.service.BaseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.CompletableFuture;


// 对外公开的业务层
@Component
public class BaseFuture {

    @Autowired
    private BaseRestService baseRestService;

    @Async
    public CompletableFuture<String> Login(HttpServletRequest request, HttpServletResponse response) {
        return CompletableFuture.supplyAsync(() -> {
            return baseRestService.Login(request,response);
        });
    }

    @Async
    public CompletableFuture<String> register(HttpServletRequest request, HttpServletResponse response) {
        return CompletableFuture.supplyAsync(() -> {
            return baseRestService.register(request,response);
        });
    }
    @Async
    public CompletableFuture<String> check(HttpServletRequest request, HttpServletResponse response) {
        return CompletableFuture.supplyAsync(() -> {
            return baseRestService.check(request,response);
        });
    }
}
