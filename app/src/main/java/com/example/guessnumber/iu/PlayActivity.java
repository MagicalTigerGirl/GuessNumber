package com.example.guessnumber.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Integer;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


import com.example.guessnumber.R;
import com.example.guessnumber.data.Information;
import com.example.guessnumber.data.InformationFinal;

public class PlayActivity extends AppCompatActivity {
    /**
     * La Activity en donde se juega, el jugador debe introducir un número comprendido entre 0 y 100 y para comprobar si es el número correcto debe darle al botón.
     * Para volver a intentarlo debe darle al botón "voler a intentar", ya que el botón "probar" queda deshabilitada hasta que pulsa este botón.
     * Cuando acierta el número o se queda sin intentos salta a la Activity final
     * */

    private Integer numeroIntentos = 0;
    Random random = new Random();
    private Integer numeroAAdivinar = random.nextInt((100 - 0) + 1);
    private Integer numeroIntroducido = 0;
    private Integer acertado = 0;


    private EditText etPosibleNumero;
    private TextView tvPrueba;
    private Button btnProbarNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        etPosibleNumero = findViewById(R.id.etPosibleNumero);
        tvPrueba = findViewById(R.id.tvPrueba);
        btnProbarNumero = findViewById(R.id.btnProbarNumero);

        Bundle bundle = getIntent().getExtras();

        Information information= bundle.getParcelable("information");
        numeroIntentos = Integer.parseInt(information.getIntentos());
    }

    public void adivinarNumero(View view){
        if (VerificarCamposLlenos() == true)
        {
            numeroIntentos--;
            CompararNumero(numeroAAdivinar, numeroIntroducido);
            btnProbarNumero.setEnabled(false);
        }
        else
            Toast.makeText(this,getResources().getString(R.string.errorEditTextVacio),Toast.LENGTH_SHORT).show();

        if (numeroIntentos== -1)
        {
            UltimaActivity();
        }
    }

    public void volverAIntentar(View view){
        if (numeroIntentos >= 0)
        {
            tvPrueba.setText("");
            etPosibleNumero.setText("");
            btnProbarNumero.setEnabled(true);
        }
        else
            Toast.makeText(this,getResources().getString(R.string.intentosAgotados),Toast.LENGTH_SHORT).show();
    }

    public boolean VerificarCamposLlenos(){

        if (TextUtils.isEmpty(etPosibleNumero.getText()))
        {
            Toast.makeText(this,getResources().getString(R.string.errorEditTextVacio),Toast.LENGTH_SHORT).show();
            return false;
        }

        numeroIntroducido = Integer.parseInt(etPosibleNumero.getText().toString());
        return true;
    }

    public void CompararNumero(Integer x, Integer y)
    {
        if(x<y)
            numeroAAdivinarMenor();

        if(x==y)
        {
            acertado = 1;
            UltimaActivity();
        }

        if(x>y)
            numeroAAdivinarMayor();
    }

    public void numeroAAdivinarMenor()
    {
        tvPrueba.setText(getResources().getString(R.string.numeroMenor) + " " + numeroIntentos);
    }

    public void numeroAAdivinarMayor()
    {
        tvPrueba.setText(getResources().getString(R.string.numeroMayor) + " " + numeroIntentos);
    }

    public void UltimaActivity()
    {
        Bundle bundle = getIntent().getExtras();
        Information information = bundle.getParcelable("information");

        InformationFinal informationFinal = new InformationFinal(information.getUsuario(), (Integer.parseInt(information.getIntentos())-numeroIntentos),numeroAAdivinar, acertado);
        bundle.putParcelable("informationFinal", informationFinal);

        Intent intent = new Intent(this, EndPlayActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

        finish();
    }
}