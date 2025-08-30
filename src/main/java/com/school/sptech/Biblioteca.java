package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria) {
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        qtdLivros = 0;
        ativa = true;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMultaDiaria() {
        return this.multaDiaria;
    }

    public Integer getQtdLivros() {
        return this.qtdLivros;
    }

    public Boolean getAtiva() {
        return this.ativa;
    }

    public void registrarLivro(Integer quantidade) {
        if (quantidade != null && quantidade > 0 && this.ativa) {
            this.qtdLivros += quantidade;
        }
    }

    public Integer emprestar(Integer quantidade) {
        if (this.ativa && quantidade != null && quantidade > 0 && quantidade <= qtdLivros) {
            this.qtdLivros -= quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer devolver(Integer quantidade) {
        if (this.ativa && quantidade != null && quantidade > 0) {
            this.qtdLivros += quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer desativar() {
        if (!this.ativa) {
            return null;
        } else {
            Integer quantidadeLivrosAnterior = this.qtdLivros;
            this.ativa = false;
            qtdLivros  = 0;
            return quantidadeLivrosAnterior;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade) {
        if (this.ativa && destino.ativa) {
            if (quantidade != null && quantidade > 0 && quantidade <= qtdLivros) {
                this.qtdLivros -= quantidade;
                destino.qtdLivros += quantidade;
            }
        }
    }

    public Boolean reajustarMulta(Double percentual) {
        if (percentual != null && percentual > 0) {
            this.multaDiaria += percentual * multaDiaria;
            return true;
        } else {
            return false;
        }
    }
}
