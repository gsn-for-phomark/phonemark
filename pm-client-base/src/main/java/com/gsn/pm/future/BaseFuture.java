package com.gsn.pm.future;

import com.gsn.pm.service.BaseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.CompletableFuture;


// 对外公开的业务层
@Component
public class BaseFuture {

    @Autowired
    private BaseRestService baseRestService;

    @Async
    public CompletableFuture<String> Login(String uname, String upass) {
        return CompletableFuture.supplyAsync(() -> {
            return baseRestService.Login(uname,upass);
        });
    }

    @Async
    public CompletableFuture<String> register(HttpServletRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            return baseRestService.register(request);
        });
    }
    @Async
    public CompletableFuture<String> check(HttpServletRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            return baseRestService.check(request);
        });
    }
}
