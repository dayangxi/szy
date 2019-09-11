package com.yangxi.szy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/admin")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }
}
