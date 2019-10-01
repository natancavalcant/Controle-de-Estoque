package br.com.application.controle_estoque.UI;

import br.com.application.controle_estoque.dao.HistoricoDAO;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.application.controle_estoque.dao.produtoDAO;
import br.com.application.controle_estoque.dao.HistoricoDAO;
import br.com.application.controle_estoque.model.Produto;
import sun.awt.image.ImageWatched.Link;
import br.com.application.controle_estoque.model.Historico;
import static br.com.application.controle_estoque.util.DateUtil.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author natan
 */

public class Main {

    public static void main(String[] args) throws Exception {
      //Produto produto;
      //Historico his = new Historico(new produtoDAO().getProduto(3), "Entrou", 5, dateToString(new Date()));
      List<Historico> lhis = new HistoricoDAO().listHistorico(3);
      //new HistoricoDAO().inserir(his);
  
      for(Historico his : lhis){
        System.out.println(his.getNome()+", "+his.getCodigo()+", "+his.getQuantidade()+", "+his.getPreco()+", "+his.getEntrada_saida()+", "+his.getMovimentacao()+", "+his.getData());
      }    
    
         
    }
    
    public static void tela(){
     
       
        
    }
    
}
