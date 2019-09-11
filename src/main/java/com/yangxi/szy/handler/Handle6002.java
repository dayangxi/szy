package com.yangxi.szy.handler;

import com.yangxi.szy.modal.ResultItem;
import com.yangxi.szy.rqt.Rqt6002;
import com.yangxi.szy.rsp.RspBase;
import org.springframework.stereotype.Component;

@Component
public class Handle6002 extends HandleBase {
    public String handle(String jsonStr) {
        //解析请求参数
        Rqt6002 rqt = parseRqt(jsonStr, Rqt6002.class);
        if (rqt == null) {
            return getErrJson(FuncCode.ADMIN_LOGIN);
        }

        //得到用户基本信息
        RspBase rsp;
        try {
            ResultItem resultItem = yzcxMapper.adminLogin(rqt);
            rsp = new RspBase(rqt.getCode(), resultItem.getCbm(),  resultItem.getCmsg());
        } catch (Exception e) {
            rsp = new RspBase(rqt.getCode(), FuncCode.ERR, "未知错误");
        }

        //返回处理结果
        return getJson(rsp);
    }
}
