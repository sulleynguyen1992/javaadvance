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
public class HourEmployee extends Employee{
    private int hour = 2;
    
    @Override
    public int exportSalary() {
        return (100 * this.hour);
    }

    @Override
    public String toString() {
        return super.toString() + "$ cause that hourly employee"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
