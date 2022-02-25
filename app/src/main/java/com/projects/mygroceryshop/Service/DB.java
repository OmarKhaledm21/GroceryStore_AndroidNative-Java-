package com.projects.mygroceryshop.Service;

import android.util.Log;

import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Model.ItemCategory;

import java.util.ArrayList;

public class DB implements IDatabaseService{
    private static final ArrayList<GroceryItem> groceryItems = new ArrayList<>();

    public DB() {
        groceryItems.add(new GroceryItem("Tomato",2.99,ItemCategory.VEGETABLE));
        groceryItems.add(new GroceryItem("Apple",2.99,ItemCategory.FRUIT));
    }

    @Override
    public boolean addItem(GroceryItem item) {
        groceryItems.add(item);
        return true;
    }

    @Override
    public boolean removeItem(GroceryItem item) {
        groceryItems.remove(item);
        return true;
    }

    @Override
    public boolean editItem(GroceryItem oldItem, GroceryItem newItem) {
        groceryItems.remove(oldItem);
        groceryItems.add(newItem);
        return true;
    }

    public ArrayList<GroceryItem> getGroceryItems() {
        return groceryItems;
    }

}
