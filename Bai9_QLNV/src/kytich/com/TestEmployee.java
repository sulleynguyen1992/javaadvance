/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sulleynguyen
 */
public class TestEmployee {
    public static void main(String[] args) {
        ArrayList<Employee> listEmployee = new ArrayList<>();
        listEmployee.add(new Employee(1, "Tung"));
        listEmployee.add(new Employee(2, "An"));
        listEmployee.add(new Employee(3, "Binh"));
        listEmployee.add(new Employee(4, "Vuong"));
        listEmployee.add(new Employee(5, "Nam"));
        listEmployee.add(new Employee(6, "Tung"));
        
        System.out.println("List employee of company: ");
        for(Employee emp : listEmployee){
            System.out.println(emp.getCodeId() + " - " + emp.getName());
        }
        System.out.println("List Employee after sort: ");
        Collections.sort(listEmployee);
        for(Employee emp : listEmployee){
            System.out.println(emp.getCodeId() + " - " + emp.getName());
        }
    }
}
