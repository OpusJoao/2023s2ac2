package com.facens.AC2.Presentation.Dto.Curso;

import com.facens.AC2.Domain.Enum.Plano;

public class ListCursoDto {

    private String nome;
    private Plano plano;

    public ListCursoDto(String nome, Plano plano) {
        this.nome = nome;
        this.plano = plano;
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