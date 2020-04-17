package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class change_medic extends AppCompatActivity {

    public String[] cities = {"Выбрать врача", "Травматолог", "Хирург", "Терапевт", "Кардиолог", "Уролог",
            "Ортопед", "Офтальмотолог", "Хирург", "Стоматолог", "Вирусолог", "Проктолог"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_medic);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                // Получаем выбранный объект
                int gg = parent.getCount();
                int i = 0;
                String item = (String) parent.getItemAtPosition(position);
                if (item.equals("Выбрать врача")) {
                   // Intent intent = new Intent(change_medic.this, time.class);
                   // intent.putExtra("Data", "Травматолог");
                   // startActivity(intent);
                }
                else if (item.equals("Травматолог")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Травматолог");
                        startActivity(intent);
                } else if (item.equals("Кардиолог")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Кардиолог");
                        startActivity(intent);
                } else if (item.equals("Ортопед")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Ортопед");
                        startActivity(intent);
                } else if (item.equals("Уролог")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Уролог");
                        startActivity(intent);
                    } else if (item.equals("Терапевт")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Терапевт");
                        startActivity(intent);
                    } else if (item.equals("Офтальмотолог")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Офтальмотолог");
                        startActivity(intent);
                    } else if (item.equals("Хирург")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Хирург");
                        startActivity(intent);
                    } else if (item.equals("Стоматолог")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Стоматолог");
                        startActivity(intent);
                    } else if (item.equals("Вирусолог")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Вирусолог");
                        startActivity(intent);
                    } else if (item.equals("Проктолог")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Проктолог");
                        startActivity(intent);
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
        /*Button medButton = (Button) findViewById(R.id.medman);
        Button yrologB = (Button) findViewById(R.id.yrolog);
        Button ortoButton = (Button) findViewById(R.id.ortoped);
        Button travmaButton = (Button) findViewById(R.id.travma);
        Button terapevtButton = (Button) findViewById(R.id.terapevt);
        medButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(change_medic.this, time.class);
                intent.putExtra("Data", "Кардиолог");
                startActivity(intent);
            }
        });
        yrologB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(change_medic.this, time.class);
                intent.putExtra("Data", "Уролог");
                startActivity(intent);
            }
        });
        ortoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(change_medic.this, time.class);
                intent.putExtra("Data", "Ортопед");
                startActivity(intent);
            }
        });
        travmaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(change_medic.this, time.class);
                intent.putExtra("Data", "Травматолог");
                startActivity(intent);
            }
        });
       terapevtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(change_medic.this, time.class);
                intent.putExtra("Data", "Терапевт");
                startActivity(intent);
            }
        }); */
    }
}
