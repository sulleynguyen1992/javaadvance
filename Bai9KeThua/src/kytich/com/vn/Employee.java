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
public abstract class Employee {
    private String name;
    private String passport;
    public abstract int exportSalary();

    public Employee() {
        super();
    }

    public Employee(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return this.name + " -> " + exportSalary();
    }
}
