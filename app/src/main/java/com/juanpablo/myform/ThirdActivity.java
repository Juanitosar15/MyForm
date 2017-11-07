package com.juanpablo.myform;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private ImageButton imgbtnResultado;
    private Button btnCompartir;
    private String mensajeSaludo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Bundle bundle3 = getIntent().getExtras();
        String Nombre = bundle3.getString("nombre");
        int edad = bundle3.getInt("edad");
        String saludo = bundle3.getString("saludo");
        //saludo = saludo.trim();

        if (saludo.equals("Saludo")){
           mensajeSaludo= "Hola " + Nombre + ", como llevas esos " + edad + " años? #" + ThirdActivity.this.getTitle();
        }else if (saludo.equals("Despedida")){
            mensajeSaludo= "Espero verte pronto " + Nombre + ", antes de que cumplas " + (edad+1) + " #" + ThirdActivity.this.getTitle();
        }else{
            mensajeSaludo= saludo;

        }


        imgbtnResultado = (ImageButton) findViewById(R.id.imgBtnResultado);
        btnCompartir= (Button) findViewById(R.id.buttonCompartir);
        btnCompartir.setVisibility(View.INVISIBLE);

        imgbtnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgbtnResultado.setVisibility(View.GONE);

                btnCompartir.setVisibility(View.VISIBLE);
                Toast.makeText(ThirdActivity.this, mensajeSaludo, Toast.LENGTH_SHORT).show();
            }

        });

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent();
                intent3.setAction(Intent.ACTION_SEND);
                intent3.putExtra(intent3.EXTRA_TEXT, mensajeSaludo);
                intent3.setType("text/plain");
                startActivity(intent3.createChooser(intent3,"enviar a"));

            }
        });





    }
}
