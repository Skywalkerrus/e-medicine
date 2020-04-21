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
        // В этой активности мы получаем данные из бд, для того, чтоб их отобразить(если данные имеются).
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
        mass = openText(context).split(":"); // получаем данные из файла приложения.
        ref = FirebaseDatabase.getInstance().getReference(mass[3]); // в полцченных данных из файла у нас есть и ОМС(наш логин), по нему мы делаем запрос в бд
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //0 - password, 1 - fio, 2 - tlf, 3 - omc
                // все записи юзера хранятся в его ячейке. До записи ко врачу данные выглядят так: Пароль:ФИО:Телеофн:ОМС(логин)
                // после записи ко врачу данные выглядят так: Пароль:ФИО:Телеофн:ОМС(логин):специальность врача:время записи:дата записи
                // 2 запись выглядит так Пароль:ФИО:Телеофн:ОМС(логин):специальность врача:время записи:дата записи::специальность врача:время записи:дата записи
                // и тд до 5 записи(поэтомц записей всего 4).
                mass = dataSnapshot.getValue().toString().split(":"); // мы получаем данные из бд и делим их на ячейки(делим по разделителю, - это двоеточие)
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        otm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // кнопка отмены записей
                if (mass.length >  4) { // если длинна массива больше 4 , значит, юзер к кому-то записался.
                mass[4] = "";
                mass[5] = "";
                mass[6] = ""; }
                textView.setText("Запись свободна.");
                if (mass.length == 16) { // в каждом условии указана конкретная длинна массива при конкретных записях
                    // тк это кнопка отмены, то соответственно, запись нужно подчистить и в бд, что мы и делаем при кадом отдельном сценарии
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
            public void onClick(View v) { // все кнопки отмены действуют по одному сценарию, но с разнным колличесвтом данных
                if (mass.length >  7) {
                mass[7] = "";
                mass[8] = "";
                mass[9] = ""; }
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
            public void onClick(View v) { // кнопка отмены
                if (mass.length >  9) {
                mass[10] = "";
                mass[11] = "";
                mass[12] = ""; }
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
        otm4.setOnClickListener(new View.OnClickListener() { // кнопка отмены
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
        // 0 - password, 1 - fio, 2 - tlf, 3 - omc, 4 - специальность врача, 5 - время, на которое мы записались.
        if (mass.length >= 4){
        ref = FirebaseDatabase.getInstance().getReference(mass[3]);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {  // метод, отслеживающий изменения в юазе данных.
                mass = dataSnapshot.getValue().toString().split(":"); // выгружаем данные из быза и делим их
                if (mass.length > 4)
                    // при конкретной длинне массива и наличии свободной ячейки мы записываем выгруженные данные в textView
                    // чем больше записей, тем больше данных распределяются по разным textView


                    if (mass.length == 7 && textView.getText().equals("Запись свободна."))
                        // Например, если запись одна. то мы ее запишем в первый textView
                        textView.setText("Врач: " +  mass[4] + " \nВремя: " + mass[5] + " \nДата: " + mass[6]);
                    else if (mass.length == 10 && zap.getText().equals("Запись свободна."))
                    {
                        // А если записей две, то мы запишем первую запись в первый textView, а вторую - во второй textView
                        // и так по возрастающей до 4 записи
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
                    // Если лимит превышен, выскочит соответствующий тост
            }
            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
        }
        return view;
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
