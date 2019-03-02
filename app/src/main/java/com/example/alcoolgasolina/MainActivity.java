package com.example.alcoolgasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText alcool;
    private EditText gasolina;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alcool = findViewById(R.id.alcoolPrecoEditText);
        gasolina = findViewById(R.id.gasolinaPrecoEditText);
        resultadoTextView = findViewById(R.id.resultadoTextView);

    }

    public void calcularPreco(View view) {

        String precoAlcool = alcool.getText().toString();
        String precoGasolina = gasolina.getText().toString();

        //Validar os campos
        if (validarCampos(precoAlcool, precoGasolina)){
            calcularMelhorPreco(precoAlcool, precoGasolina);
        } else {
            resultadoTextView.setText("Preencha os preços primeiro!");
        }
    }

    private boolean validarCampos(String pAlcool, String pGasolina){

        if (pAlcool == null || pAlcool.equals(""))
            return false;

        if (pGasolina == null || pGasolina.equals(""))
            return false;

        return true;
    }

    private void calcularMelhorPreco(String pAlcool, String pGasolina){

        //converter valores de string para numeros
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);
        Double resultado = precoAlcool / precoGasolina;

        if (resultado >= 0.7)
            resultadoTextView.setText("Melhor utilizr Gasolina!");
        else
            resultadoTextView.setText("Melhor utilizr Álcool!");
    }
}
