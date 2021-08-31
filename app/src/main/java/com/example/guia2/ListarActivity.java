package com.example.guia2;

import static com.example.guia2.RegistrarActivity.persona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.model.Persona;

public class ListarActivity extends AppCompatActivity {
    ListView lsvPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lsvPersona = findViewById(R.id.lsvPersona);
        ArrayAdapter<Persona> adPersona = new ArrayAdapter(this, android.R.layout.simple_list_item_1, persona);
        lsvPersona.setAdapter(adPersona);
        adPersona.notifyDataSetChanged();
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