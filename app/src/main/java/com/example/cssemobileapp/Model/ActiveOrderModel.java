package com.example.cssemobileapp.Model;


public class ActiveOrderModel {

    private String id;
    private String referenceID;
    private String address;
    private String amount;
    private String dueDate;
    private String status;
    private String supplier;


    public ActiveOrderModel(String referenceID, String address, String amount, String dueDate, String status, String supplier) {
        this.referenceID = referenceID;
        this.address = address;
        this.amount = amount;
        this.dueDate = dueDate;
        this.status = status;
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
