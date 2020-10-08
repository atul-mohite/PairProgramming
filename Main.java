package com.appdirect;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Items> Item = new ArrayList<Items>();

        // write your code here

        Item.add(new Items("Apple", 4));
        Item.add(new Items("Loaf", 2));

        //CalcualtePrice(GetItem(), getQuantity());
        CalcualtePrice("Loaf", 1);
        CalcualtePrice("Apple", 2);

        CalculatePriceforMultipleItems(Item);
        Item.clear();
        Item.add(new Items("Apple", 1));
        Item.add(new Items("Loaf", 2));
        Item.add(new Items("coke", 1));
        CalculatePriceforMultipleItems(Item);

        Item.clear();
        Item.add(new Items("Loaf", 2));
        Item.add(new Items("Apple", 3));
        Item.add(new Items("Delivery", 1));
        CalculatePriceforMultipleItems(Item);

        Item.clear();
        Item.add(new Items("Loaf", 5));
        Item.add(new Items("Apple", 4));
        Item.add(new Items("Coke", 3));
        Item.add(new Items("Delivery", 1));
        CalculatePriceforMultipleItems(Item);

        //CalcualtePrice("Loaf", 2);
        //CalcualtePrice("Apple", 2);
    }


    public static float  CalculatePriceforMultipleItems(ArrayList<Items> FoodItem){
        float TotalPrice = 0;
       String Message = "" ;
       boolean DelieveryReq = false;
       float heavyitemsPrice = 0;
       float TotalHeavyItemPrice = 0;
       //UnitPrice ItemPrice = new UnitPrice();
       for (Items It : FoodItem) {

           UnitPrice ItemPrice = getPrice(It.getItems(), It.getQty());
            TotalPrice = TotalPrice + ItemPrice.getPrice();

           TotalHeavyItemPrice = TotalHeavyItemPrice + ItemPrice.getHeavyItemPrice();
            if(It.getItems().equalsIgnoreCase("Delivery")){
                DelieveryReq = true;
            }

            Message = Message + " " + It.getItems() + " Quantity " + It.getQty() + " ";
       }

       if (DelieveryReq){
           TotalPrice = TotalPrice + TotalHeavyItemPrice;
       }
        Message =  " Total Price for " +  Message + " = " + TotalPrice;
        System.out.println(Message);
        return TotalPrice;
    }

    public static void CalcualtePrice(String Item, int qty) {
        float HeavyItem = 0;
        UnitPrice ItemPrice = getPrice(Item, qty);
        float prc = ItemPrice.getPrice();

        System.out.println("Price for " + Item + " Quatity " + qty + " is " + prc);

    }

    public static String GetItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Item");
        return sc.nextLine();
    }
    public static int getQuantity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Quantity");
        return sc.nextInt();
    }

    public static UnitPrice getPrice(String Item, int quantity) {
        int Unitprice = 5;
        ArrayList<UnitPrice> Price = new ArrayList<UnitPrice>();
        UnitPrice ItemPrice = new UnitPrice();

        Price.add(new UnitPrice("Loaf", 1, 5, 0 ));
        Price.add(new UnitPrice("Apple", 1, 3,0));
        Price.add(new UnitPrice("Coke", 1, 2,1));
        Price.add(new UnitPrice("Delivery", 1, 10,0));
        for (UnitPrice item : Price) {
            if (item.getFruit().equalsIgnoreCase(Item.trim())) {
              //  Unitprice = item.getPrice();

                ItemPrice.setFruit(Item);
                ItemPrice.setQty(quantity);
                ItemPrice.setPrice(item.getPrice() * quantity);
                ItemPrice.setHeavyItemPrice(item.getHeavyItemPrice() * quantity);
                return ItemPrice;
            }
        }

        return ItemPrice;

    }


}
