package com.teste.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@jakarta.persistence.Entity
public class Produto {

    //#region Atributos
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String nome;

    private Integer quantidade;

    private double valor;

    private String obs;

    public static Produto of (Integer id, String nome) {
        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome(nome);

        return produto;
    }

    //#endregion

    //#region Getters e Setters
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    //#endregion    
}
