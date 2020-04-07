package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {

    public BlankFragment1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment1,
                container, false);
        Button writeButton = (Button) view.findViewById(R.id.medwrite);
        Button lichnButton = (Button) view.findViewById(R.id.lichn);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), change_medic.class));
            }
        });
        lichnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), lichyi_kabinet.class));
            }
        });
        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
    }

}
