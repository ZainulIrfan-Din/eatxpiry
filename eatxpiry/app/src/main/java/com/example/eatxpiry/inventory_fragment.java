package com.example.eatxpiry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link inventory_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class inventory_fragment extends Fragment {

    public inventory_fragment() {
        // Required empty public constructor
    }

    public static inventory_fragment newInstance(String param1, String param2) {
        inventory_fragment fragment = new inventory_fragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory_fragment, container, false);
    }
}