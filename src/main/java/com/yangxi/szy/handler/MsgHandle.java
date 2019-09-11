package com.yangxi.szy.handler;

/**
 * @desc : 通用消息处理器接口
 */
public interface MsgHandle {
    public String handle(String jsonStr);
}
