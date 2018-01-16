/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com;

/**
 *
 * @author sulleynguyen
 */
public class TestMyThread1 {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        thread1.setName("TH1");
        thread1.start(); //kich hoat tien trinh (goi la tieu trinh)
        
        MyThread1 thread2 = new MyThread1();
        thread2.setName("TH2");
        thread2.start();
    }
}
