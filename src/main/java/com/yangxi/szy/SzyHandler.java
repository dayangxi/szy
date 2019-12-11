package com.yangxi.szy;

import com.yangxi.szy.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SzyHandler {
    private static final Logger log = LoggerFactory.getLogger(SzyHandler.class);

    @Autowired
    private MessageService service;

    @PostMapping(value = "/service")
    @CrossOrigin(methods = {RequestMethod.POST}, origins = "*")
    public String handleMessage(@RequestBody String jsonStr) {
        return service.handleMsg(jsonStr);
    }
}
