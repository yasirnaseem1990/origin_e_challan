package com.example.hassanmalik.echallan.sergeant.Model;

/**
 * Created by Hassan Malik on 3/31/2018.
 */

public class challanDetailsModel
{
    public String getViolatorName() {
        return ViolatorName;
    }

    public void setViolatorName(String violatorName) {
        ViolatorName = violatorName;
    }

    public String getViolatorCnic() {
        return ViolatorCnic;
    }

    public void setViolatorCnic(String violatorCnic) {
        ViolatorCnic = violatorCnic;
    }

    public String getDocumenttype() {
        return Documenttype;
    }

    public void setDocumenttype(String documenttype) {
        Documenttype = documenttype;
    }

    public String getTotalpayable() {
        return Totalpayable;
    }

    public void setTotalpayable(String totalpayable) {
        Totalpayable = totalpayable;
    }

    public String getOffensecode() {
        return offensecode;
    }

    public void setOffensecode(String offensecode) {
        this.offensecode = offensecode;
    }

    public String getViolation() {
        return violation;
    }

    public void setViolation(String violation) {
        this.violation = violation;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public challanDetailsModel(String violatorName, String violatorCnic, String documenttype, String totalpayable, String offensecode, String violation, String fine) {
        ViolatorName = violatorName;
        ViolatorCnic = violatorCnic;
        Documenttype = documenttype;
        Totalpayable = totalpayable;
        this.offensecode = offensecode;
        this.violation = violation;
        this.fine = fine;
    }

    String ViolatorName,ViolatorCnic,Documenttype,Totalpayable,offensecode,violation,fine;
}
