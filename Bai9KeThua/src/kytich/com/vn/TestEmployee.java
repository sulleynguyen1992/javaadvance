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
public class TestEmployee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Employee teo = new OfficalEmployee();
        teo.setName("Nguyen Van Teo");
        System.out.println(teo);
        
        Employee ty = new OfficalEmployee();
        ty.setName("Ly Quoc Ty");
        System.out.println(ty);
        
        Employee tun = new HourEmployee();
        tun.setName("Tran Thi Tun");
        System.out.println(tun);
        
        teo = new HourEmployee();
        teo.setName("Nguyen Van Teo");
        System.out.println(teo);
    }
    
}
