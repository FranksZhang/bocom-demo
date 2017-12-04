package com.bocom.vo;

import com.bocom.po.Tranaction;

public class TransactionDetail extends Tranaction{
    private String trname;
    private String trnameTo;
    private String traddressTo;
    private String trbodTo;
    private String trbodnameTo;

    public String getTrname() {
        return trname;
    }

    public String getTrnameTo() {
        return trnameTo;
    }

    public String getTraddressTo() {
        return traddressTo;
    }

    public String getTrbodTo() {
        return trbodTo;
    }

    public String getTrbodnameTo() {
        return trbodnameTo;
    }

    public void setTrname(String trname) {
        this.trname = trname;
    }

    public void setTrnameTo(String trnameTo) {
        this.trnameTo = trnameTo;
    }

    public void setTraddressTo(String traddressTo) {
        this.traddressTo = traddressTo;
    }

    public void setTrbodTo(String trbodTo) {
        this.trbodTo = trbodTo;
    }

    public void setTrbodnameTo(String trbodnameTo) {
        this.trbodnameTo = trbodnameTo;
    }
}
