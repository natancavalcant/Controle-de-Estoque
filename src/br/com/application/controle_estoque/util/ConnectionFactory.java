/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controle_estoque.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author natan
 */
public class ConnectionFactory {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/controle_estoque";
    private static final String USER = "postgres";
    private static final String PASSWORD= "admin";
    
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            System.out.println("Error: "+ e);
            return null;
        }
    }
    
}
