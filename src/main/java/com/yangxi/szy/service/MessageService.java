package com.yangxi.szy.service;

import com.alibaba.fastjson.JSONObject;
import com.yangxi.szy.comm.SpringUtil;
import com.yangxi.szy.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    public String handleMsg(String jsonStr) {
        MsgHandle handle = getHandler(jsonStr);
        return handle.handle(jsonStr);
    }

    private MsgHandle getHandler(String jsonStr) {
        MsgHandle msgHandle = SpringUtil.getBean(HandlerDefault.class);

        try {//根据请求功能代码得到对应处理器
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            String code = (String) jsonObject.get("code");

            //院长查询接口
            if (code.equalsIgnoreCase(FuncCode.YZCX_LOGIN))
                msgHandle = SpringUtil.getBean(Handle6001.class);
            //院长查询接口
            if (code.equalsIgnoreCase(FuncCode.ADMIN_LOGIN))
                msgHandle = SpringUtil.getBean(Handle6002.class);
            //服务单号
            if (code.equalsIgnoreCase(FuncCode.ZCFW_FWDH))
                msgHandle = SpringUtil.getBean(Handle6003.class);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return msgHandle;
    }
}
