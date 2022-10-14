package com.example.guessnumber.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guessnumber.R;
import com.example.guessnumber.data.Information;

import java.text.NumberFormat;
import java.text.ParseException;

public class ConfigActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etNumeroIntentos;
    private Button btnComenzar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        etNombre = findViewById(R.id.etNombre);
        etNumeroIntentos = findViewById(R.id.etNumeroIntentos);
        btnComenzar = findViewById(R.id.btnComenzar);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfigActivity.this, "A jugar", Toast.LENGTH_SHORT).show();
            }
        });

        btnComenzar.setOnClickListener(view -> config());
    }

    /**
     * Este es el método que se utiliza al hacer click en el button btnComenzar, verifica que estén los 2 valores
     * introducidos, si falta algún valor no funciona el botón
     * */
    public void config() {

        if (VerificarCamposLlenos())
        {
            Bundle bundle = new Bundle();

            Information information = new Information(etNombre.getText().toString(), etNumeroIntentos.getText().toString());
            bundle.putParcelable("information", information);

            Intent intent = new Intent(this, PlayActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    }

    public boolean VerificarCamposLlenos(){

        if (TextUtils.isEmpty(etNombre.getText()) || TextUtils.isEmpty(etNumeroIntentos.getText()))
        {
            Toast.makeText(this,getResources().getString(R.string.errorEditTextVacio),Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}