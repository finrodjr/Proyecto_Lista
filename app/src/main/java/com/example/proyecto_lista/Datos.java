package com.example.proyecto_lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Datos extends AppCompatActivity {
    TextView tnombre, tfecha, ttel, tmail, tdescripcion;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datoss);


        tnombre = (TextView) findViewById(R.id.textViewFullName);
        tfecha = (TextView) findViewById(R.id.textViewDateOfBirth);
        ttel = (TextView) findViewById(R.id.textViewPhone);
        tmail =(TextView)  findViewById(R.id.textViewEmail);
        tdescripcion = (TextView) findViewById(R.id.textViewDescription);
        b=(Button) findViewById(R.id.buttonEdit);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Datos.this, MainActivity.class);
                startActivity(i);
            }
        });

        mostrarDatos();
    }

    private void mostrarDatos() {
        // Obtener los datos del Intent
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle datos = intent.getExtras();

            String n = datos.getString("nom");
            String f = datos.getString("date");
            String t = datos.getString("telef");
            String m = datos.getString("em");
            String d = datos.getString("description");


                tnombre.setText("Nombre: "+n);
                tfecha.setText("Fecha de nacimiento: "+f);
                ttel.setText("#telefono: "+t);
                tmail.setText("eMail: "+m);
                tdescripcion.setText("Descripcion: "+d);

        }
    }


}





