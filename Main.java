package com.appdirect;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Items> Item = new ArrayList<Items>();

//        // write your code here
//
//        Item.add(new Items("Apple", 4));
//        Item.add(new Items("Loaf", 2));
//
//        //CalcualtePrice(GetItem(), getQuantity());
//        CalcualtePrice("Loaf", 1);
//        CalcualtePrice("Apple", 2);
//
//        CalculatePriceforMultipleItems(Item);
//        Item.clear();
//        Item.add(new Items("Apple", 1));
//        Item.add(new Items("Loaf", 2));
//        Item.add(new Items("coke", 1));
//        CalculatePriceforMultipleItems(Item);
//
//        Item.clear();
//        Item.add(new Items("Loaf", 2));
//        Item.add(new Items("Apple", 3));
//        Item.add(new Items("Delivery", 1));
//        CalculatePriceforMultipleItems(Item);
//
//        Item.clear();
//        Item.add(new Items("Loaf", 5));
//        Item.add(new Items("Apple", 4));
//        Item.add(new Items("Coke", 3));
//        Item.add(new Items("Delivery", 1));
//        CalculatePriceforMultipleItems(Item);

        //CalcualtePrice("Loaf", 2);
        //CalcualtePrice("Apple", 2);
        Item.clear();
        Item = strinParsing("1 Loaf");
        CalculatePriceforMultipleItems(Item);
        Item.clear();
        Item = strinParsing("2 apples");
        CalculatePriceforMultipleItems(Item);

        Item.clear();
        Item = strinParsing("4 apples and 2 loaves");
        CalculatePriceforMultipleItems(Item);

        Item.clear();
        Item = strinParsing("2 loaves, 1 apple and 1 coke");
        CalculatePriceforMultipleItems(Item);

        Item.clear();
        Item = strinParsing("2 loaves and 3 apples with delivery");
        CalculatePriceforMultipleItems(Item);


        Item.clear();
        Item = strinParsing("5 loaves, 4 apples and 3 cokes with delivery");
        CalculatePriceforMultipleItems(Item);

    }


    public static ArrayList<Items> strinParsing(String EnterString) {
        ArrayList<Items> Item = new ArrayList<Items>();


        String DataEntry[] = EnterString.split(" ");

        Boolean qty = false;
        Boolean Fitem = false;
        String FoodItem = "";
        Integer Quantity = 0;
        //for (String w : DataEntry) {
        for (int w = 0; w < DataEntry.length; w++) {
            if (Fitem) {

            } else {
                FoodItem = DataEntry[w].replace(",", "");
                FoodItem = FoodItems(FoodItem);
                if (FoodItem.trim().equalsIgnoreCase("")) {

                } else {
                    if (FoodItem.equalsIgnoreCase("Delivery")) {
                        Quantity = 1;
                        qty = true;
                    }
                    Fitem = true;
                }
            }

            if (isNumeric(DataEntry[w])) {
                Quantity = Integer.parseInt(DataEntry[w]);
                qty = true;
            }


            if (Fitem && qty) {
                Item.add(new Items(FoodItem, Quantity));
                Fitem = false;
                qty = false;
                FoodItem = "";
                Quantity = 0;
            }

        }
        return Item;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public static String FoodItems(String ItemText) {
        switch (ItemText.trim().toUpperCase()) {
            case "LOAF":
                return "LOAF";
            case "LOAVES":
                return "LOAF";
            case "APPLE":
                return "Apple";
            case "APPLES":
                return "Apple";
            case "COKE":
                return "COKE";
            case "COKES":
                return "COKE";
            case "DELIVERY":
                return "DELIVERY";
            default:
                return "";
        }
    }


    public static float CalculatePriceforMultipleItems(ArrayList<Items> FoodItem) {
        float TotalPrice = 0;
        String Message = "";
        boolean DelieveryReq = false;
        float heavyitemsPrice = 0;
        float TotalHeavyItemPrice = 0;
        //UnitPrice ItemPrice = new UnitPrice();
        for (Items It : FoodItem) {

            UnitPrice ItemPrice = getPrice(It.getItems(), It.getQty());
            TotalPrice = TotalPrice + ItemPrice.getPrice();

            TotalHeavyItemPrice = TotalHeavyItemPrice + ItemPrice.getHeavyItemPrice();
            if (It.getItems().equalsIgnoreCase("Delivery")) {
                DelieveryReq = true;
            }

            Message = Message + " " + It.getItems() + " Quantity " + It.getQty() + " ";
        }

        if (DelieveryReq) {
            TotalPrice = TotalPrice + TotalHeavyItemPrice;
        }
        Message = " Total Price for " + Message + " = " + TotalPrice;
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

        Price.add(new UnitPrice("Loaf", 1, 5, 0));
        Price.add(new UnitPrice("Apple", 1, 3, 0));
        Price.add(new UnitPrice("Coke", 1, 2, 1));
        Price.add(new UnitPrice("Delivery", 1, 10, 0));
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
