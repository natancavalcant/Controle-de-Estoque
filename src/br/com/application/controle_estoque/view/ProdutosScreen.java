package br.com.application.controle_estoque.view;

import br.com.application.controle_estoque.dao.produtoDAO;
import br.com.application.controle_estoque.model.Produto;

import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;
import java.sql.SQLException;

public class ProdutosScreen{

    public JPanel getScreen() throws SQLException{
        JTable table = new JTable();
        table.setBorder(new LineBorder(Color.black));
        table.setGridColor(Color.black);
        table.setShowGrid(true);

        ProdutoTableModel produtos = new ProdutoTableModel(setTableProdutos());
        table.setModel(produtos);

        JScrollPane scroll = new JScrollPane(); 
        scroll.getViewport().setBorder(null);
        scroll.getViewport().add(table); 
        scroll.setSize(600, 600);

        JPanel panel = new JPanel();
        panel.add(scroll);

        return panel;
    }

    private List<Produto> setTableProdutos() throws SQLException{
        List<Produto> p = new produtoDAO().listProdutos();
        return p;
    }

    private class ProdutoTableModel extends AbstractTableModel{
        private List<Produto> produtos;
        ProdutoTableModel(List<Produto> p){
            this.produtos = p;
        }
        @Override
        public int getColumnCount(){
            return 4;
        }
        @Override
        public int getRowCount(){
            return produtos.size();
        }
        @Override
        public String getColumnName(int column){
            switch(column){
                case 0:
                    return "CÓDIGO";
                case 1:
                    return "PRODUTO";
                case 2:
                    return "PREÇO";
                case 3:
                    return "QUANTIDADE";
            }
            return "";
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex){
            Produto p = produtos.get(rowIndex);
            switch(columnIndex){
                case 0:
                    return p.getCodigo();
                case 1:
                    return p.getNome();
                case 2:
                    return p.getPreco();
                case 3:
                    return p.getQuantidade();
            }
            return null;
        }
        
    }        
}