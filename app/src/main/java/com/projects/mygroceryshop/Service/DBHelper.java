package com.projects.mygroceryshop.Service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Model.ItemCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper implements IDatabaseService{
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="GROCERY.db";
    private static final String TABLE_NAME = "GroceryItem";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "itemName";
    private static final String KEY_PRICE = "itemPrice";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ITEMS_TABLE = "CREATE TABLE "+TABLE_NAME+"(" +
                KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_NAME+" TEXT," +
                KEY_PRICE+" REAL" +
                ");";
        sqLiteDatabase.execSQL(CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS GroceryItem");
        onCreate(sqLiteDatabase);
    }

    @Override
    public boolean addItem(GroceryItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,item.getName());
        contentValues.put(KEY_PRICE,item.getPrice());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
        return true;
    }

    @Override
    public boolean removeItem(GroceryItem item) {
        return false;
    }

    @Override
    public boolean editItem(GroceryItem oldItem, GroceryItem newItem) {
        return false;
    }

    @Override
    public ArrayList<GroceryItem> getGroceryItems() {
        ArrayList<GroceryItem> groceryItems = new ArrayList<>();
        String query = "SELECT itemName,itemPrice FROM GroceryItem;";
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()){
                do{
                    String itemName = cursor.getString(0);
                    Log.v("SQQ",itemName);
                    double pr = cursor.getDouble(1);
                    if(itemName.equals("Grape")) {
                        GroceryItem groceryItem = new GroceryItem(itemName, pr, ItemCategory.VEGETABLE);
                        groceryItems.add(groceryItem);
                    }else{
                        GroceryItem groceryItem = new GroceryItem(itemName, pr, ItemCategory.FRUIT);
                        groceryItems.add(groceryItem);
                    }
                }while (cursor.moveToNext());
            }
            return groceryItems;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
