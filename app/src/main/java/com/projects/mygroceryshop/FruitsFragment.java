package com.projects.mygroceryshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;

public class FruitsFragment extends Fragment {

    private final List<GroceryItem> fruits = Arrays.asList(
            new GroceryItem("Apple",2.99)
    );

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_layout,container,false);

        GroceryItemAdapter adapter = new GroceryItemAdapter(getActivity(),0, fruits);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
