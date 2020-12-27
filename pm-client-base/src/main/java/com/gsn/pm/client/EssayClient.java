package com.gsn.pm.client;


import com.gsn.pm.config.FeignClientConfig;
import com.gsn.pm.entity.EssayType;
import com.gsn.pm.entity.Essayinfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",
        configuration = FeignClientConfig.class)// 配置要按自定义的类FeignClientConfig
public interface EssayClient {


    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/findEinfo",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doFindByEssayInfo();


    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/findEheat",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doFindByEssayHeat();


    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/findEtime",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doFindByEssayTime();

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/findPhotrix",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doFindPhotrix();


    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/findEC",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doFindEssayandComment();

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/findECT",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doFindEssayandCommentByEtype(@RequestParam("tno") Integer tno);


    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/showEssay",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doShowEssay(@RequestParam("eno") Integer eno);

    @RequestMapping(method = RequestMethod.POST,value = "/gsn-api/essay-proxy/essay/add",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doAddEssay(@RequestBody Essayinfo t);


    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/typeTotal",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doEssaytypeTotal();


    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/findByTno",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doFindByTnoEssay(@RequestParam("tno") Integer tno);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/findElist",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doFindEssayList(@RequestParam("mno") Integer mno);


    @RequestMapping(method = RequestMethod.DELETE,value = "/gsn-api/essay-proxy/essay/delete",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doDelete(@RequestParam("eno") Integer eno);


    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/essay-proxy/essay/favoriteType",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doFavoriteType(@RequestParam("mno") Integer mno);

    @RequestMapping(method = RequestMethod.POST,value = "/gsn-api/essay-proxy/essay/addType",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doAddType(@RequestBody EssayType t);

}
