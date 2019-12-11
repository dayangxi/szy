package com.yangxi.szy.modal;

public class ZbjkItem {
    private int iid;
    private String cphone;
    private String czbmc;
    private String cvalbj;

    public ZbjkItem() {
    }

    public ZbjkItem(int iid, String cphone, String czbmc, String cvalbj) {
        this.iid = iid;
        this.cphone = cphone;
        this.czbmc = czbmc;
        this.cvalbj = cvalbj;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCzbmc() {
        return czbmc;
    }

    public void setCzbmc(String czbmc) {
        this.czbmc = czbmc;
    }

    public String getCvalbj() {
        return cvalbj;
    }

    public void setCvalbj(String cvalbj) {
        this.cvalbj = cvalbj;
    }

    @Override
    public String toString() {
        return "ZbjkItem{" +
                "iid=" + iid +
                ", cphone='" + cphone + '\'' +
                ", czbmc='" + czbmc + '\'' +
                ", cvalbj='" + cvalbj + '\'' +
                '}';
    }
}
