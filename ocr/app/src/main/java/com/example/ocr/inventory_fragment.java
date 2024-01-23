package com.example.ocr;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        View v = inflater.inflate(R.layout.fragment_inventory_fragment, container, false);

        Button CalendarBtn = v.findViewById(R.id.CalendarBtn);
        Button ListBtn = v.findViewById(R.id.ListBtn);

        CalendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CalendarActivity.class);
                startActivity(intent);
            }
        });

        ListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.example.eatxpiryinventory");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });

        return v;
    }
}