package com.facens.AC2.Domain.Entity;

import com.facens.AC2.Domain.Enum.Plano;

public class Curso {

    private long id;
    private String nome;
    private Plano plano;

    public Curso(long id, String nome, Plano plano) {
        this.id = id;
        this.nome = nome;
        this.plano = plano;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}