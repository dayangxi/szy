package com.yangxi.szy.rqt;

public class Rqt6002 extends RqtBase {
    private String usr;
    private String pwd;

    public Rqt6002() {
    }

    public Rqt6002(String code, String usr, String pwd) {
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
        return "Rqt6002{" +
                "usr='" + usr + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
