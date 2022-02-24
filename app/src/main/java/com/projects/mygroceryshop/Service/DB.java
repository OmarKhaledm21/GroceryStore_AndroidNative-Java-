package com.projects.mygroceryshop.Service;

import android.util.Log;

import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Model.ItemCategory;

import java.util.ArrayList;

public class DB implements IDatabaseService{
    private static final ArrayList<GroceryItem> vegetables = new ArrayList<>();
    private static final ArrayList<GroceryItem> fruits = new ArrayList<>();

    public DB() {
        vegetables.add(new GroceryItem("Tomato",2.99,ItemCategory.VEGETABLE));
        fruits.add(new GroceryItem("Apple",2.99,ItemCategory.FRUIT));
    }

    @Override
    public boolean addItem(GroceryItem item) {
        if(item.getItemCategory() == ItemCategory.VEGETABLE){
            vegetables.add(item);
            Log.v("REACH",vegetables.get(vegetables.size()-1).getName());
            return true;
        }else if (item.getItemCategory()== ItemCategory.FRUIT){
            fruits.add(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeItem(GroceryItem item) {
        if(item.getItemCategory() == ItemCategory.VEGETABLE){
            vegetables.remove(item);
            return true;
        }else if (item.getItemCategory()== ItemCategory.FRUIT){
            fruits.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean editItem(GroceryItem oldItem, GroceryItem newItem) {
        if(oldItem.getItemCategory() == ItemCategory.VEGETABLE){
            vegetables.remove(oldItem);
            vegetables.add(newItem);
            return true;
        }else if (oldItem.getItemCategory()== ItemCategory.FRUIT){
            vegetables.remove(oldItem);
            fruits.add(newItem);
            return true;
        }
        return false;
    }

    public ArrayList<GroceryItem> getVegetables() {
        return vegetables;
    }

    public ArrayList<GroceryItem> getFruits() {
        return fruits;
    }
}
