package com.yangxi.szy.modal;

public class ResultItem {
    private String cbm;
    private String cmsg;

    public ResultItem() {
    }

    public ResultItem(String cbm, String cmsg) {
        this.cbm = cbm;
        this.cmsg = cmsg;
    }

    public String getCbm() {
        return cbm;
    }

    public void setCbm(String cbm) {
        this.cbm = cbm;
    }

    public String getCmsg() {
        return cmsg;
    }

    public void setCmsg(String cmsg) {
        this.cmsg = cmsg;
    }

    @Override
    public String toString() {
        return "ResultItem{" +
                "cbm='" + cbm + '\'' +
                ", cmsg='" + cmsg + '\'' +
                '}';
    }
}
