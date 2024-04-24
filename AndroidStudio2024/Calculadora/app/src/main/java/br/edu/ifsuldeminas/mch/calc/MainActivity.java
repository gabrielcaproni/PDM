package br.edu.ifsuldeminas.mch.calc;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "ifsuldeminas.mch.calc";

    private boolean hasDot = false;
    private Button numero_zero,numero_um,numero_dois,numero_tres,numero_quatro, numero_cinco,
            numero_seis,numero_sete,numero_oito,numero_nove;
    private Button buttonDelete, buttonReset, buttonPorcento, buttonDivisao, buttonMult,
            buttonSoma, buttonSub, buttonIgual, buttonVirgula;
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
    }

    private void IniciarComponentes() {

        numero_zero = findViewById(R.id.buttonZeroID);
        numero_um = findViewById(R.id.buttonUmID);
        numero_dois = findViewById(R.id.buttonDoisID);
        numero_tres = findViewById(R.id.buttonTresID);
        numero_quatro = findViewById(R.id.buttonQuatroID);
        numero_cinco = findViewById(R.id.buttonCincoID);
        numero_seis = findViewById(R.id.buttonSeisID);
        numero_sete = findViewById(R.id.buttonSeteID);
        numero_oito = findViewById(R.id.buttonOitoID);
        numero_nove = findViewById(R.id.buttonNoveID);

        buttonDelete = findViewById(R.id.buttonDeleteID);
        buttonReset = findViewById(R.id.buttonResetID);
        buttonPorcento = findViewById(R.id.buttonPorcentoID);
        buttonDivisao = findViewById(R.id.buttonDivisaoID);
        buttonMult = findViewById(R.id.buttonMultiplicacaoID);
        buttonSoma = findViewById(R.id.buttonSomaID);
        buttonSub = findViewById(R.id.buttonSubtracaoID);
        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonVirgula = findViewById(R.id.buttonVirgulaID);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        adicionarEvento();
    }

    private void adicionarEvento() {
        numero_zero.setOnClickListener(v -> {
            AddExpression("0", true);
        });
        numero_um.setOnClickListener(v -> {
            AddExpression("1", true);
        });
        numero_dois.setOnClickListener(v -> {
            AddExpression("2", true);
        });
        numero_tres.setOnClickListener(v -> {
            AddExpression("3", true);
        });
        numero_quatro.setOnClickListener(v -> {
            AddExpression("4", true);
        });
        numero_cinco.setOnClickListener(v -> {
            AddExpression("5", true);
        });
        numero_seis.setOnClickListener(v -> {
            AddExpression("6", true);
        });
        numero_sete.setOnClickListener(v -> {
            AddExpression("7", true);
        });
        numero_oito.setOnClickListener(v -> {
            AddExpression("8", true);
        });
        numero_nove.setOnClickListener(v -> {
            AddExpression("9", true);
        });

        buttonVirgula.setOnClickListener(v -> {
            String expression = textViewUltimaExpressao.getText().toString();
            try{
                if(notTwoOperators(expression.charAt(expression.length() - 1)) && !hasDot) {
                    expression += '.';
                    textViewUltimaExpressao.setText(expression);
                    hasDot = false;
                }
            }catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });

        buttonSoma.setOnClickListener(v -> {
            String expression = textViewUltimaExpressao.getText().toString();
            try{
                if(expression.isEmpty()) {
                    continueExpression('+');
                }

                if(notTwoOperators(expression.charAt(expression.length() - 1))) {
                    expression += '+';
                    textViewUltimaExpressao.setText(expression);
                    hasDot = false;
                } else {
                    char at = expression.charAt(expression.length() - 2);
                    if (!(expression.charAt(expression.length() - 1) == '-' && at == '+' ||
                            expression.charAt(expression.length() - 1) == '-' && at == '/' ||
                            expression.charAt(expression.length() - 1) == '-' && at == '*'
                    )) {
                        expression = expression.substring(0, expression.length() - 1);
                        expression += "+";
                        textViewUltimaExpressao.setText(expression);
                    }
                }
            }catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });

        buttonSub.setOnClickListener(v -> {
            String expression = textViewUltimaExpressao.getText().toString();
            try{
                if(expression.isEmpty()) {
                    continueExpression('-');
                }

                if (expression.equals("") || (expression.charAt(expression.length() - 1)) != '-' || notTwoOperators(expression.charAt(expression.length() - 1))) {
                    expression += "-";
                    textViewUltimaExpressao.setText(expression);
                    hasDot = false;
                }
            }catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });

        buttonMult.setOnClickListener(v -> {
            String expression = textViewUltimaExpressao.getText().toString();
            try{
                if(expression.isEmpty()) {
                    continueExpression('*');
                }

                if(notTwoOperators(expression.charAt(expression.length() - 1))) {
                    expression += '*';
                    textViewUltimaExpressao.setText(expression);
                    hasDot = false;
                }else {
                    char at = expression.charAt(expression.length() - 2);
                    if (!(expression.charAt(expression.length() - 1) == '-' && at == '+' ||
                            expression.charAt(expression.length() - 1) == '-' && at == '/' ||
                            expression.charAt(expression.length() - 1) == '-' && at == '*'
                    )) {
                        expression = expression.substring(0, expression.length() - 1);
                        expression += "*";
                        textViewUltimaExpressao.setText(expression);
                    }
                }
            }catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });

        buttonDivisao.setOnClickListener(v -> {
            String expression = textViewUltimaExpressao.getText().toString();
            try{
                if(expression.isEmpty()) {
                    continueExpression('/');
                }

                if(notTwoOperators(expression.charAt(expression.length() - 1))) {
                    expression += '/';
                    textViewUltimaExpressao.setText(expression);
                    hasDot = false;
                } else {
                    char at = expression.charAt(expression.length() - 2);
                    if (!(expression.charAt(expression.length() - 1) == '-' && at == '+' ||
                            expression.charAt(expression.length() - 1) == '-' && at == '/' ||
                            expression.charAt(expression.length() - 1) == '-' && at == '*'
                    )) {
                        expression = expression.substring(0, expression.length() - 1);
                        expression += "/";
                        textViewUltimaExpressao.setText(expression);
                    }
                }
            }catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });

        buttonPorcento.setOnClickListener(v -> {
            String expression = textViewUltimaExpressao.getText().toString();
            try{
                if(expression.isEmpty()) {
                    continueExpression('%');
                }

                if(notTwoOperators(expression.charAt(expression.length() - 1))) {
                    expression += '%';
                    textViewUltimaExpressao.setText(expression);
                    hasDot = false;
                }
            }catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });

        buttonReset.setOnClickListener(v -> {
            textViewUltimaExpressao.setText("");
            textViewResultado.setText("0");
        });

        buttonDelete.setOnClickListener(v -> {
            TextView expression = findViewById(R.id.textViewUltimaExpressaoID);
            String string = textViewUltimaExpressao.getText().toString();

            if(!string.isEmpty()) {
                byte var0 = 0;
                int var1 = string.length() - 1;
                String txtExpression = string.substring(var0, var1);
                expression.setText(txtExpression);
            }
            textViewResultado.setText("");
        });

        buttonIgual.setOnClickListener(v -> {
            Calculable expressionEvaluator = null;
            try {
                String expression = textViewUltimaExpressao.getText().toString();
                expressionEvaluator = new ExpressionBuilder(expression).build();
                double result = expressionEvaluator.calculate();

                textViewUltimaExpressao.setText(expression);
                textViewResultado.setText(Double.toString(result));
            } catch (ArithmeticException e) {
                Log.e(TAG, "Error: Division by zero or invalid expression", e);
                textViewResultado.setText("Error");
            } catch (NumberFormatException e) {
                Log.e(TAG, "Error: Invalid number format", e);
                textViewResultado.setText("Error");
            }catch (Exception e) {
                Log.d(TAG, e.getMessage());
            }
        });
    }

    public void AddExpression(String string, boolean cleanData) {

        if(textViewResultado.getText().equals("")) {
            textViewUltimaExpressao.setText(" ");
        }

        if(cleanData == true) {
            textViewResultado.setText(" ");
            textViewUltimaExpressao.append(string);
        }else {
            textViewUltimaExpressao.append(textViewResultado.getText());
            textViewUltimaExpressao.append(string);
            textViewResultado.setText(" ");
        }
    }

    public boolean notTwoOperators(char lastChar) {
        return lastChar != '+' && lastChar != '-' && lastChar != '/' && lastChar != '*' && lastChar != '%' && lastChar != '.';
    }

    public void continueExpression(char operator) {
        String expression = textViewUltimaExpressao.getText().toString();
        expression += textViewResultado.getText();
        expression += operator;
        textViewUltimaExpressao.setText(expression);
        textViewResultado.setText('0');
        hasDot = false;
    }
}