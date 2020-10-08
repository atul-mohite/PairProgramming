package com.appdirect;

import java.util.Comparator;

public class UnitPrice {
    private String Fruit;
    private Integer Qty;
    private Integer price;
    private Integer HeavyItemPrice;

    public Integer getHeavyItemPrice() {
        return HeavyItemPrice;
    }

    public void setHeavyItemPrice(Integer heavyItemPrice) {
        HeavyItemPrice = heavyItemPrice;
    }
    public UnitPrice(){

    }
    public UnitPrice(String fruit, Integer qty, Integer price,Integer heavyItemPrice) {
        Fruit = fruit;
        Qty = qty;
        this.price = price;
        this.HeavyItemPrice =  heavyItemPrice;
    }

    public String getFruit() {
        return Fruit;
    }

    public Integer getQty() {
        return Qty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setFruit(String fruit) {
        Fruit = fruit;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UnitPrice{" +
                "Fruit='" + Fruit + '\'' +
                ", Qty='" + Qty + '\'' +
                ", price=" + price +
                '}';
    }

    public static Comparator<UnitPrice> SortAssending = new Comparator<UnitPrice>() {
        @Override
        public int compare(UnitPrice o1, UnitPrice o2) {
            int comparision = 0;
            comparision = o1.getFruit().toUpperCase().compareTo(o2.getFruit().toUpperCase());
            if (comparision >= 0) {
                comparision = o1.getQty() - o2.getQty();
                if (comparision >= 0) {
                    comparision = o1.getPrice() - o2.getPrice();
                }
            }
            return comparision;
        }
    };
}
