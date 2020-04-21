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

    public String[] cities = {"Выбрать врача", "Травматолог - Ломова В.О.", "Хирург - Резнова Д.А.", "Терапевт - Дежурнова Ю.А.",
            "Кардиолог - Аллахов Е.Н.", "Уролог - Косов В.В.",
            "Ортопед - Ногов С.П.", "Офтальмотолог - Глазнов К.Б.", "Стоматолог - Зубнов И.О.", "Вирусолог - Максимов И.А.",
            "Проктолог - Попов Ю.А."}; // элементы спиннера
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_medic);
        // Выбор врача осуществляется с помощью элемента интерфейса - Spinner
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


                int gg = parent.getCount();
                int i = 0;
                String item = (String) parent.getItemAtPosition(position);
                if (item.equals("Выбрать врача")) {
                }
                else if (item.equals("Травматолог - Ломова В.О.")) {
                    // при выборе конкретного элеента спиннера мы переходим на активность выбора времени и даты
                    // при переходе мы передаем данные врача, которого мы выбрали(чтоб программа отобразила его данные из ячейки врача в бд)
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Травматолог - Ломова Вероника Олеговна"); // передаем данные
                        startActivity(intent);
                } else if (item.equals("Кардиолог - Аллахов Е.Н.")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Кардиолог - Аллахов Егор Николаевич");
                        startActivity(intent);
                } else if (item.equals("Ортопед - Ногов С.П.")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Ортопед - Ногов Сергей Петрович");
                        startActivity(intent);
                } else if (item.equals("Уролог - Косов В.В.")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Уролог - Косов Виталий Витальевич");
                        startActivity(intent);
                    } else if (item.equals("Терапевт - Дежурнова Ю.А.")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Терапевт - Дежурнова Юлия Андреевна");
                        startActivity(intent);
                    } else if (item.equals("Офтальмотолог - Глазнов К.Б.")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Офтальмотолог - Глазнов Кирил Борисов");
                        startActivity(intent);
                    } else if (item.equals("Хирург - Резнова Д.А.")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Хирург - Резнова Дарья Андреевна");
                        startActivity(intent);
                    } else if (item.equals("Стоматолог - Зубнов И.О.")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Стоматолог - Зубнов Игорь Олегович");
                        startActivity(intent);
                    } else if (item.equals("Вирусолог - Максимов И.А.")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Вирусолог - Максимов Илья Андреевич");
                        startActivity(intent);
                    } else if (item.equals("Проктолог - Попов Ю.А.")) {
                        Intent intent = new Intent(change_medic.this, time.class);
                        intent.putExtra("Data", "Проктолог - Попов Юрюй Алексеевич");
                        startActivity(intent);
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }
}
