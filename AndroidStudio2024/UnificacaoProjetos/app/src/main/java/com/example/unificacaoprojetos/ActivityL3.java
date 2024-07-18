package com.example.unificacaoprojetos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityL3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melhor_texto);

        Button bHomeConstraint = findViewById(R.id.homePageMelhorTexto);
        bHomeConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityL3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
