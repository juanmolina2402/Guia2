package com.example.guia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.Persona;

import java.util.ArrayList;

public class RegistrarActivity extends AppCompatActivity {
    EditText edtNombre;
    Button btnGuardar;
    public static ArrayList<Persona> persona;
    private ProgressBar prgBar;
    private int prgStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        edtNombre = findViewById(R.id.edtNombre);
        btnGuardar = findViewById(R.id.btnGuardar);
        prgBar = findViewById(R.id.pbGuardar);
        textView = findViewById(R.id.tvProgressBar);
        if(persona == null){
            persona = new ArrayList<>();
        }
    }

    public void guardarRegistro(View view){
        if(edtNombre.getText().toString().length() != 0 ){
            ProgressBar();
        }
    }

    private void ProgressBar(){
        new Thread(new Runnable() {
            public void run() {
                while (prgStatus < 100) {
                    prgStatus += 25;
                    handler.post(new Runnable() {
                        public void run() {
                            prgBar.setProgress(prgStatus);
                            textView.setText(prgStatus+"/"+prgBar.getMax());
                            if(prgStatus == 100){
                                persona.add(new Persona(edtNombre.getText().toString()));
                                Toast.makeText(RegistrarActivity.this, "Guardado con éxito", Toast.LENGTH_LONG).show();
                                edtNombre.setText("");
                                prgBar.setProgress(0);
                            }
                        }
                    });
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                prgStatus = 0;
            }
        }).start();
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