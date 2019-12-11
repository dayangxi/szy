package com.yangxi.szy.handler;

import com.yangxi.szy.rqt.Rqt9001;
import com.yangxi.szy.rsp.RspBase;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Handle9001 extends HandleBase {
    public String handle(String jsonStr) {
        //解析请求参数
        Rqt9001 rqt = parseRqt(jsonStr, Rqt9001.class);
        if (rqt == null) {
            return getErrJson(FuncCode.YZM_SEND);
        }

        //得到用户基本信息
        RspBase rsp;
        try {
            //得到6位验证码
            String yzmStr = String.valueOf((new Random().nextInt(899999) + 100000));

            boolean ret = smsService.sendValidCode(rqt.getPhone(), yzmStr, rqt.isLogin());
            if (ret){
                szyMapper.addYZM(yzmStr, rqt.isLogin()? 1: 2);
            }
            rsp = new RspBase(rqt.getCode(), ret ? FuncCode.OK : FuncCode.ERR, null);
        } catch (Exception e) {
            rsp = new RspBase(rqt.getCode(), FuncCode.ERR, "发送验证码失败");
        }

        //返回处理结果
        return getJson(rsp);
    }
}
