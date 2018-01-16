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
public class OfficalEmployee extends Employee{

    @Override
    public int exportSalary() {
        return 1000;
    }

    @Override
    public String toString() {
        return super.toString() + "$ cause that offical employee"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
