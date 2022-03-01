package com.projects.mygroceryshop.CommandController;

import android.content.Context;

import com.projects.mygroceryshop.Context.DBContext;
import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Service.DBHelper;

public class AddItemCommand extends Command{
    private GroceryItem item;
    public AddItemCommand(GroceryItem item) {
        this.item = item;
    }

    @Override
    public void execute(Context context) {
        DBContext.getDBContext().setDbService(new DBHelper(context));
        setIsExecuted(DBContext.getDBContext().getDbService().addItem(item));
    }
}
