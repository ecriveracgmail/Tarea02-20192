package com.example.autonoma.ejercicio3;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.autonoma.ejercicio3.adapter.MainAdapter;
import com.example.autonoma.ejercicio3.api.UsuarioAPI;
import com.example.autonoma.ejercicio3.model.Usuario;
import com.example.autonoma.ejercicio3.model.Usuarios;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProfesoresActivity extends AppCompatActivity {

    EditText etNombre;
    Button btnGrebar;
    ArrayList Profesores;
    ListView lvProfesores;

    ArrayAdapter<String> adapter;

    Retrofit retrofit;
    UsuarioAPI usuarioApi;

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
        adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        Profesores);
        //asignamos adaptador al list view
        //lvProfesores.setAdapter(adapter);
        registerForContextMenu(lvProfesores);
        //
        btnGrebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profesores.add(etNombre.getText().toString());
                lvProfesores.deferNotifyDataSetChanged();
            }
        });//fin setOnClickListener

        //Instancio el adaptador
        retrofit = new MainAdapter().getAdapter();
        //Instancio el API
        usuarioApi = retrofit.create(UsuarioAPI.class);
        //

        Call<List<Usuarios>> usuariosCall =
                usuarioApi.getAllUsuarios();

        Log.d("enqueue","ok");

        usuariosCall.enqueue(new Callback<List<Usuarios>>() {
            @Override
            public void onResponse(Call<List<Usuarios>> call, Response<List<Usuarios>> response) {
                Log.d("returno",response.body().toString());
                //List<Usuario> usuario = response.body().





            /*
            * List<Usuario> usuario = response.body().getData();
               List<String> strings = new ArrayList<>(usuario.size());
               //obtener los nombres
               for (Usuario oUsuario : usuario){
                   strings.add(oUsuario.getFirst_name() + " " + oUsuario.getLast_name()  );
               }
               //
               ArrayAdapter<String> adaptador =
                       new ArrayAdapter<>(MainActivity.this,
                               android.R.layout.simple_list_item_1,
                               strings);


               lvAlumnos.setAdapter(adaptador);
            *
            * */



            }

            @Override
            public void onFailure(Call<List<Usuarios>> call, Throwable t) {

            }
        });


    } // Fin onCreate



    /*
    *
    *
    * */



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //
        MenuInflater inflater = getMenuInflater();
        //Adaptador de Vista
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;
        //
        menu.setHeaderTitle("Profesor:" +
                Profesores.get(info.position));
        //Llama al menu Creado
        inflater.inflate(R.menu.menu_contextual, menu);

    }// fin metodo onCreateContextMenu


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.menu_eliminar:
                //eliminamos el item del array por la posicion
                Profesores.remove(info.position);
                //actualizamos el Adaptador
                adapter.notifyDataSetChanged();
                return true;

            default:
                return super.onContextItemSelected(item);
        }



        //   AdapterView.AdapterContextMenuInfo info =
        // (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

    }// fin metodo onContextItemSelected

    //mostramos el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return  true;

    } // fin onCreateOptionsMenu


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            //inicio case add_item
            case R.id.menu_add_item:
                Toast.makeText(
                        ProfesoresActivity.this,
                        "Agregar Item",
                        Toast.LENGTH_LONG).show();
                //agregar item al listado
                Profesores.add("Profesor X");
                adapter.notifyDataSetChanged();

                return true;

            //inicio case refrescar
            case R.id.menu_refrescar:
                Toast.makeText(
                        ProfesoresActivity.this,
                        "Refrescar",
                        Toast.LENGTH_LONG).show();
                //refrecar el adaptador
                adapter.notifyDataSetChanged();

                return true;

            //inicio case Ver map
            case R.id.menu_vermapa:
                //TIP: Crear in activityt Plantilla Mapa
                //Lleva al Activity
                Toast.makeText(
                        ProfesoresActivity.this,
                        "Ver Mapa",
                        Toast.LENGTH_LONG).show();

                return true;

            //inicio case Cerrar
            case R.id.menu_cerrar:
                //llevarte al mainActivity
                //
                Toast.makeText(
                        ProfesoresActivity.this,
                        "Cerrar Sesión",
                        Toast.LENGTH_LONG).show();
                return true;
            //

            default:
                return super.onOptionsItemSelected(item);
        }
        //
    }//Fin del metodo onOptionsItemSelected


} // Fin ProfesoresActivity


