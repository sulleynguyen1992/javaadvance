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
public class TestStudent {
    public static void main(String[] args) {
        Student teo = new Student();
        teo.setCode("Code001");
        teo.setName("Tran Van A");
        teo.setAge(26);
        teo.setAddress("443 pham van dong");
        System.out.println(teo);
        
        Student ty = new Student("Code002", "Tran Thi Ty", 23, "Lao cai");
        System.out.println("Name of student 1: " + teo.getName());
        System.out.println("Name of student 2: " + ty.getName());
        
        teo = ty;
        teo.setName("Angela Baby");
        System.out.println("Name of student 2: " + ty.getName());
    }
}
