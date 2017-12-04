package com.bocom.po;

import java.math.BigDecimal;

public class Tranaction {
    private Integer trid;

    private String trstatus;

    private String trdate;

    private String trtime;

    private String trtype;

    private String trserial;

    private String trserialnum;

    private String traccount;

    private String trmark;

    private String trcurrency;

    private BigDecimal tramount;

    private BigDecimal trbalance;

    private BigDecimal trbalanceAva;

    private String traccountTo;

    private String trbillType;

    private String trbillNum;

    private String trbillName;

    private String trbillSignDate;

    private String trpostscript;

    private String trremark;

    public Integer getTrid() {
        return trid;
    }

    public void setTrid(Integer trid) {
        this.trid = trid;
    }

    public String getTrstatus() {
        return trstatus;
    }

    public void setTrstatus(String trstatus) {
        this.trstatus = trstatus == null ? null : trstatus.trim();
    }

    public String getTrdate() {
        return trdate;
    }

    public void setTrdate(String trdate) {
        this.trdate = trdate == null ? null : trdate.trim();
    }

    public String getTrtime() {
        return trtime;
    }

    public void setTrtime(String trtime) {
        this.trtime = trtime == null ? null : trtime.trim();
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype == null ? null : trtype.trim();
    }

    public String getTrserial() {
        return trserial;
    }

    public void setTrserial(String trserial) {
        this.trserial = trserial == null ? null : trserial.trim();
    }

    public String getTrserialnum() {
        return trserialnum;
    }

    public void setTrserialnum(String trserialnum) {
        this.trserialnum = trserialnum == null ? null : trserialnum.trim();
    }

    public String getTraccount() {
        return traccount;
    }

    public void setTraccount(String traccount) {
        this.traccount = traccount == null ? null : traccount.trim();
    }

    public String getTrmark() {
        return trmark;
    }

    public void setTrmark(String trmark) {
        this.trmark = trmark == null ? null : trmark.trim();
    }

    public String getTrcurrency() {
        return trcurrency;
    }

    public void setTrcurrency(String trcurrency) {
        this.trcurrency = trcurrency == null ? null : trcurrency.trim();
    }

    public BigDecimal getTramount() {
        return tramount;
    }

    public void setTramount(BigDecimal tramount) {
        this.tramount = tramount;
    }

    public BigDecimal getTrbalance() {
        return trbalance;
    }

    public void setTrbalance(BigDecimal trbalance) {
        this.trbalance = trbalance;
    }

    public BigDecimal getTrbalanceAva() {
        return trbalanceAva;
    }

    public void setTrbalanceAva(BigDecimal trbalanceAva) {
        this.trbalanceAva = trbalanceAva;
    }

    public String getTraccountTo() {
        return traccountTo;
    }

    public void setTraccountTo(String traccountTo) {
        this.traccountTo = traccountTo == null ? null : traccountTo.trim();
    }

    public String getTrbillType() {
        return trbillType;
    }

    public void setTrbillType(String trbillType) {
        this.trbillType = trbillType == null ? null : trbillType.trim();
    }

    public String getTrbillNum() {
        return trbillNum;
    }

    public void setTrbillNum(String trbillNum) {
        this.trbillNum = trbillNum == null ? null : trbillNum.trim();
    }

    public String getTrbillName() {
        return trbillName;
    }

    public void setTrbillName(String trbillName) {
        this.trbillName = trbillName == null ? null : trbillName.trim();
    }

    public String getTrbillSignDate() {
        return trbillSignDate;
    }

    public void setTrbillSignDate(String trbillSignDate) {
        this.trbillSignDate = trbillSignDate == null ? null : trbillSignDate.trim();
    }

    public String getTrpostscript() {
        return trpostscript;
    }

    public void setTrpostscript(String trpostscript) {
        this.trpostscript = trpostscript == null ? null : trpostscript.trim();
    }

    public String getTrremark() {
        return trremark;
    }

    public void setTrremark(String trremark) {
        this.trremark = trremark == null ? null : trremark.trim();
    }
}