package com.gsn.pm.future;

import com.gsn.pm.domain.Token;
import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.service.BaseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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
    public CompletableFuture<String> Login(Memberinfo memberinfo) {
        return CompletableFuture.supplyAsync(() -> {
            return baseRestService.Login(memberinfo);
        });
    }

    @Async
    public CompletableFuture<String> register(Memberinfo memberinfo) {
        return CompletableFuture.supplyAsync(() -> {
            return baseRestService.register(memberinfo);
        });
    }
    @Async
    public CompletableFuture<String> check(Token token) {
        return CompletableFuture.supplyAsync(() -> {
            return baseRestService.check(token);
        });
    }
}
