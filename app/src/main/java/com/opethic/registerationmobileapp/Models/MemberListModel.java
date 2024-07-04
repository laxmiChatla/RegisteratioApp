package com.opethic.registerationmobileapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberListModel {

    @SerializedName("memberName")
    @Expose
    private String memberName;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("memberRole")
    @Expose
    private String memberRole;
    @SerializedName("subscriptionAmt")
    @Expose
    private String subscriptionAmt;
    @SerializedName("loanAmt")
    @Expose
    private String loanAmt;
    @SerializedName("depositAmt")
    @Expose
    private String depositAmt;


    public MemberListModel(String memberName, String mobileNo, String memberRole, String subscriptionAmt, String loanAmt, String depositAmt) {
        this.memberName = memberName;
        this.mobileNo = mobileNo;
        this.memberRole = memberRole;
        this.subscriptionAmt = subscriptionAmt;
        this.loanAmt = loanAmt;
        this.depositAmt = depositAmt;

    }
    public MemberListModel(){}

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getSubscriptionAmt() {
        return subscriptionAmt;
    }

    public void setSubscriptionAmt(String subscriptionAmt) {
        this.subscriptionAmt = subscriptionAmt;
    }

    public String getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(String loanAmt) {
        this.loanAmt = loanAmt;
    }

    public String getDepositAmt() {
        return depositAmt;
    }

    public void setDepositAmt(String depositAmt) {
        this.depositAmt = depositAmt;
    }
}
