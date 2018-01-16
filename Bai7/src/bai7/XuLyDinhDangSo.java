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
public class XuLyDinhDangSo {

    public static void main(String[] args) {
        double toan = 5;
        double ly = 6;
        double hoa = 9;
        double diem_trung_binh = (toan + ly + hoa) / 3;
        System.out.println("diem trung binh: "  +diem_trung_binh);
        
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        
        System.out.println("Diem trung binh: " + decimalFormat.format(diem_trung_binh));
    }

}
