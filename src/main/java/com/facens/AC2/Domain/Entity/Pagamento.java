package com.facens.AC2.Domain.Entity;

import com.facens.AC2.Domain.Enum.Plano;
import com.facens.AC2.Domain.Enum.StatusPagamento;

public class Pagamento {

    private long id;
    private long aluno;
    private float valor;
    private StatusPagamento statusPagamento;
    private Plano produto;

    public Pagamento(long id, long aluno, float valor, StatusPagamento statusPagamento, Plano produto) {
        this.id = id;
        this.aluno = aluno;
        this.valor = valor;
        this.statusPagamento = statusPagamento;
        this.produto = produto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

//    public boolean confirmarPagamento() {
//        if(this.produto != null && this.statusPagamento == StatusPagamento.PAGO) {
//            this.aluno.setPlano(Plano.BASICO);
//            return true;
//        }
//        return false;
//    }
}