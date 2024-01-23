package com.example.eatxpiry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link faq_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class faq_fragment extends Fragment {

    public faq_fragment() {
        // Required empty public constructor
    }

    public static faq_fragment newInstance(String param1, String param2) {
        faq_fragment fragment = new faq_fragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_faq_fragment, container, false);
        return v;
    }
}