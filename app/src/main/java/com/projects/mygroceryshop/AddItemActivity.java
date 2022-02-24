package com.projects.mygroceryshop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.projects.mygroceryshop.CommandController.AddItemCommand;
import com.projects.mygroceryshop.Context.DBContext;
import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Model.ItemCategory;

public class AddItemActivity extends AppCompatActivity {
    private AddItemCommand addItemCommand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_layout);

        EditText item_name = (EditText) findViewById(R.id.name_input);
        EditText item_price = (EditText)findViewById(R.id.price_input);
        Button finishBtn = (Button)findViewById(R.id.finish_input);




        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = item_name.getText().toString();
                double itemPrice = Double.parseDouble(item_price.getText().toString());
                GroceryItem item =  new GroceryItem(itemName,itemPrice, ItemCategory.VEGETABLE);
                addItemCommand = new AddItemCommand(item);
                addItemCommand.execute();

                if(addItemCommand.isExecuted()) {
                    Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
