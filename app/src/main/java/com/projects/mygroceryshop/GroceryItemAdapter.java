package com.projects.mygroceryshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.projects.mygroceryshop.Model.GroceryItem;

import java.util.List;

public class GroceryItemAdapter extends ArrayAdapter<GroceryItem> {

    public GroceryItemAdapter(@NonNull Context context, int resource, @NonNull List<GroceryItem> objects) {
        super(context, 0, objects);
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


        return listItemView;
    }
}
