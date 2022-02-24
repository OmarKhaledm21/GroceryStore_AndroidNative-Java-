package com.projects.mygroceryshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.projects.mygroceryshop.CommandController.LoadItemCommand;
import com.projects.mygroceryshop.Context.DBContext;
import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Model.ItemCategory;

import java.util.ArrayList;

public class FruitsFragment extends Fragment {

    private ArrayList<GroceryItem> fruits;
    private LoadItemCommand loadItemCommand;
    public void loadItems() {
        loadItemCommand = new LoadItemCommand(ItemCategory.FRUIT);
        loadItemCommand.execute();
        if(loadItemCommand.isExecuted()){
            fruits = loadItemCommand.getGroceryItems();
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_layout,container,false);
        loadItems();
        GroceryItemAdapter adapter = new GroceryItemAdapter(getActivity(),0, fruits);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
