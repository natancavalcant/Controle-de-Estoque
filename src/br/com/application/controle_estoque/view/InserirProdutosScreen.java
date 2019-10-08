package br.com.application.controle_estoque.view;

import br.com.application.controle_estoque.dao.produtoDAO;
import br.com.application.controle_estoque.model.Produto;
import br.com.application.controle_estoque.model.Historico;

import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;
import java.sql.SQLException;

public class InserirProdutosScreen{

    private JLabel nome;
    private JLabel codigo;
    private JLabel preco;
    private JLabel quantidade;
    private JTextField nomeText;
    private JTextField codigoText;
    private JTextField precoText;
    private JTextField quantidadeText;
    private JButton inserir;

    public InserirProdutosScreen(){
        nome = new JLabel("Nome");
        codigo = new JLabel("Código");
        preco = new JLabel("Preço");
        quantidade = new JLabel("Quantidade: ");
        inserir = new JButton("Inserir");
        nomeText = new JTextField();
        codigoText = new JTextField();
        precoText = new JTextField();
        quantidadeText = new JTextField();
    }
    public JPanel getScreen(){
        JPanel screen = new JPanel();
        screen.add(nome);
        screen.add(nomeText);
        screen.add(codigo);
        screen.add(codigoText);
        screen.add(preco);
        screen.add(precoText);
        screen.add(quantidade);
        screen.add(quantidadeText);
        screen.add(inserir);

        return screen;
    }
}