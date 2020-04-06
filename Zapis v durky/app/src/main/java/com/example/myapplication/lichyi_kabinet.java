package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.ui.login.LoginActivity;

public class lichyi_kabinet extends AppCompatActivity {

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
        String[] mass = intent.getStringArrayExtra("data");
        // 0 - password, 1 - fio, 2 - tlf, 3 - omc
        omcText.setText(mass[3]);
        fioText.setText(mass[1]);
        tlfText.setText(mass[2]);
        passText.setText(mass[0]);
    }
}
