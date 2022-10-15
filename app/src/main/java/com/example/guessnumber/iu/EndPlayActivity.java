package com.example.guessnumber.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.guessnumber.R;
import com.example.guessnumber.data.Information;
import com.example.guessnumber.data.InformationFinal;

public class EndPlayActivity extends AppCompatActivity {

    /**
     * Es la Activity final, donde muestra todos los resultados y si el jugador ha adivinado el número o no*/

    private TextView tvResultado;
    private TextView tvDescripcionResultado;
    private Integer numero = 0;
    private Integer resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_play);
        tvResultado = findViewById(R.id.tvResultado);
        tvDescripcionResultado = findViewById(R.id.tvDescripcionResultado);

        Bundle bundle = getIntent().getExtras();
        InformationFinal informationFinal = bundle.getParcelable("informationFinal");
        resultado = informationFinal.getAcertado();
        if(informationFinal.getAcertado() == 1)
        {
            tvResultado.setText(getResources().getString(R.string.hasGanado));
            tvDescripcionResultado.setText(" " + informationFinal.getUsuario() + getResources().getString(R.string.elNumeroEra) + " " + informationFinal.getNumero() + " " + getResources().getString(R.string.hasConsumido) + " " + informationFinal.getIntentos() + " " + getResources().getString(R.string.intentos));
        }
        else
        {
            tvResultado.setText(getResources().getString(R.string.hasPerdido));
            tvDescripcionResultado.setText(" " + informationFinal.getUsuario() + getResources().getString(R.string.elNumeroEra) + " " + informationFinal.getNumero());
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