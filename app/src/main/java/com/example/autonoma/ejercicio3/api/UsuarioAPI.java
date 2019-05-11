package com.example.autonoma.ejercicio3.api;

import com.example.autonoma.ejercicio3.model.Usuario;
import com.example.autonoma.ejercicio3.model.Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuarioAPI {

    @GET("users")
        //url faltante
    Call<List<Usuarios>> getAllUsuarios();
}