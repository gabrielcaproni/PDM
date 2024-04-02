package br.edu.ifsuldeminas.mch.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;

    private EditText userName;

    private EditText userPW;

    private static final String USER = "Gabriel";
    private static final String PW = "123";

    private static final String TAG = "login_main_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.buttonLogin);
        userName = findViewById(R.id.editTextUser);
        userPW = findViewById(R.id.editTextNumberPassword);

        buttonLogin.setOnClickListener(view ->{

            String userNameStr = userName.getText().toString();
            String userPWStr = userPW.getText().toString();

            if(userNameStr.equals("")){
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_user_name_empty, Toast.LENGTH_SHORT);

                toast.show();
                return;
            }

            if(userPWStr.equals("")){
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_user_pw_empty, Toast.LENGTH_SHORT);

                toast.show();
                return;
            }

            if(userNameStr.equals(USER) && userPWStr.equals(PW)){
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_succesfull, Toast.LENGTH_SHORT);
                toast.show();
            }

            else{
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_user_wrong_user_name_or_pw, Toast.LENGTH_SHORT);
                toast.show();

                Log.w(TAG, "Login e senha incorretos");
            }
        });

        Log.i(TAG, "O metodo onCreat executou sem erros");
    }

        public void forgotPW (View view) {
            Toast toast = Toast.makeText(view.getContext(),
                    R.string.login_user_forgot_pw_message, Toast.LENGTH_LONG);

            toast.show();
        }
    }