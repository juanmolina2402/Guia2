package com.example.guia2;

import static com.example.guia2.RegistrarActivity.persona;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAgregar, btnListar, btnMostrarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListar = findViewById(R.id.btnVerLista);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnMostrarDatos = findViewById(R.id.btnDatos);
    }

    public void verLista(View view){
        if(persona == null || persona.isEmpty()){
            Toast.makeText(MainActivity.this, "Lista vacía", Toast.LENGTH_SHORT).show();
        }else {
            startActivity(new Intent(MainActivity.this, ListarActivity.class));
        }
    }

    public void agregarNombre(View view){
        startActivity(new Intent(MainActivity.this, RegistrarActivity.class));
    }

    public void mostrarDatos(View view){
        startActivity(new Intent(MainActivity.this, DatosActivity.class));
    }
}