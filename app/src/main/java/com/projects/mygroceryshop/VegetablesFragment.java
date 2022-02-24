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

    private ArrayList<GroceryItem> vegs;
    private LoadItemCommand loadItemCommand = new LoadItemCommand(ItemCategory.VEGETABLE);;
    public void loadItems() {
        loadItemCommand.execute();
        if(loadItemCommand.isExecuted()){
            vegs = loadItemCommand.getGroceryItems();
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        loadItems();
        Log.v("LOAD_GG","OnAttach"+(vegs.get(vegs.size()-1).getName()));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout,container,false);
        Log.v("LOAD_GG","CreateView");
        GroceryItemAdapter adapter = new GroceryItemAdapter(getActivity(),0,vegs);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onResume() {
        Log.v("LOAD_GG","Resume");
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        Log.v("LOAD_GG","Destroy");

        super.onDestroyView();
    }
}
