package com.projects.mygroceryshop.CommandController;

import android.util.Log;

import com.projects.mygroceryshop.Context.DBContext;
import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Model.ItemCategory;
import com.projects.mygroceryshop.Service.IDatabaseService;

import java.util.ArrayList;

public class LoadItemCommand extends Command{
    private ArrayList<GroceryItem> groceryItems;
    private ItemCategory category;
    public LoadItemCommand(ItemCategory category) {
        this.category = category;
    }

    @Override
    public void execute() {
        if(category == ItemCategory.VEGETABLE) {
            groceryItems = DBContext.getDBContext().getDbService().getVegetables();
            Log.v("EXEC_VEG","LOAD VEGS");

            setIsExecuted(true);
        }else {
            groceryItems = DBContext.getDBContext().getDbService().getFruits();
            setIsExecuted(true);
        }
    }

    public ArrayList<GroceryItem> getGroceryItems() {
        return groceryItems;
    }
}
