/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.vn;

/**
 *
 * @author sulleynguyen
 */
public interface DoAble {
    public void fn1();
    public double fn2(double x, double y);
    public abstract void exportInformation();
    
    public static int numberX = 5;
    public final double PI = 3.14;
}
