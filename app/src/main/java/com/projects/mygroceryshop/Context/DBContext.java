package com.projects.mygroceryshop.Context;


import android.util.Log;

import com.projects.mygroceryshop.Service.DB;
import com.projects.mygroceryshop.Service.IDatabaseService;

public class DBContext {
    private static IDatabaseService dbService;
    private static DBContext dbContext;

    private DBContext(){}

    public static synchronized DBContext getDBContext(){
        Log.v("CONTEXT_INVOKED","A ONCE");
        if(dbContext==null){
            Log.v("CONTEXT_INVOKED","A NULL");
            dbService = new DB();
            dbContext = new DBContext();
        }
        return dbContext;
    }

    public IDatabaseService getDbService() {
        return dbService;
    }
}