/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controle_estoque.model;

/**
 *
 * @author natan
 */
public class Produto {
   
    private String nome;
    private int codigo, quantidade;
    private float preco;
    
    public Produto(){
    
    }
    
    public Produto(String nome, int codigo, int quantidade, float preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String getNome(){
        return nome;
    }
        

    public int getQuantidade() {
        return quantidade;
    }

    public float getPreco() {
        return preco;
    }
    
}
