package com.yangxi.szy.handler;

import com.yangxi.szy.modal.ResultItem;
import com.yangxi.szy.rqt.Rqt6001;
import com.yangxi.szy.rsp.RspBase;
import org.springframework.stereotype.Component;

@Component
public class Handle6001 extends HandleBase {
    public String handle(String jsonStr) {
        //解析请求参数
        Rqt6001 rqt = parseRqt(jsonStr, Rqt6001.class);
        if (rqt == null) {
            return getErrJson(FuncCode.YZCX_LOGIN);
        }

        //得到用户基本信息
        RspBase rsp;
        try {
            ResultItem resultItem = szyMapper.login(rqt);
            rsp = new RspBase(rqt.getCode(), resultItem.getCbm(),  resultItem.getCmsg());
        } catch (Exception e) {
            rsp = new RspBase(rqt.getCode(), FuncCode.ERR, "未知错误");
        }

        //返回处理结果
        return getJson(rsp);
    }
}
