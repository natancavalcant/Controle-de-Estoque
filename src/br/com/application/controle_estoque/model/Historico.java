/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controle_estoque.model;

import static br.com.application.controle_estoque.util.DateUtil.stringToDate;
import static br.com.application.controle_estoque.util.DateUtil.dateToString;

import java.util.Date;

/**
 *Cria um objeto do tipo historico que herda de produto
 * @author natan
 * @param entrada_saida String, identifica a operação de entrada ou saida dos produtos.
 * @param movimentacao int, identifica a quantidade que entrou ou saiu do produto, para a saida do produto o valor deve ser negativo.
 * @param data Date, especifica a dada em que os dados foram inseridos.
 */

public class Historico extends Produto {
    
    private String entrada_saida;
    private int movimentacao;
    private Date data;

    public Historico() {
        super();
    }

    public Historico(Produto p, String entrada_saida, int movimentacao, String data) {
        super(p.getNome(), p.getCodigo(), p.getQuantidade(), p.getPreco());
        this.entrada_saida = entrada_saida;
        this.movimentacao = movimentacao;
        this.data = stringToDate(data);
        
    }
  
    public Historico(String nome, int codigo, int quantidade, float preco, String entrada_saida, int movimentacao, String data) {
        super( nome, codigo, quantidade, preco);
        this.entrada_saida = entrada_saida;
        this.movimentacao = movimentacao;
        this.data = stringToDate(data);
    }

    public void setEntrada_saida(String entrada_saida) {
        this.entrada_saida = entrada_saida;
    }
    public void setMovimentação(int movimentacao) {
        this.movimentacao = movimentacao;
    }
    
    public void setData() {
        this.data = new Date();
    }
    
    public void setData(String s){
        this.data = stringToDate(s);
    }
    
    public void setData(Date d){
        this.data = d;
    }

    public String getEntrada_saida() {
        return entrada_saida;
    }
    public int getMovimentacao() {
        return movimentacao;
    }
    
    public String getData() {
        return dateToString(data);
    }

    public Produto getProduto(){
        return new Produto(super.getNome(), super.getCodigo(), super.getQuantidade(), super.getPreco());
    }
      
}
