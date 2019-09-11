package com.yangxi.szy.rqt;

public class RqtBase {
    private String code;

    public RqtBase() {
    }

    public RqtBase(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RqtBase{" +
                "code='" + code + '\'' +
                '}';
    }
}
