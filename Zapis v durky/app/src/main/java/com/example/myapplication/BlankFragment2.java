package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    public TextView zap;
    public TextView zap2;
    public TextView zap3;
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
        final Context context = inflater.getContext();
        textView = (TextView) view.findViewById(R.id.textView5);
        zap = (TextView) view.findViewById(R.id.zap2);
        zap2 = (TextView) view.findViewById(R.id.zap3);
        zap3 = (TextView) view.findViewById(R.id.zap4);
        final Button otm1 = view.findViewById(R.id.otm1);
        final Button otm2 = view.findViewById(R.id.otm2);
        final Button otm3 = view.findViewById(R.id.otm3);
        final Button otm4 = view.findViewById(R.id.otm4);
        mass = new String[20];
        // Inflate the layout for this fragment

            mass = openText(context).split(":");


        ref = FirebaseDatabase.getInstance().getReference(mass[3]);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mass = dataSnapshot.getValue().toString().split(":");
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        otm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mass.length >  4) {
                mass[4] = " ";
                mass[5] = " ";
                mass[6] = " "; }
                textView.setText("Запись свободна.");
                if (mass.length == 16) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + mass[4] + mass[5] + mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9] + ":" + mass[10] + ":"
                            + mass[11] + ":" + mass[12] + ":" + mass[13] + ":" + mass[14] + ":" + mass[15]);
                } else if (mass.length == 13) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] +  mass[4] +  mass[5] +  mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9] + ":" + mass[10] + ":"
                            + mass[11] + ":" + mass[12]);
                } else if (mass.length == 10) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] +  mass[4] +  mass[5] +  mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9]);
                } else if (mass.length == 7) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] +  mass[4] +  mass[5] +  mass[6]);
                }
            }
        });
        otm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mass.length >  7) {
                mass[7] = " ";
                mass[8] = " ";
                mass[9] = " "; }
                zap.setText("Запись свободна.");
                if (mass.length == 16) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                             + mass[7] +  mass[8] +  mass[9] + ":" + mass[10] + ":"
                            + mass[11] + ":" + mass[12] + ":" + mass[13] + ":" + mass[14] + ":" + mass[15]);
                } else if (mass.length == 13) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            +  mass[7] +  mass[8] +  mass[9] + ":" + mass[10] + ":"
                            + mass[11] + ":" + mass[12]);
                } else if (mass.length == 10) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            +  mass[7] +  mass[8] + mass[9]);
                } else if (mass.length == 7) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7]);
                }
            }
        });
        otm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mass.length >  9) {
                mass[10] = " ";
                mass[11] = " ";
                mass[12] = " "; }
                zap2.setText("Запись свободна.");
                if (mass.length == 16) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9] +  mass[10]
                            + mass[11] +  mass[12] + ":" + mass[13] + ":" + mass[14] + ":" + mass[15]);
                } else if (mass.length == 13) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9] +  mass[10]
                            + mass[11] +  mass[12]);
                } else if (mass.length == 10) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9]);
                } else if (mass.length == 7) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7]);
                }
            }
        });
        otm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mass.length >  12) {
                mass[13] = "";
                mass[14] = "";
                mass[15] = ""; }
                zap3.setText("Запись свободна.");
                if (mass.length == 16) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9] + ":" + mass[10] + ":"
                            + mass[11] + ":" + mass[12] +  mass[13] +  mass[14] +  mass[15]);
                } else if (mass.length == 13) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9] + ":" + mass[10] + ":"
                            + mass[11] + ":" + mass[12]);
                } else if (mass.length == 10) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9]);
                } else if (mass.length == 7) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7]);
                }
            }
        });
        //if (mass.length >= 6)
        //    textView.append("Врач:" +  mass[4] + "Время:" + mass[5]);
        // 0 - password, 1 - fio, 2 - tlf, 3 - omc, 4 - специальность врача, 5 - время, на которое мы записались.
        if (mass.length >= 4){
        ref = FirebaseDatabase.getInstance().getReference(mass[3]);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mass = dataSnapshot.getValue().toString().split(":");
                if (mass.length > 4)
                    if (mass.length == 7 && textView.getText().equals("Запись свободна."))
                        textView.setText("Врач: " +  mass[4] + " \nВремя: " + mass[5] + " \nДата: " + mass[6]);
                    else if (mass.length == 10 && zap.getText().equals("Запись свободна."))
                    {
                        textView.setText("Врач: " +  mass[4] + " \nВремя: " + mass[5] + " \nДата: " + mass[6]);
                        zap.setText("Врач: " +  mass[7] + " \nВремя: " + mass[8] + " \nДата: " + mass[9]);
                    }
                    else if (mass.length == 13 && zap2.getText().equals("Запись свободна."))
                    {
                        textView.setText("Врач: " +  mass[4] + " \nВремя: " + mass[5] + " \nДата: " + mass[6]);
                        zap.setText("Врач: " +  mass[7] + " \nВремя: " + mass[8] + " \nДата: " + mass[9]);
                       zap2.setText("Врач: " +  mass[10] + " \nВремя: " + mass[11] + " \nДата: " + mass[12]);
                    }
                    else if (mass.length == 16 && zap3.getText().equals("Запись свободна."))
                    {
                        textView.setText("Врач: " +  mass[4] + " \nВремя: " + mass[5] + " \nДата: " + mass[6]);
                        zap.setText("Врач: " +  mass[7] + " \nВремя: " + mass[8] + " \nДата: " + mass[9]);
                        zap2.setText("Врач: " +  mass[10] + " \nВремя: " + mass[11] + " \nДата: " + mass[12]);
                        zap3.setText("Врач: " +  mass[13] + " \nВремя: " + mass[14] + " \nДата: " + mass[15]);
                    }
                    else
                        Toast.makeText(context, "Превышен лимит записей.", Toast.LENGTH_LONG).show();
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
