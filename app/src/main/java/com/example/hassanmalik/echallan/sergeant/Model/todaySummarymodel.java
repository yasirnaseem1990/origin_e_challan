package com.example.hassanmalik.echallan.sergeant.Model;

/**
 * Created by Hassan Malik on 3/25/2018.
 */

public class todaySummarymodel {

    String totalChallan;

    public String getTotalChallan() {
        return totalChallan;
    }

    public void setTotalChallan(String totalChallan) {
        this.totalChallan = totalChallan;
    }

    public String getPaidChallan() {
        return paidChallan;
    }

    public void setPaidChallan(String paidChallan) {
        this.paidChallan = paidChallan;
    }

    public String getUnpaidChallan() {
        return unpaidChallan;
    }

    public void setUnpaidChallan(String unpaidChallan) {
        this.unpaidChallan = unpaidChallan;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(String totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public String getImpounded() {
        return Impounded;
    }

    public void setImpounded(String impounded) {
        Impounded = impounded;
    }

    public String getUnderAge() {
        return underAge;
    }

    public void setUnderAge(String underAge) {
        this.underAge = underAge;
    }

    public String getVipTickets() {
        return vipTickets;
    }

    public void setVipTickets(String vipTickets) {
        this.vipTickets = vipTickets;
    }

    String paidChallan;
    String unpaidChallan;

    public todaySummarymodel(String totalChallan, String paidChallan, String unpaidChallan, String totalAmount, String totalPaidAmount, String impounded, String underAge, String vipTickets) {
        this.totalChallan = totalChallan;
        this.paidChallan = paidChallan;
        this.unpaidChallan = unpaidChallan;
        this.totalAmount = totalAmount;
        this.totalPaidAmount = totalPaidAmount;
        Impounded = impounded;
        this.underAge = underAge;
        this.vipTickets = vipTickets;
    }

    String totalAmount;
    String totalPaidAmount;
    String Impounded;
    String underAge;
    String vipTickets;
}