/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controle_estoque.view;

import br.com.application.controle_estoque.view.ProdutosScreen;
import javafx.scene.control.Separator;
import javafx.scene.layout.Border;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;


public class HomeScreen{
    private final JLabel NAME = new JLabel("CONTROLE DE ESTOQUE");
    private final JButton estoqueButton = new JButton("Estoque");
    private final JButton inserir_produtosButton = new JButton("Inserir Produto");
    private final JButton editar_produtosButton = new JButton("Editar Produto");
    private final JButton historicoButton = new JButton("Historico");
    private final JButton sairButton = new JButton("Sair");
    private JFrame home;
    public HomeScreen() throws SQLException{
            home = new JFrame("CONTROLE DE ESTOQUE_ V1.0");
            
            JPanel box1 = setMenu();
            
            home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            home.getContentPane().add(NAME, BorderLayout.NORTH);
            home.getContentPane().add(box1, BorderLayout.WEST);

            home.pack();
            home.setVisible(true);
            home.setExtendedState(JFrame.MAXIMIZED_BOTH);         

    }

    private JPanel setMenu(){
        JPanel box = new JPanel();
        box.setLayout(new GridLayout(5,1));
        box.setPreferredSize(new Dimension(500, 80));

        box.add(setEstoqueButton());
        box.add(setInserirProdutosButton());
        box.add(editar_produtosButton);
        box.add(historicoButton);
        box.add(setSair());
        return box;
    }
    private JButton setEstoqueButton(){
        
        estoqueButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    System.out.println("Action");
                    JPanel box2 = new ProdutosScreen().getScreen();
                    home.getContentPane().add(box2, BorderLayout.CENTER);
                    home.revalidate();
                    home.repaint();

                }catch(Exception SQLException){
                    System.out.println("Error");
                    return;
                }
            }
        });
        
        return estoqueButton;
    }

    private JButton setInserirProdutosButton(){

        inserir_produtosButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Action");
                JPanel box2 = new InserirProdutosScreen().getScreen();
                home.getContentPane().add(box2, BorderLayout.CENTER);
                home.revalidate();
                home.repaint();
            }
        });

        return inserir_produtosButton;
    }

    private JButton setSair(){
        sairButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            };
        });
        return sairButton;
    }
    

}