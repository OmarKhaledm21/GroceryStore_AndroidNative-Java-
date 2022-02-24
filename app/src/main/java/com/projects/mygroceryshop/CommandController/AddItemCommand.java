package com.projects.mygroceryshop.CommandController;

import android.util.Log;

import com.projects.mygroceryshop.Context.DBContext;
import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Service.IDatabaseService;

public class AddItemCommand extends Command{
    private GroceryItem item;
    public AddItemCommand(GroceryItem item) {
        this.item = item;
    }

    @Override
    public void execute() {
        setIsExecuted(DBContext.getDBContext().getDbService().addItem(item));
    }
}
