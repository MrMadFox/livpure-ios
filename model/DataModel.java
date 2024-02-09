package com.livpure.safedrink.model;
/* loaded from: classes3.dex */
public class DataModel {
    String paymentId;
    String rechargeAmount;
    String rechargeDate;
    String rechargeStatus;

    public String getRechargeAmount() {
        return this.rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getRechargeStatus() {
        return this.rechargeStatus;
    }

    public void setRechargeStatus(String rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getRechargeDate() {
        return this.rechargeDate;
    }

    public void setRechargeDate(String rechargeDate) {
        this.rechargeDate = rechargeDate;
    }
}
