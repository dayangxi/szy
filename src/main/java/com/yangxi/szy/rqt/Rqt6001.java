package com.yangxi.szy.rqt;

/**
 * @desc : 院长查询用户登录
 */
public class Rqt6001 extends RqtBase {
    private String usr;
    private String pwd;

    public Rqt6001() {
    }

    public Rqt6001(String code, String usr, String pwd) {
        super(code);
        this.usr = usr;
        this.pwd = pwd;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Rqt6001{" +
                "usr='" + usr + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
