package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class time extends AppCompatActivity {
    public String[] mass;
    public DatabaseReference ref;
    private final static String FILE_NAME = "abus.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        final EditText edt = findViewById(R.id.editText);
        final TextView times = findViewById(R.id.textView6);
        final Button apply = findViewById(R.id.podtv);
        mass = new String[5];
        ref = FirebaseDatabase.getInstance().getReference("Kardio");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mass = dataSnapshot.getValue().toString().split(":");
                int i = 0;
                while (i < 3)
                {
                    times.append(mass[i]);
                    i++;
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] mass = openText().split(":");
                // 0 - password, 1 - fio, 2 - tlf, 3 - omc, 4 - специальность врача, 5 - время, на которое мы записались.
                ref = FirebaseDatabase.getInstance().getReference(mass[3]);
                ref.setValue(mass[0] + ":" + mass[1]+ ":" + mass[2] + ":" + mass[3] + ":" + "Кардиолог" + ":" + edt.getText());
                Intent intent = new Intent(time.this, MainActivity.class);
                startActivity(intent);
            }
        });
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
