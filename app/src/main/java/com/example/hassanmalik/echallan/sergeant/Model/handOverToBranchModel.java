package com.example.hassanmalik.echallan.sergeant.Model;

/**
 * Created by Hassan Malik on 4/2/2018.
 */

public class handOverToBranchModel {

    String Challan_date;
    String eTicketid;

    public handOverToBranchModel(String challan_date, String eTicketid, String violatorname, String zone) {
        Challan_date = challan_date;
        this.eTicketid = eTicketid;
        Violatorname = violatorname;
        Zone = zone;
    }

    String Violatorname;
    String Zone;

    public String getChallan_date() {
        return Challan_date;
    }

    public void setChallan_date(String challan_date) {
        Challan_date = challan_date;
    }

    public String geteTicketid() {
        return eTicketid;
    }

    public void seteTicketid(String eTicketid) {
        this.eTicketid = eTicketid;
    }

    public String getViolatorname() {
        return Violatorname;
    }

    public void setViolatorname(String violatorname) {
        Violatorname = violatorname;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String zone) {
        Zone = zone;
    }



}
