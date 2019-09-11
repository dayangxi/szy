package com.yangxi.szy.handler;

import com.alibaba.fastjson.JSON;
import com.yangxi.szy.mapper.YzcxMapper;
import com.yangxi.szy.rsp.RspBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandleBase implements MsgHandle {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected YzcxMapper yzcxMapper;

    //默认处理函数
    public String handle(String jsonStr) {
        return getErrJson(FuncCode.NOCODE);
    }

    //动态解析请求参数
    public <T> T parseRqt(String jsonStr, Class<T> clazz) {
        T rqt;
        try {
            rqt = JSON.parseObject(jsonStr, clazz);
            logger.info(rqt.toString());
            return rqt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //返回指定错误JSON
    public String getErrJson(String code) {
        RspBase err = new RspBase(code, FuncCode.ERR,
                "11参数解析错误");
        return JSON.toJSONString(err);
    }

    //返回请求对象对应的JSON
    public <T> String getJson(T rqt) {
        return JSON.toJSONString(rqt);
    }

    //公共日志函数
    public void log(String msg) {
        logger.info(msg);
    }
}
