package com.projects.mygroceryshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.projects.mygroceryshop.Model.GroceryItem;

import java.util.List;
import android.os.Handler;

public class GroceryItemAdapter extends ArrayAdapter<GroceryItem> {
    private Handler handler = new Handler();
    private fragmentUpdated fragmentUpdated;
    public GroceryItemAdapter(@NonNull Context context, int resource, @NonNull List<GroceryItem> objects) {
        super(context, 0, objects);
        fragmentUpdated = (fragmentUpdated) context;
    }

    private void sendUpdate(){
        fragmentUpdated.updateActivityUI();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        GroceryItem groceryItem = getItem(position);

        TextView item_name = (TextView) listItemView.findViewById(R.id.item_name_tv);
        item_name.setText(groceryItem.getName());

        TextView item_price = (TextView) listItemView.findViewById(R.id.item_price_tv);
        String price = String.valueOf(groceryItem.getPrice());
        item_price.setText(price);

        if(groceryItem.hasImage()){
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.img_tv);
            imageView.setImageResource(groceryItem.getImgResId());
        }

        Button incrementBtn = (Button)listItemView.findViewById(R.id.increment_btn);
        Button decrementBtn = (Button) listItemView.findViewById(R.id.decrement_btn);
        TextView itemCounter = (TextView) listItemView.findViewById(R.id.item_counter);

        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int current = Integer.parseInt(itemCounter.getText().toString()) +1;
                        itemCounter.setText(String.valueOf(current));
                        MainActivity.cart.addItem(groceryItem,current);
                        sendUpdate();
                    }
                });
            }}
        );

        decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int current = Integer.parseInt(itemCounter.getText().toString()) -1;
                        if(current>=0) {
                            itemCounter.setText(String.valueOf(current));
                            MainActivity.cart.addItem(groceryItem,current);
                            sendUpdate();
                        }
                    }
                });
            }});

        return listItemView;
    }

}
