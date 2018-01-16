/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xulychuoi;

import java.util.Arrays;

/**
 *
 * @author sulleynguyen
 */
public class Mang1Chieu {
    public static void main(String[] args) {
        int[] M = new int[4];
        M[0] =9;
        M[1] =3;
        M[2] = 1;
        M[3] = 0;
        
        System.out.println("your array: " );
        for (int i = 0; i < M.length; i++) {
            System.out.print(M[i] + "\t");
        }
        Arrays.sort(M);
        System.out.println("Ater Sort Array: ");
        for (int i = 0; i < M.length; i++) {
            System.out.print(M[i] + "\t");
        }
        System.out.println("Cac so nguyen to: ");
        for (int i = 0; i < M.length; i++) {
            int dem = 0;
            for (int j = 1; j <= M[i]; j++) {
                if(M[i]%j==0)
                {
                    dem++;
                }
            }
            if(dem==2){
                System.out.println(M[i] + "\t");
            }
        }
        System.out.println("0%1=" + (0%1));
    }
}
