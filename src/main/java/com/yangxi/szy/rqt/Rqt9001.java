package com.yangxi.szy.rqt;

public class Rqt9001 extends RqtBase {
    private String phone;
    private boolean login;

    public Rqt9001() {
    }

    public Rqt9001(String code, String phone, boolean login) {
        super(code);
        this.phone = phone;
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Rqt9001{" +
                "phone='" + phone + '\'' +
                ", login=" + login +
                '}';
    }
}
