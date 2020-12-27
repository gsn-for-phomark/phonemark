package com.gsn.pm.web.controllers;


import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.future.BaseFuture;
import com.gsn.pm.future.CommentFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private static Logger logger = LoggerFactory.getLogger(CommentController.class.getName());

    @Autowired
    private CommentFuture commentFuture ;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public CompletableFuture<String> doAdd(@RequestParam("eno") Integer eno, @RequestParam("cdesr") String cdesr, @RequestParam("mno") Integer mno) {
        return commentFuture.doAdd(eno, cdesr, mno);
    }

    @RequestMapping(value = "/add2and3", method = RequestMethod.GET)
    public CompletableFuture<String> doAdd2and3(@RequestParam("eno") Integer eno, @RequestParam("cdesr") String cdesr, @RequestParam("mno") Integer mno,
                                                @RequestParam("flag") Integer flag,@RequestParam("spare1")String spare1,@RequestParam("spare2") String spare2) {
        return commentFuture.doAdd2and3(eno, cdesr, mno, flag, spare1, spare2);
    }

    @RequestMapping(value = "/countCom", method = RequestMethod.GET)
    public CompletableFuture<String> countCom(@RequestParam("eno") Integer eno) {
        return commentFuture.countCom(eno);
    }

    @RequestMapping(value = "/showCom", method = RequestMethod.GET)
    public CompletableFuture<String> showCom(@RequestParam("eno") Integer eno) {
        return commentFuture.showCom(eno);
    }

    @RequestMapping(value = "/heat", method = RequestMethod.GET)
    public CompletableFuture<String> showCom(@RequestParam("eno") Integer eno,@RequestParam("cno")Integer cno,@RequestParam("mno")Integer mno) {
        return commentFuture.doHeat(eno, cno, mno);
    }


}
