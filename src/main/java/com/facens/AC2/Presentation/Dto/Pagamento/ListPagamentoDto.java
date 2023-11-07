package com.facens.AC2.Presentation.Dto.Pagamento;

import com.facens.AC2.Domain.Entity.Aluno;
import com.facens.AC2.Domain.Enum.Plano;
import com.facens.AC2.Domain.Enum.StatusPagamento;

public class ListPagamentoDto {

    private long aluno;
    private float valor;
    private StatusPagamento statusPagamento;
    private Plano produto;

    public ListPagamentoDto(long aluno, float valor, StatusPagamento statusPagamento, Plano produto) {
        this.aluno = aluno;
        this.valor = valor;
        this.statusPagamento = statusPagamento;
        this.produto = produto;
    }

    public long getAluno() {
        return aluno;
    }

    public void setAluno(long aluno) {
        this.aluno = aluno;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Plano getProduto() {
        return produto;
    }

    public void setProduto(Plano produto) {
        this.produto = produto;
    }

}