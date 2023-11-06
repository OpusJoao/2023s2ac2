package com.facens.AC2.Presentation.Dto.Aluno;

import com.facens.AC2.Domain.Entity.Curso;
import com.facens.AC2.Domain.Enum.Plano;

import java.util.List;

public class CreateAlunoDto {
    private String nome;
    private String email;
    private String senha;
    private Plano plano;
    private List<Curso> cursos;

    public CreateAlunoDto(String nome, String email, String senha, Plano plano) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.plano = plano;
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
