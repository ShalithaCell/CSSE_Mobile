package com.example.cssemobileapp.Model;

import com.example.cssemobileapp.utils.QuestionTypes;

import java.util.List;

public class Items {
    private String itemId;
    private String itemName;
    private String supplier;
    private int qty;
    private int unitPrice;
    private boolean availability;

    public Items(String itemId, String itemName, String supplier, int qty, int unitPrice, boolean availability) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.supplier = supplier;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.availability = availability;
    }

    public Items() {

    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName(String name) {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


}
