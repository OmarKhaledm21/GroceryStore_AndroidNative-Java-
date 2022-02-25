package com.projects.mygroceryshop.Service;

import com.projects.mygroceryshop.Model.GroceryItem;

import java.util.ArrayList;

public interface IDatabaseService {
    public boolean addItem(GroceryItem item);
    public boolean removeItem(GroceryItem item);
    public boolean editItem(GroceryItem oldItem, GroceryItem newItem);
    public ArrayList<GroceryItem> getGroceryItems();

}
