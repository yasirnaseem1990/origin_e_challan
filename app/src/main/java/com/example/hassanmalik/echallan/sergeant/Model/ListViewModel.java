package com.example.hassanmalik.echallan.sergeant.Model;

/**
 * Created by Hassan Malik on 3/24/2018.
 */

public class ListViewModel {

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public String getChallanAmount() {
        return challanAmount;
    }

    public void setChallanAmount(String challanAmount) {
        this.challanAmount = challanAmount;
    }

    public ListViewModel(String violationType, String challanAmount) {
        this.violationType = violationType;
        this.challanAmount = challanAmount;
    }

    String violationType,challanAmount;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public ListViewModel(String violationType, String challanAmount, boolean isSelected) {
        this.violationType = violationType;
        this.challanAmount = challanAmount;
        this.isSelected = isSelected;
    }

    boolean isSelected;

}
