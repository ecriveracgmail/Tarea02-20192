package com.example.autonoma.ejercicio3.model;

import java.util.List;

public class Usuarios {

    String page, per_page,total,total_pages;
    List<Usuario> data;

    public Usuarios(String page, String per_page, String total,
                    String total_pages, List<Usuario> data) {

        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;

    }
}
