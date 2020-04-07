package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.ui.login.LoginActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class lichyi_kabinet extends AppCompatActivity {
    private final static String FILE_NAME = "abus.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichyi_kabinet);
        final EditText omcText = findViewById(R.id.omcc);
        final EditText fioText = findViewById(R.id.fioo);
        final EditText tlfText = findViewById(R.id.tlff);
        final EditText passText = findViewById(R.id.pass);
        final Button logButton = findViewById(R.id.button6);
        Intent intent = getIntent();
        //String[] mass = intent.getStringArrayExtra("data");
        String[] mass = openText().split(":");
        // 0 - password, 1 - fio, 2 - tlf, 3 - omc
        omcText.setText(mass[3]);
        fioText.setText(mass[1]);
        tlfText.setText(mass[2]);
        passText.setText(mass[0]);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lichyi_kabinet.this, MainActivity.class);
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
            //Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
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
            {
                return ("ochellopojiloe");
            }
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            return (text);
        }
        catch(IOException ex) {

            //return ("ochellopojiloe");
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                return ("ochellopojiloe");
            }
        }
        return ("ochellopojiloe");
    }
}
