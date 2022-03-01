package com.projects.mygroceryshop;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.projects.mygroceryshop.CommandController.LoadItemCommand;
import com.projects.mygroceryshop.Context.DBContext;
import com.projects.mygroceryshop.Model.GroceryItem;
import com.projects.mygroceryshop.Model.ItemCategory;

import java.util.ArrayList;

public class VegetablesFragment extends Fragment {
    private Context context;
    private ArrayList<GroceryItem> vegs;
    private final ItemCategory itemCategory = ItemCategory.VEGETABLE;
    private LoadItemCommand loadItemCommand = new LoadItemCommand(itemCategory);
    public void loadItems() {
        loadItemCommand.execute(context);
        if(loadItemCommand.isExecuted()){
            vegs = loadItemCommand.getGroceryItems();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout,container,false);
        loadItems();
        GroceryItemAdapter adapter = new GroceryItemAdapter(getActivity(),0,vegs);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
