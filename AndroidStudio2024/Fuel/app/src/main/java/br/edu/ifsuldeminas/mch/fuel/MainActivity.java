package br.edu.ifsuldeminas.mch.fuel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private SharedPreferences preferences;
    private static final String PREFS_KEY = "br.edu.ifsuldeminas.mch.fuel.prefs";
    private static final String GAS_KEY = "preco_gas";
    private static final String ETANOL_KEY = "preco_etanol";

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = preferences.edit();
        String gasPrice = TextInputEditGas.getText().toString();
        if (!gasPrice.equals("")){
            editor.putString(GAS_KEY, gasPrice);
        }

        String etanolPrice = TextInputEditEtanol.getText().toString();

        if (!etanolPrice.equals("")){
            editor.putString(ETANOL_KEY, etanolPrice);
        }

        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (preferences.contains(GAS_KEY)){
            String gasPrice = preferences.getString(GAS_KEY, "");
            TextInputEditGas.setText((gasPrice));
        }

        if (preferences.contains(ETANOL_KEY)){
            String etanolPrice = preferences.getString(ETANOL_KEY, "");
            TextInputEditEtanol.setText((etanolPrice));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

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

         imageViewShare.setOnClickListener(view -> {
             AlertDialog.Builder builder = new AlertDialog.Builder(this);

             builder.setTitle("Preço de qual posto?");

             LayoutInflater inflater = getLayoutInflater();
             View layoutDialogView = inflater.inflate(R.layout.alert_dialog_gas_station_view, null);
             builder.setView(layoutDialogView);

             builder.setNegativeButton("Cancelar", null);
             builder.setPositiveButton("Enviar", (dialogLayout, button) -> {
                 EditText editText = layoutDialogView.findViewById(R.id.editTextAlertDialogId);
                 String posto = editText.getText().toString();

                 if (posto.equals("")){
                     Toast toast = Toast.makeText(this, "Nome do posto não pode ser vazio!", Toast.LENGTH_SHORT);
                     toast.show();
                     return;
                 }

                 String message = String.format("Preços do posto '%s'. Gasolina: %.2f, Etanol: %.2f. %s. %.2f %s",
                         posto, gasPrice, etanolPrice, tip, etanolPrice/gasPrice*100, "%");

                 Intent sendIntent = new Intent();
                 sendIntent.setAction(Intent.ACTION_SEND);
                 sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                 sendIntent.setType("text/plain");

                 Intent shareintent = Intent.createChooser(sendIntent, "");
                 startActivity(shareintent);
             });

             builder.create().show();
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