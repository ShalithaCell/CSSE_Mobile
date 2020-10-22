package com.example.cssemobileapp.Model;

public class PendingOrders {

    String address,date,id,item,need_qty,price,qty,supplier;

    public PendingOrders(){}

    public PendingOrders(String address, String date, String id, String item, String need_qty, String price, String qty, String supplier) {
        this.address = address;
        this.date = date;
        this.id = id;
        this.item = item;
        this.need_qty = need_qty;
        this.price = price;
        this.qty = qty;
        this.supplier = supplier;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeed_qty() {
        return need_qty;
    }

    public void setNeed_qty(String need_qty) {
        this.need_qty = need_qty;
    }
}
