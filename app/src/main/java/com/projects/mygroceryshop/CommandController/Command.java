package com.projects.mygroceryshop.CommandController;


public abstract class Command {
    private boolean is_executed;

    abstract public void execute();

    public boolean setIsExecuted(boolean is_executed){
        this.is_executed = is_executed;
        return is_executed;
    }

    public boolean isExecuted(){
        return is_executed;
    }

}
