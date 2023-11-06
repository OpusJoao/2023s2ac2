package com.facens.AC2.Domain.Entity;
import java.util.*;

import com.facens.AC2.Domain.Enum.Plano;

public class Aluno {

    private long id;
    private String nome;
    private String email;
    private String senha;
    private Plano plano;
    private List<Curso> cursos;

    public Aluno(String nome, String email, String senha, Plano plano, List<Curso> cursos) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.plano = plano;
        this.cursos = cursos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}