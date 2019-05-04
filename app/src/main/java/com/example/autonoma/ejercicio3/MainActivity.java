package com.example.autonoma.ejercicio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etUsuario, etClave;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        etUsuario= findViewById(R.id.edUsuario);
        etClave= findViewById(R.id.edClave);

        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logearse hardcode
                if(etUsuario.getText().toString().equals("elvis") &&
                        etClave.getText().toString().equals("123")){
                    //
                    Intent intent = new Intent(
                            MainActivity.this,
                            ProfesoresActivity.class);
                    //Ir a Profesor Activity
                    startActivity(intent);

                }//if
            }//onclick
        });//setOnClickListener


    }
}
