/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.model;

import java.io.Serializable;

/**
 *
 * @author sulleynguyen
 */
public class Customer implements Serializable,Comparable<Customer>{
    private int codeId;
    private String name;
    private String phone;

    public Customer() {
        super();
    }

    public Customer(int codeId, String name, String phone) {
        this.codeId = codeId;
        this.name = name;
        this.phone = phone;
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.codeId + "\t" 
                + this.name 
                + "\t" + this.phone;
    }

    @Override
    public int compareTo(Customer o) {
        return this.phone.compareToIgnoreCase(o.phone);
        
    }
    
    
}
