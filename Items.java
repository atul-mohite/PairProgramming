package com.appdirect;

public class Items {
    private String Items;
    private Integer Qty;

    public Items(String items, Integer qty) {
        Items = items;
        Qty = qty;
    }

    public String getItems() {
        return Items;
    }

    public void setItems(String items) {
        Items = items;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    @Override
    public String toString() {
        return "Items{" +
                "Items='" + Items + '\'' +
                ", Qty=" + Qty +
                '}';
    }
}
