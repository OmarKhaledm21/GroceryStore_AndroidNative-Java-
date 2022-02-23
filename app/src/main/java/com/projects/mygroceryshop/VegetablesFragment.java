package com.projects.mygroceryshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;

public class VegetablesFragment extends Fragment {

    final List<GroceryItem> vegs = Arrays.asList(
        new GroceryItem("Tomato",2.99)
    );

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_layout,container,false);

        GroceryItemAdapter adapter = new GroceryItemAdapter(getActivity(),0,vegs);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
