package com.projects.mygroceryshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.projects.mygroceryshop.CommandController.AddItemCommand;
import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Model.ItemCategory;

public class AddItemActivity extends AppCompatActivity {
    private AddItemCommand addItemCommand;
    private EditText item_name;
    private EditText item_price;
    private Button finishBtn;
    private Button imgSelection;
    private Spinner spinner;
    private String itemName=null;
    private double itemPrice=0.0;
    private String spinnerCat=null;
    private Context context;

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    // Handle the returned Uri
                }
            });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_layout);
        this.context = getApplicationContext();
        item_name = (EditText) findViewById(R.id.name_input);
        item_price = (EditText)findViewById(R.id.price_input);
        finishBtn = (Button)findViewById(R.id.finish_input);
        imgSelection = (Button)findViewById(R.id.img_input);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(getSpinnerAdapter());

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validateInput()){
                    Log.v("VALS",itemName+" "+spinnerCat);
                    ItemCategory category = ItemCategory.valueOf(spinnerCat);
                    GroceryItem item =  new GroceryItem(itemName,itemPrice, category);
                    addItem(item);
                }
            }
        });

        imgSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });


    }



    private boolean validateInput(){
        itemName = item_name.getText().toString();
        String item_price_str = item_price.getText().toString();
        spinnerCat = spinner.getSelectedItem().toString();

        if(spinnerCat.equals("Select item category.")){
            Toast.makeText(AddItemActivity.this,"Please select item category!",Toast.LENGTH_SHORT).show();
            return false;
        }else if(itemName.equals("")){
            Toast.makeText(AddItemActivity.this,"Please type item name!",Toast.LENGTH_SHORT).show();
            return false;
        }else if(item_price_str.equals("")){
            Toast.makeText(AddItemActivity.this,"Please type item price!",Toast.LENGTH_SHORT).show();
            return false;
        }
        itemPrice = Double.parseDouble(item_price_str);
        return true;
    }

    private ArrayAdapter<String> getSpinnerAdapter() {
        String[] arraySpinner = new String[ItemCategory.getCategoriesNumber()+1];
        arraySpinner[0]="Select item category.";
        ItemCategory[] itemCategories = ItemCategory.values();
        for(int i=1; i<ItemCategory.getCategoriesNumber()+1; i++){
            arraySpinner[i] = itemCategories[i-1].toString();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public boolean addItem(GroceryItem item){
        addItemCommand = new AddItemCommand(item);
        addItemCommand.execute(this.context);
        if(addItemCommand.isExecuted()) {
            Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

}
