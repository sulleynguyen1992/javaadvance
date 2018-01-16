/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai7;

import java.util.Random;

/**
 *
 * @author sulleynguyen
 */
public class SoNgauNhien {

    public static void main(String[] args) {
        int[] M = new int[10];
        Random rd = new Random();
        for (int i = 0; i < M.length; i++) {
            M[i] = rd.nextInt(100);
        }
        System.out.println("Array random is: ");
        for (int i = 0; i < M.length; i++) {
            System.out.print(M[i] + "\t");
        }
    }
}
