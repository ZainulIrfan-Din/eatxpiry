package com.example.eatxpiry;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profile_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profile_fragment extends Fragment {

    public profile_fragment() {
        // Required empty public constructor
    }

    public static profile_fragment newInstance(String param1, String param2) {
        profile_fragment fragment = new profile_fragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile_fragment, container, false);

        ImageView seetingbtn = v.findViewById(R.id.seetingbtn);
        ImageView membersharingbtn = v.findViewById(R.id.membersharingbtn);

        seetingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SETTINGSPAGE.class);
                startActivity(intent);
            }
        });

        membersharingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MEMBERSHARINGPAGE.class);
                startActivity(intent);
            }
        });

        return v;
    }
}