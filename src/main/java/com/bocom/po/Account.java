package com.bocom.po;

import java.math.BigDecimal;

public class Account {
    private String acno;

    private String acname;

    private String acaddress;

    private String accurrency;

    private BigDecimal acbalance;

    private BigDecimal acbalanceAva;

    private String acbod;

    private String acbodname;

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno == null ? null : acno.trim();
    }

    public String getAcname() {
        return acname;
    }

    public void setAcname(String acname) {
        this.acname = acname == null ? null : acname.trim();
    }

    public String getAcaddress() {
        return acaddress;
    }

    public void setAcaddress(String acaddress) {
        this.acaddress = acaddress == null ? null : acaddress.trim();
    }

    public String getAccurrency() {
        return accurrency;
    }

    public void setAccurrency(String accurrency) {
        this.accurrency = accurrency == null ? null : accurrency.trim();
    }

    public BigDecimal getAcbalance() {
        return acbalance;
    }

    public void setAcbalance(BigDecimal acbalance) {
        this.acbalance = acbalance;
    }

    public BigDecimal getAcbalanceAva() {
        return acbalanceAva;
    }

    public void setAcbalanceAva(BigDecimal acbalanceAva) {
        this.acbalanceAva = acbalanceAva;
    }

    public String getAcbod() {
        return acbod;
    }

    public void setAcbod(String acbod) {
        this.acbod = acbod == null ? null : acbod.trim();
    }

    public String getAcbodname() {
        return acbodname;
    }

    public void setAcbodname(String acbodname) {
        this.acbodname = acbodname == null ? null : acbodname.trim();
    }
}