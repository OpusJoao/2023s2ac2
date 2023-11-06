package com.facens.AC2.Presentation.Dto.Aluno;

import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Enum.Plano;

import java.util.List;

public class ListAlunoDto {
    private long id;
    private String nome;
    private String email;
    private Plano plano;
    private List<Curso> cursos;

    public ListAlunoDto(long id, String nome, String email, Plano plano, List<Curso> cursos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
