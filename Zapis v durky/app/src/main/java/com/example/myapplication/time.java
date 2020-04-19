package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
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

public class time extends AppCompatActivity {
    public String[] mass;
    public String[] time;
    public DatabaseReference ref;
    public int mYear;
    public int mMonth;
    public int mDay;
    public String selectedDate;
    public String kdoc;
    private final static String FILE_NAME = "abus.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        final EditText edt = findViewById(R.id.editText);
        final TextView times = findViewById(R.id.textView6);
        final Button apply = findViewById(R.id.podtv);
        mass = new String[20];
        Bundle arguments = getIntent().getExtras();
        kdoc = arguments.getString("Data");
       // String[] vrach2 = kdoc.split(" ");
       // kdoc = vrach2[0];
        ref = FirebaseDatabase.getInstance().getReference(kdoc);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                mYear = year;
                mMonth = month;
                mDay = dayOfMonth;
                selectedDate = new StringBuilder().append(mMonth + 1)
                        .append("-").append(mDay).append("-").append(mYear)
                        .append(" ").toString();
                Toast.makeText(getApplicationContext(), selectedDate, Toast.LENGTH_LONG).show();
            }
        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                time = dataSnapshot.getValue().toString().split(":");
                int lg = time.length;
                int i = 0;
                while (i < 3)
                {
                    if (i > 0 && i < 3)
                        times.append(", ");
                    times.append(time[i]);
                    i++;
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        String[] mass1 = new String[20];
        mass1 = openText().split(":");
        // 0 - password, 1 - fio, 2 - tlf, 3 - omc, 4 - специальность врача, 5 - время, на которое мы записались., 6 - дата
        //7 - специальность врача, 8 - время, на которое мы записались.,  9 - дата
        // 10 - специальность врача, 11 - время, на которое мы записались.  12 - дата
        //13 - специальность врача, 14 - время, на которое мы записались.  15 - дата
        ref = FirebaseDatabase.getInstance().getReference(mass1[3]);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mass = dataSnapshot.getValue().toString().split(":");
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!time[0].equals(edt.getText().toString()) && !time[1].equals(edt.getText().toString()) && !time[2].equals(edt.getText().toString()))
                {
                    showToast("Неправильно выбрано время записи!");
                    return;
                } else if (mass.length == 4) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + kdoc + ":" + edt.getText() + ":" + selectedDate);
                }
                else if (mass.length == 7) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6] + ":" + kdoc + ":" + edt.getText() + ":" + selectedDate);

                }
                else if (mass.length == 10) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9]
                            + ":" + kdoc + ":" + edt.getText() + ":" + selectedDate);

                }else if (mass.length == 13) {
                    ref.setValue(mass[0] + ":" + mass[1] + ":" + mass[2] + ":" + mass[3] + ":" + mass[4] + ":" + mass[5] + ":" + mass[6]
                            + ":" + mass[7] + ":" + mass[8] + ":" + mass[9] + ":" + mass[10] + ":" + mass[11] + ":" + mass[12] + ":" + kdoc + ":" + edt.getText() + ":" + selectedDate);

                }
               Intent intent = new Intent(time.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void showToast(String mess) {
        //создаём и отображаем текстовое уведомление
        Toast toast = Toast.makeText(getApplicationContext(),
                mess,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public void saveText(String data){

        FileOutputStream fos = null;
        try {
            // EditText textBox = (EditText) findViewById(R.id.save_text);
            String text = data;

            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            // Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            //Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                //Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    // открытие файла
    public String openText(){

        FileInputStream fin = null;
        //TextView textView = (TextView) findViewById(R.id.open_text);
        try {
            fin = openFileInput(FILE_NAME);
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
