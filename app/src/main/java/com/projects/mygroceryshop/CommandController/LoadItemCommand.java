package com.projects.mygroceryshop.CommandController;

import android.content.Context;

import com.projects.mygroceryshop.Context.DBContext;
import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Model.ItemCategory;
import com.projects.mygroceryshop.Service.DBHelper;

import java.util.ArrayList;

public class LoadItemCommand extends Command{
    private ArrayList<GroceryItem> groceryItems;
    private ItemCategory category;
    public LoadItemCommand(ItemCategory category) {
        this.category = category;
    }

    @Override
    public void execute(Context context) {
        DBContext.getDBContext().setDbService(new DBHelper(context));
        groceryItems = DBContext.getDBContext().getDbService().getGroceryItems();
        setIsExecuted(true);
    }

    public ArrayList<GroceryItem> getGroceryItems() {
        ArrayList<GroceryItem> res = new ArrayList<>();
        for(int i=0; i<groceryItems.size(); i++){
            if(groceryItems.get(i).getItemCategory() == category){
                res.add(groceryItems.get(i));
            }
        }
        return res;
    }
}
