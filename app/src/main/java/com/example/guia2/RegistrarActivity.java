package com.example.guia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.model.Persona;

import java.util.ArrayList;

public class RegistrarActivity extends AppCompatActivity {
    EditText edtNombre;
    Button btnGuardar;
    public static ArrayList<Persona> persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        edtNombre = findViewById(R.id.edtNombre);
        btnGuardar = findViewById(R.id.btnGuardar);
        persona = new ArrayList<>();
    }

    public void guardarRegistro(View view){
        persona.add(new Persona(edtNombre.getText().toString()));
        Toast.makeText(RegistrarActivity.this, "Guardado con éxito", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}