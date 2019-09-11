package com.yangxi.szy.rsp;

public class RspBase {
    private String code;
    private String flag;
    private String msg;

    public RspBase() {
    }

    public RspBase(String code, String flag, String msg) {
        this.code = code;
        this.flag = flag;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RspBase{" +
                "code='" + code + '\'' +
                ", flag='" + flag + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
