package com.juanpablo.myform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private SeekBar barra1;
    private TextView txtEdad;
    private int edad;
    private Button btnContinuar2;
    private RadioGroup radioGroupEdad;
    private int radiobuttonID;
    private String saludo;
    private RadioButton radioButton1;
    private RadioButton radiobutton2;
    //private String edad1 = getResources().getString(R.string.edad1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //para tomar los datos del activity anterior

        Bundle bundle1 = getIntent().getExtras();
        final String extraNombre = bundle1.getString("nombre");


        barra1= (SeekBar) findViewById(R.id.seekBar1);
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        btnContinuar2 = (Button) findViewById(R.id.btnContinuar2);
        radioGroupEdad = (RadioGroup) findViewById(R.id.radioGroupEdad);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radiobutton2 = (RadioButton) findViewById(R.id.radioButton2);


        edad = barra1.getProgress();

        barra1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                txtEdad.setText(String.valueOf(progress));
                edad = progress;


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (edad <= 15) {
                    btnContinuar2.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this,"La Edad debe ser mayor a 16 años.", Toast.LENGTH_SHORT).show();
                }else if (edad>=60){
                    btnContinuar2.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this, "La edad debe ser menor a 60 años", Toast.LENGTH_SHORT).show();
                }else{
                    btnContinuar2.setVisibility(View.VISIBLE);
                }




            }

        });

        btnContinuar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radiobuttonID = radioGroupEdad.getCheckedRadioButtonId();
                if(radiobuttonID == -1){
                    Toast.makeText(SecondActivity.this, "ninguna opción seleccionada", Toast.LENGTH_SHORT).show();
                }else if(radiobuttonID == R.id.radioButton1){
                    saludo = (String) radioButton1.getText();
                }else if(radiobuttonID == radiobutton2.getId()){
                    saludo = (String) radiobutton2.getText();
                }

                Intent intent2 = new Intent(SecondActivity.this, ThirdActivity.class);

                intent2.putExtra("nombre", extraNombre);
                intent2.putExtra("edad", edad);
                intent2.putExtra("saludo", saludo);


                startActivity(intent2);

            }
        });


    }
}
