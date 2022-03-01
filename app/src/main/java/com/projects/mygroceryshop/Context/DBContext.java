package com.projects.mygroceryshop.Context;


import com.projects.mygroceryshop.Service.IDatabaseService;

public class DBContext {
    private IDatabaseService dbService;
    private static DBContext dbContext;

    private DBContext(){}

    public static synchronized DBContext getDBContext(){
        if(dbContext==null){
            dbContext = new DBContext();
        }
        return dbContext;
    }

    public IDatabaseService getDbService() {
        return dbService;
    }

    public void setDbService(IDatabaseService service){
        dbService = service;
    }
}
