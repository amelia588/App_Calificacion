package com.example.myapp3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtCurso, edtCalificacion;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtCurso = (EditText) findViewById(R.id.edtCurso);
        edtCalificacion = (EditText) findViewById(R.id.edtCalificacion);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);

        final DeveloBD develoBD = new DeveloBD(getApplicationContext());

        // Evento para el botón Agregar
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Insertar el curso en la base de datos
                develoBD.agregarCurso(
                        edtNombre.getText().toString(),
                        edtCurso.getText().toString(),
                        edtCalificacion.getText().toString()
                );

                // Mostrar mensaje de confirmación
                Toast.makeText(getApplicationContext(), "SE AGREGA CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}