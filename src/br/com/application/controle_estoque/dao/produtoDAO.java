/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controle_estoque.dao;

import br.com.application.controle_estoque.model.Produto;
import br.com.application.controle_estoque.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natan
 * @version 1.0
 */

public class produtoDAO {
    private Connection con;
    private PreparedStatement st;
    private String sql;

    /**
     * Método insere um produto no BD.
     * @param p Produto - Objeto do tipo produto
     * @throws SQLException
     */
    public void inserir(Produto p) throws SQLException {
        sql = "insert into produtos(codigo, nome, quantidade, preco) values(?, ?, ?, ?)";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);
        st.setInt(1, p.getCodigo());
        st.setString(2, p.getNome());
        st.setInt(3, p.getQuantidade());
        st.setFloat(4, p.getPreco());

        st.executeUpdate();

        con.close();
    }

    /**
     * Método edita toda as colunas correspondente a um produto. 
     * @param codigo int - recebe o codigo do produto a ser editado
     * @param p Produto - recebe um objeto do tipo Produto
     * @throws SQLException
     */
    public void alterar(int codigo, Produto p) throws SQLException {
        sql = "update produtos set codigo = ?, nome = ?, quantidade = ?, preco = ? where codigo = ?";
        
        con = ConnectionFactory.getConnection();
        
        st = con.prepareStatement(sql);
        st.setInt(1, p.getCodigo());
        st.setString(2, p.getNome());
        st.setInt(3, p.getQuantidade());
        st.setFloat(4, p.getPreco());
        st.setInt(5, codigo);
        
        st.executeUpdate();
        
        con.close();
    }
    /**
     * 
     * @param codigo
     * @param valor
     * @throws SQLException
     */
    public void alterarQuantidade(int codigo, int valor) throws SQLException {
        sql = "update produtos set quantidade = quantidade+? where codigo = ?";
        
        con = ConnectionFactory.getConnection();
        
        st = con.prepareStatement(sql);
        st.setInt(1, valor);
        st.setInt(2, codigo);        
        
        st.executeUpdate();
        
        con.close();
    }
    /**
     * Método retorna o id do produto se não encontrar retorna -1
     * @param p Produto - objeto do tipo produto
     * @return int - id correspondente a tabela no BD
     * @throws SQLException
     */
    public int getId(Produto p) throws SQLException{
        sql = "select id from produtos where codigo = ?";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);
        st.setInt(1, p.getCodigo());
        
        ResultSet rs = st.executeQuery();
        int id = -1;
        if(rs.next()){
            id = rs.getInt("id");
        }

        con.close();
        return id;

    }

    /**
     * Método obtém um produto através do codigo.
     * @param codigo int - Codigo correspondente a o produto.
     * @return Produto
     * @throws SQLException
     */

    public Produto getProduto(int codigo) throws SQLException{
        sql = "select * from produtos where codigo = ?";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        Produto produto = null;
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            produto = new Produto(rs.getString("nome"), rs.getInt("codigo"), rs.getInt("quantidade"), rs.getFloat("preco"));
        }

        con.close();
        return produto;
    }

    public Produto getProdutoById(int Id) throws SQLException{
        sql = "select * from produtos where id = ?";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);
        st.setInt(1, Id);
        Produto produto = null;
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            produto = new Produto(rs.getString("nome"), rs.getInt("codigo"), rs.getInt("quantidade"), rs.getFloat("preco"));
        }

        con.close();
        return produto;
    }

    /**
     * Metodo obtém uma lista de todos os produtos do BD.
     * @return List - lista de Objetos do tipo Produto.
     * @throws SQLException
     */

    public List<Produto> listProdutos() throws SQLException{
        sql = "select * from produtos";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while(rs.next()){
            String nome = rs.getString("nome");
            int codigo = rs.getInt("codigo");
            int quantidade = rs.getInt("quantidade");
            float preco = rs.getFloat("preco");

            produtos.add(new Produto(nome, codigo, quantidade, preco));
        }

        con.close();
        return produtos;
    }

    /**
     * Método deleta um produto através do codigo.
     * @param codigo int - codigo do produto.
     * @throws SQLException
     */
    public void deletar(int codigo) throws SQLException{
        sql = "delete from produtos where codigo = ?";

        con = ConnectionFactory.getConnection();
        
        st = con.prepareStatement(sql);
        st.setInt(1, codigo);

        st.executeUpdate();

        con.close();

    }
    
}
