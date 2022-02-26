package com.projects.mygroceryshop.Model;

import java.util.Hashtable;

public class Cart {
    private Hashtable<GroceryItem,Integer> cartItems;

    public Cart(){
        cartItems = new Hashtable<>();
    }

    public void addItem(GroceryItem groceryItem,int count){
        if(groceryItem!=null) {
            cartItems.put(groceryItem, count);
        }
    }

    public void removeItem(GroceryItem groceryItem){
        if(cartItems.size()>0 && groceryItem!=null) {
            cartItems.remove(groceryItem);
        }
    }

    public double getTotalPaid(){
        double total =0.0;
        for (GroceryItem item: cartItems.keySet()) {
            int count = cartItems.get(item);
            total += item.getPrice()* count;
        }
        return total;
    }

    public int getCartWeight(){
        return cartItems.size();
    }
}
