package br.edu.ifsuldeminas.mch.fuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText TextInputEditEtanol;
    private TextInputEditText TextInputEditGas;
    private Button buttonCalcular;
    private ImageView imageViewResult;
    private ImageView imageViewShare;
    private TextView textViewResult;
    private String tip;
    private Double etanolPrice, gasPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         TextInputEditEtanol = findViewById(R.id.textInputEditTextEtanol);
         TextInputEditGas = findViewById(R.id.textInputEditTextGas);
         buttonCalcular = findViewById(R.id.buttonCalcular);
         imageViewResult = findViewById(R.id.imageViewFuel);
         imageViewShare = findViewById(R.id.imageViewShare);
         textViewResult = findViewById(R.id.textViewMessage);

         buttonCalcular.setOnClickListener(view -> {
             String etanolPriceStr = TextInputEditEtanol.getText().toString();
             String gasPriceStr = TextInputEditGas.getText().toString();

             if(etanolPriceStr.equals("")){
                 Toast.makeText(getApplicationContext(), "O valor do etanol não foi informado!", Toast.LENGTH_LONG).show();

                 return;
             }

             if(gasPriceStr.equals("")){
                 Toast.makeText(getApplicationContext(), "O valor da gasolina não foi informado!", Toast.LENGTH_LONG).show();

                 return;
             }

             etanolPrice = Double.parseDouble(etanolPriceStr);
             gasPrice = Double.parseDouble(gasPriceStr);

             if(etanolPrice/gasPrice < 0.7){
                 imageViewResult.setImageResource(R.drawable.ethanol);
                 tip = "Melhor usar etanol!";
             }else{
                 imageViewResult.setImageResource(R.drawable.gas);
                 tip = "Melhor usar gasolina!";
             }

             textViewResult.setText(tip);
             imageViewResult.setVisibility(ImageView.VISIBLE);
             textViewResult.setVisibility(TextView.VISIBLE);
             imageViewShare.setVisibility(ImageView.VISIBLE);
         });
    }

    @Override
    protected void onStart() {
        super.onStart();

        imageViewResult.setVisibility(ImageView.INVISIBLE);
        textViewResult.setVisibility(TextView.INVISIBLE);
        imageViewShare.setVisibility(ImageView.INVISIBLE);
    }
}