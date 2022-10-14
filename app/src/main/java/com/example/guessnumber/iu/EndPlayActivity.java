package com.example.guessnumber.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.guessnumber.R;
import com.example.guessnumber.data.Information;
import com.example.guessnumber.data.InformationFinal;

public class EndPlayActivity extends AppCompatActivity {

    private TextView tvResultado;
    private TextView tvUsuario;
    private TextView tvIntentos;
    private Integer resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_play);
        tvResultado = findViewById(R.id.tvResultado);
        tvUsuario = findViewById(R.id.tvUsuario);
        tvIntentos = findViewById(R.id.tvIntentos);

        Bundle bundle = getIntent().getExtras();
        InformationFinal informationFinal = bundle.getParcelable("informationFinal");
        resultado = informationFinal.getAcertado();
        if(informationFinal.getAcertado() == 1)
        {
            tvResultado.setText(getResources().getString(R.string.hasGanado));
            tvIntentos.setText("Has consumido" + informationFinal.getIntentos());
        }
        else
        {
            tvResultado.setText(getResources().getString(R.string.hasPerdido));
        }




    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * Este método se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}