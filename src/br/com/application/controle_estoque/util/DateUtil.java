/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.application.controle_estoque.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author natan
 */
public class DateUtil {
    
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    
    public static String dateToString(Date date){
        return formatter.format(date);
    }
    
    public static Date stringToDate(String data){
        try {
            return formatter.parse(data);
        } catch (ParseException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return null;
        }
    }
}
