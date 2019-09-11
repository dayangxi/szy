package com.yangxi.szy.handler;

import com.alibaba.fastjson.JSON;
import com.yangxi.szy.rsp.RspBase;
import org.springframework.stereotype.Component;

/**
 * @desc : 默认消息处理器
 */
@Component
public class HandlerDefault implements MsgHandle {
    public String handle(String jsonStr) {
        RspBase err = new RspBase(FuncCode.NOCODE, FuncCode.ERR, "参数解析错误");
        return JSON.toJSONString(err);
    }
}
