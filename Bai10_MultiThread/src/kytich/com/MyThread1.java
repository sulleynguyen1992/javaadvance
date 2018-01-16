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
public class MyThread1 extends Thread{

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
    }
    
}
