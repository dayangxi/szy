package com.yangxi.szy.handler;

import com.yangxi.szy.rqt.Rqt6003;
import com.yangxi.szy.rsp.RspBase;
import org.springframework.stereotype.Component;

@Component
public class Handle6003 extends HandleBase {
    public String handle(String jsonStr) {
        //解析请求参数
        Rqt6003 rqt = parseRqt(jsonStr, Rqt6003.class);
        if (rqt == null) {
            return getErrJson(FuncCode.ZCFW_FWDH);
        }

        //得到用户基本信息
        RspBase rsp;
        try {
            String fwdh = szyMapper.nextFWDH(rqt);
            rsp = new RspBase(rqt.getCode(), FuncCode.OK,  fwdh);
        } catch (Exception e) {
            rsp = new RspBase(rqt.getCode(), FuncCode.ERR, "未知错误");
        }

        //返回处理结果
        return getJson(rsp);
    }
}
