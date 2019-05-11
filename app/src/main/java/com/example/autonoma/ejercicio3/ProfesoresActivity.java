package com.example.autonoma.ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
        });//fin setOnClickListener


    } // Fin onCreate

    //mostramos el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return  true;

    }
    //detectar click


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_add_item:
                Toast.makeText(
                        ProfesoresActivity.this,
                        "Agregar Item",
                        Toast.LENGTH_LONG).show();
                return true;
            //
            
            default:
                return super.onOptionsItemSelected(item);
        }
        //
    }
} // Fin ProfesoresActivity





/*
*
* // Inflamos el layout del menu de opciones

// Manejamos eventos click en el menu de opciones
@Override
public boolean onOptionsItemSelected(MenuItem item) {
   switch (item.getItemId()) {
       case R.id.add_item:
           // Añadimos nuevo nombre
           this.alummnos.add("Added nº" + (++contador));
           // Notificamos al adaptador del cambio producido
           this.miAdaptador.notifyDataSetChanged();
           return true;
       default:
           return super.onOptionsItemSelected(item);
   }
}


* */
