package br.edu.ifsuldeminas.mch.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        EditText userName = findViewById(R.id.editTextUser);
        EditText userPW = findViewById(R.id.editTextNumberPassword);

        //Recuperando login e senha como string
        String userNameStr = userName.getText().toString();
        String userPWStr = userPW.getText().toString();

        buttonLogin.setOnClickListener(view ->{
            if(userNameStr.equals("")){
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_user_name_empty, Toast.LENGTH_LONG);

                toast.show();
                return;
            }

            if(userPWStr.equals("")){
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_user_pw_empty, Toast.LENGTH_LONG);

                toast.show();
                return;
            }
        });
    }

        public void forgotPW (View view) {
            Toast toast = Toast.makeText(view.getContext(),
                    R.string.login_user_forgot_pw_message, Toast.LENGTH_LONG);

            toast.show();
        }
    }