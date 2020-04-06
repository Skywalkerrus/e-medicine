package  com.example.myapplication.ui.login;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.lichyi_kabinet;
import com.example.myapplication.regActiv;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    public String[] mass;
    public DatabaseReference ref;
    public String passw;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final Button regButton = findViewById(R.id.button);
        mass = new String[5];
       // ref = FirebaseDatabase.getInstance().getReference();
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(LoginActivity.this, regActiv.class);
                startActivity(intent2);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = FirebaseDatabase.getInstance().getReference(usernameEditText.getText().toString());
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        passw = dataSnapshot.getKey();
                        mass = dataSnapshot.getValue().toString().split(":");
                        if (mass[0].equals(usernameEditText.getText().toString()) && passw.equals(passwordEditText.getText().toString()))
                        {
                            showToast("Авторизация успешна!");
                            Intent intent = new Intent(LoginActivity.this, lichyi_kabinet.class);
                            intent.putExtra("data", mass);
                            startActivity(intent);
                        }
                        else
                            showToast("Неверный логин или пароль.");
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });

    }
    public void showToast(String mess) {
        Toast toast = Toast.makeText(getApplicationContext(),
                mess,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
