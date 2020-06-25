package com.stzhao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    private static Logger logger = LoggerFactory.getLogger(Hello.class);


//    @Autowired
//    TestService testService;

    @GetMapping("/hello2")
    public String hello() {

    	return "hello from producer";
//    List<TestPO> list = testService.queryAll();
//
//        logger.info("hehehehe");
//
//
//        return "laoZ2"+JSON.toJSONString(list);




    }
}
