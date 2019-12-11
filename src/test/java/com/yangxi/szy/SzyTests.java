package com.yangxi.szy;

import com.yangxi.szy.mapper.SzyMapper;
import com.yangxi.szy.modal.ZbjkItem;
import com.yangxi.szy.service.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SzyTests {
    private static final Logger log = LoggerFactory.getLogger(SzyTests.class);

    @Autowired
    private SmsService service;

    @Autowired
    private SzyMapper szyMapper;

    @Test
    public void sendYZM() throws Exception {
//        boolean ret = service.sendValidCode("13658018989",
//                "111222", true);
//        log.info(ret ? "发送成功!":"发送失败!");
//        szyMapper.addYZM("112233", 1);
    }

    @Test
    public void sendOrder() throws Exception {
//        boolean ret = service.sendOrderInfo("13658018989",
//                "LSH123", "新申请");
//        log.info(ret ? "发送成功!":"发送失败!");
    }

    @Test
    public void sendZBJK() throws Exception {
        while (szyMapper.getOneZbjk() != null){
            ZbjkItem item = szyMapper.getOneZbjk();
            log.info(item.toString());
//            szyMapper.updateZbjk(item.getIid());
        }
    }
}
