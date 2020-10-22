package com.example.cssemobileapp.Model;

public class Item {

    String name,qty,supplier,unitPrice;
    boolean availability;

    public Item(){}

    public Item(boolean availability, String name, String qty, String supplier, String unitPrice) {
        this.availability = availability;
        this.name = name;
        this.qty = qty;
        this.supplier = supplier;
        this.unitPrice = unitPrice;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }


}
