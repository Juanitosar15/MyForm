package com.juanpablo.myform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText txtNombre2;
    private Button btnContinuar1;
    private String Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_formred2);


        txtNombre2 =  (EditText) findViewById(R.id.EditTxtNombre);
        btnContinuar1= (Button) findViewById(R.id.btnContinuar1);

        btnContinuar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Nombre=txtNombre2.getText().toString();
                if(!Nombre.isEmpty()) {

                    Intent continuar1 = new Intent(MainActivity.this, SecondActivity.class);

                    continuar1.putExtra("nombre", Nombre);
                    startActivity(continuar1);

                }else{

                    Toast.makeText(MainActivity.this, "Debe introducir un nombre valido", Toast.LENGTH_SHORT).show();

                }
            }
        })
        ;



    }

}
