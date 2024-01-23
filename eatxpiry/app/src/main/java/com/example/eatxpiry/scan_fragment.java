package com.example.eatxpiry;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link scan_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class scan_fragment extends Fragment {

    public scan_fragment() {
        // Required empty public constructor
    }

    public static scan_fragment newInstance(String param1, String param2) {
        scan_fragment fragment = new scan_fragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_scan_fragment, container, false);

        Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("org.tensorflow.lite.examples.detection");
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }

        return v;
    }
}