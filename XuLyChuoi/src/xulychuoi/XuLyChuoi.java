/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xulychuoi;

/**
 *
 * @author sulleynguyen
 */
public class XuLyChuoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String name = "  Nguyen    Trac  Thang    ";
        System.out.println(name);
        name = name.trim();
        System.out.println("name: " + name);
        String[] arr = name.split(" ");
        String goodName = "";
        for (String word : arr) {
            if (word.trim().length()!= 0) {
                goodName += word + " ";
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        goodName = goodName.trim();
        System.out.println("name 3: " + goodName);

    }

}
