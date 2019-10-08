/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controle_estoque.dao;

import br.com.application.controle_estoque.model.Historico;
import br.com.application.controle_estoque.model.Produto;
import br.com.application.controle_estoque.util.ConnectionFactory;
import br.com.application.controle_estoque.dao.produtoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natan
 */
public class HistoricoDAO {
    private Connection con;
    private PreparedStatement st;
    private String sql;
    /**
     * Insere um novo registro de historico.
     * @param his Historico- Objeto do tipo Historico.
     * @throws SQLException
     */
    public void inserir(Historico his) throws SQLException{
        Produto p = new produtoDAO().getProduto(his.getCodigo());
        //se não existir cadastro de produtos cadadastra um novo
        if(p == null){
            p = new Produto(his.getNome(), his.getCodigo(), his.getQuantidade(), his.getPreco());
            new produtoDAO().inserir(p);
        }//caso contrario altera apenas a quantidades segundo a movimentação.
        else{
            new produtoDAO().alterarQuantidade(his.getCodigo(), his.getMovimentacao());
        }

        sql = "insert into historico(entrada_saida, movimentacao, data, id_produto) values(?, ?, ?, ?)";

        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sql);
        st.setString(1, his.getEntrada_saida());
        st.setInt(2, his.getMovimentacao());
        st.setString(3, his.getData());
        st.setInt(4, new produtoDAO().getId(p));
        
        st.executeUpdate();
        
        con.close();
    }
    /**
     * Traz todo o historico.
     * @return list<historico> - lista com todo o historico de E/S de produtos.
     * @throws SQLException
     */
    public List<Historico> listHistorico() throws SQLException{
        sql = "select * from historico";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<Historico> his = new ArrayList<>();
        
        while(rs.next()){
            int Id = rs.getInt("id_produto");
            int movimentacao = rs.getInt("movimentacao");
            String entrada_saida = rs.getString("entrada_saida");
            String data = rs.getString("data");

            Produto p = new produtoDAO().getProdutoById(Id);
            Historico h = new Historico(p, entrada_saida, movimentacao, data);
            
            his.add(h);
        }

        con.close();
        return his;
    }
    /**
     * Lista todo o historico de determinado produto.
     * @param codigo int - codigo do produro.
     * @return list<Historico>- retorna uma lista do tipo historico.
     * @throws SQLException
     */

    public List<Historico> listHistorico(int codigo) throws SQLException{
        sql = "select * from historico where id_produto = ?";
        Produto p = new produtoDAO().getProduto(codigo);

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);
        st.setInt(1, new produtoDAO().getId(p));
        ResultSet rs = st.executeQuery();
        List<Historico> his = new ArrayList<>();
        Historico h = null;
        while(rs.next()){
            int movimentacao = rs.getInt("movimentacao");
            String entrada_saida = rs.getString("entrada_saida");
            String data = rs.getString("data");

            h = new Historico(p, entrada_saida, movimentacao, data);
            his.add(h);
        }

        con.close();
        return his;
    }
}
