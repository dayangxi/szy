package com.yangxi.szy.rqt;

public class Rqt6004 extends RqtBase {
    private String usr;
    private String pwdold;
    private String pwdnew;
    private String yzm;

    public Rqt6004() {
    }

    public Rqt6004(String code, String usr, String pwdold, String pwdnew, String yzm) {
        super(code);
        this.usr = usr;
        this.pwdold = pwdold;
        this.pwdnew = pwdnew;
        this.yzm = yzm;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwdold() {
        return pwdold;
    }

    public void setPwdold(String pwdold) {
        this.pwdold = pwdold;
    }

    public String getPwdnew() {
        return pwdnew;
    }

    public void setPwdnew(String pwdnew) {
        this.pwdnew = pwdnew;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    @Override
    public String toString() {
        return "Rqt6004{" +
                "usr='" + usr + '\'' +
                ", pwdold='" + pwdold + '\'' +
                ", pwdnew='" + pwdnew + '\'' +
                ", yzm='" + yzm + '\'' +
                '}';
    }
}
