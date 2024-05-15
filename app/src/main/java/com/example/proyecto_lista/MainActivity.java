package com.example.proyecto_lista;




import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre, tel, mail, descripcion;
    Button aceptar;
    DatePicker Picker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Picker = (DatePicker) findViewById(R.id.Picker);
        nombre = findViewById(R.id.nombre);
        tel = findViewById(R.id.telefono);
        mail = findViewById(R.id.email);
        descripcion = findViewById(R.id.descripcion);
        aceptar = findViewById(R.id.boton);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = nombre.getText().toString();
                String day = "Dia " + Picker.getDayOfMonth();
                String month = " del mes " + (Picker.getMonth() + 1);
                String year = " y del año " + Picker.getYear();
                String telef = tel.getText().toString();
                String em = mail.getText().toString();
                String description = descripcion.getText().toString();



                // Crear un Intent para pasar los datos a la actividad Datos
                Intent intent = new Intent(MainActivity.this, Datos.class);
                intent.putExtra("nom", nom);
                intent.putExtra("date", day+month+year);
                intent.putExtra("telef", telef);
                intent.putExtra("em", em);
                intent.putExtra("description", description);

                // Iniciar la actividad
                startActivity(intent);
            }
        });
    }
}
