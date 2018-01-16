/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai7;

import java.text.DecimalFormat;

/**
 *
 * @author sulleynguyen
 */
public class XuLyToanHoc {
    public static void main(String[] args) {
        int number = 25;
        System.out.println("can bac 2 cua 25 = " + Math.sqrt(number));
        int x = 8;
        int y = 3;
        System.out.println(x + "^" + y + "= " + Math.pow(x, y));
        int k = -113;
        System.out.println("|" + k + "| =" + Math.abs(k) );
        
        int bankinh = 5;
        double chuvi = 2* Math.PI * bankinh;
        double dientich = Math.PI * Math.pow(bankinh, 2);
        
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("chu vi = " + decimalFormat.format(chuvi));
        System.out.println("dien tich = "  + decimalFormat.format(dientich));
        
        System.out.println("xu ly luong giac");
        int goc = 55;
        double radian = Math.PI * goc/180;
        System.out.println("Sin("+goc+")=" + Math.sin(radian));
        System.out.println("Cos("+goc+") = " + Math.cos(radian));
        System.out.println("Tan("+goc+") = " + Math.tan(radian));
        System.out.println("CoTan("+goc+") = " +  Math.cos(radian)/Math.sin(radian));
    }
}
