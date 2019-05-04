package com.example.autonoma.ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ProfesoresActivity extends AppCompatActivity {

    EditText etNombre;
    Button btnGrebar;
    ArrayList Profesores;
    ListView lvProfesores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);
        //
        etNombre= findViewById(R.id.etNombre);
        btnGrebar= findViewById(R.id.btnAgregar);
        lvProfesores = findViewById(R.id.lvProfesores);
        // inicializamos el array
        Profesores = new ArrayList<String>();
        //adaptadoir
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        Profesores);
        //asignamos adaptador al list view
        lvProfesores.setAdapter(adapter);
        //
        btnGrebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profesores.add(etNombre.getText().toString());
                lvProfesores.deferNotifyDataSetChanged();
            }
        });


    }
}
