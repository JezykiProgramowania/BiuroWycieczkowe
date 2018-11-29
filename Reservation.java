package com.company;

public class Reservation {

    private String status = "";
    private String owner = "";
    private String payDate = "";
    private Offer reservedOffer;
    private int whichOffer = -1;



    public Offer getReservedOffer() {
        return reservedOffer;
    }

    public void setReservedOffer(Offer reservedOffer) {
        this.reservedOffer = reservedOffer;
    }

    public int getWhichOffer() {
        return whichOffer;
    }

    public void setWhichOffer(int whichOffer) {
        this.whichOffer = whichOffer;
    }

    public Reservation(String status, String owner, String payDate, int whichOffer, Offer off) {
        this.status = status;
        this.owner = owner;
        this.payDate = payDate;
        this.whichOffer = whichOffer;
        this.reservedOffer = off;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }




}
