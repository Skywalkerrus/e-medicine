package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.ui.login.LoginActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class regActiv extends AppCompatActivity {
    public DatabaseReference ref2;
    public String data;
    public FirebaseDatabase db;
    public DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        final EditText omcText = findViewById(R.id.omc);
        final EditText passText = findViewById(R.id.pass);
        final EditText fioText = findViewById(R.id.fio);
        final EditText tlfText = findViewById(R.id.tlf);
        final Button logButton = findViewById(R.id.button2);
        final Button gologButton = findViewById(R.id.button3);
        data = new String();
        ref2 = FirebaseDatabase.getInstance().getReference();
        db = FirebaseDatabase.getInstance();

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = passText.getText().toString() + ":" + fioText.getText().toString() + ":" + tlfText.getText().toString() + ":" + omcText.getText().toString();
                ref = db.getReference(omcText.getText().toString()); // Key
                ref.setValue(data); // Value
                showToast("Вы успешно зарегестрировались! Пожалуйста, вернитесь на экран входа и войдите в учетную запись.");

            }
        });
        gologButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(regActiv.this, LoginActivity.class);
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
}
