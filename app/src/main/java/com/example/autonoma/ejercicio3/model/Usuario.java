package com.example.autonoma.ejercicio3.model;

public class Usuario  {
    int id;
    String email,first_name,last_name,avatar;

    public Usuario(int id, String email, String first_name,
                   String last_name, String avatar){
        this.id=id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.avatar=avatar;

    }

}
