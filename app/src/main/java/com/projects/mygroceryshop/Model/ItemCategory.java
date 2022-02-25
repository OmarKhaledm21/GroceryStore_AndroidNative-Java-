package com.projects.mygroceryshop.Model;

import androidx.annotation.NonNull;

public enum ItemCategory {
    FRUIT,
    VEGETABLE;

    public static int getCategoriesNumber(){
        return ItemCategory.values().length;
    }
}
