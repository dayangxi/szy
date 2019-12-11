package com.yangxi.szy.task;

import com.yangxi.szy.mapper.SzyMapper;
import com.yangxi.szy.modal.ZbjkItem;
import com.yangxi.szy.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ZbjkSendTask {
    private final Logger log = LoggerFactory.getLogger(ZbjkSendTask.class);

    @Autowired
    private SzyMapper szyMapper;

    @Autowired
    private SmsService smsService;

    @Scheduled(cron = "0 30 8 * * ?") // 每天8点半
    public void scheduler() {
        while (szyMapper.getOneZbjk() != null){
            ZbjkItem item = szyMapper.getOneZbjk();
            log.info(item.toString());

            boolean ret = smsService.sendZBJK(item.getCphone(),
                    item.getCzbmc(), item.getCvalbj());

            //短信发送成功，更新指标状态
            if(ret) szyMapper.updateZbjk(item.getIid());

            //短暂休息5s等待短信发送
            try{
                Thread.sleep(5000);
            }catch (Exception e){

            }
        }
    }

//    @Scheduled(cron = "0/5 * * * * ?") // 每天8点半
//    public void scheduler2() {
//        log.info((new Date()).toString());
//    }
}
