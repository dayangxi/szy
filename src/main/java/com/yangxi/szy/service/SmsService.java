package com.yangxi.szy.service;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SmsService {
    private static final Logger log = LoggerFactory.getLogger(SmsService.class);

    @Value("${alisms.product}")
    private String product;

    @Value("${alisms.domain}")
    private String domain;

    @Value("${alisms.region}")
    private String region;

    @Value("${alisms.timeout}")
    private String timeout;

    @Value("${alisms.accessKeyId}")
    private String accessKeyId;

    @Value("${alisms.accessKeySecret}")
    private String accessKeySecret;

    private String sign = "四川森之宇科技有限公司";

    @Value("${alisms.tmplate.login}")
    private String tmpLogin;

    @Value("${alisms.tmplate.pwd}")
    private String tmpPwd;

    @Value("${alisms.tmplate.zbjk}")
    private String tmpZbjk;

    @Value("${alisms.tmplate.order}")
    private String tmpOrder;

    //通用短信发送
    private boolean sendSMS(String ttarget, String ttmpName, String jjson){
        if (StringUtils.isEmpty(ttarget) || StringUtils.isEmpty(ttmpName) ||
                StringUtils.isEmpty(jjson)) {
            return false;
        }

        try{
            //可自助调整超时时间
            System.setProperty("sun.net.client.defaultConnectTimeout", timeout);
            System.setProperty("sun.net.client.defaultReadTimeout", timeout);

            //初始化acsClient,暂不支持region化
            IClientProfile profile = DefaultProfile.getProfile(region, accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint(region, region, product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);

            //组装请求对象-具体描述见控制台-文档部分内容
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号
            request.setPhoneNumbers(ttarget);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName(sign);
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(ttmpName);
            request.setTemplateParam(jjson);

            //实际发送短信
            SendSmsResponse response = acsClient.getAcsResponse(request);

            //提取发送结果
            boolean flag = response.getCode().equalsIgnoreCase("OK");
            if(!flag) log.info(response.getMessage());

            //返回处理结果
            return flag;
        }catch (Exception e){
            log.info(e.getMessage());
            return false;
        }
    }

    //发送验证码
    public boolean sendValidCode(String ttarget, String ccode, boolean loginFlag) {
        if (StringUtils.isEmpty(ttarget) || StringUtils.isEmpty(ccode)) {
            return false;
        }

        //拼接请求参数
        JSONObject param = new JSONObject();
        param.put("code", ccode);

        //进行验证码的实际发送
        return sendSMS(ttarget, loginFlag?tmpLogin:tmpPwd, param.toString());
    }

    //订单新申请或者发起完成申请进行短信通知
    public boolean sendOrderInfo(String ttarget, String ddjh, String czt) {
        if (StringUtils.isEmpty(ttarget) || StringUtils.isEmpty(ddjh)
                || StringUtils.isEmpty(czt)) {
            return false;
        }

        //拼接请求参数
        JSONObject param = new JSONObject();
        param.put("djh", ddjh);
        param.put("zt", czt);

        //进行状态更新的实际发送
        return sendSMS(ttarget, tmpOrder, param.toString());
    }

    //订单新申请或者发起完成申请进行短信通知
    public boolean sendZBJK(String ttarget, String zzbmc, String cval) {
        if (StringUtils.isEmpty(ttarget) || StringUtils.isEmpty(zzbmc)
                || StringUtils.isEmpty(cval)) {
            return false;
        }

        //拼接请求参数
        JSONObject param = new JSONObject();
        param.put("zbmc", zzbmc);
        param.put("zbz", cval);

        //进行状态更新的实际发送
        return sendSMS(ttarget, tmpZbjk, param.toString());
    }
}
