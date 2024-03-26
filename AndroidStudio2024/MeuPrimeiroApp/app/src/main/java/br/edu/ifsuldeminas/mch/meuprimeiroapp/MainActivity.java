package br.edu.ifsuldeminas.mch.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Acessar o botão

        Button buttonLogin = findViewById(R.id.buttonLogin);

        //Chamar o OnClickListener

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast =Toast.makeText(view.getContext(), R.string.login_succesfull, Toast.LENGTH_LONG);

                toast.show();
            }
        });

        buttonLogin.setOnClickListener(view -> {
            Toast toast =Toast.makeText(view.getContext(), R.string.login_succesfull, Toast.LENGTH_LONG);

            toast.show();
        });


    }
}