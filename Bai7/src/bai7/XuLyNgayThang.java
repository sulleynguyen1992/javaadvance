/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai7;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sulleynguyen
 */
public class XuLyNgayThang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calendar cal =  Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        System.out.println("this year: " + year);
        int month = cal.get(Calendar.MONTH);
        System.out.println("this month: " + (month+1));
        
        Date date =  cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //d = day, M = month, y = year
        System.out.println("To day is: " + dateFormat.format(date)) ;
        
    }
    
}
