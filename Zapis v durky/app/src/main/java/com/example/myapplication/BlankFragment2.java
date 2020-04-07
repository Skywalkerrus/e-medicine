package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.ui.login.LoginActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {
    private final static String FILE_NAME = "abus.txt";
    public TextView textView;
    public String[] mass;
    public BlankFragment2() {
        // Required empty public constructor
    }
    public DatabaseReference ref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2,
                container, false);
        Context context = inflater.getContext();
        textView = (TextView) view.findViewById(R.id.textView5);
        // Inflate the layout for this fragment
        mass = openText(context).split(":");
        //if (mass.length >= 6)
        //    textView.append("Врач:" +  mass[4] + "Время:" + mass[5]);
        // 0 - password, 1 - fio, 2 - tlf, 3 - omc, 4 - специальность врача, 5 - время, на которое мы записались.
        if (mass.length >= 4){
        ref = FirebaseDatabase.getInstance().getReference(mass[3]);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mass = dataSnapshot.getValue().toString().split(":");
                if (mass.length >= 6)
                    if (textView.getText().equals("Вы ни к кому не записаны"))
                        textView.setText("Врач:" +  mass[4] + "Время:" + mass[5]);
                    else
                        textView.append("Врач:" +  mass[4] + "Время:" + mass[5]);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        }
        // 0 - password, 1 - fio, 2 - tlf, 3 - omc, 4 - специальность врача, 5 - время, на которое мы записались.
        return view;//inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
    }
    // открытие файла
    public String openText(Context context){

        FileInputStream fin = null;
        //TextView textView = (TextView) findViewById(R.id.open_text);
        try {
            fin = context.openFileInput(FILE_NAME);
            if (fin == null)
                return (null);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            return (text);
        }
        catch(IOException ex) {
            return (null);
        }
    }
}
