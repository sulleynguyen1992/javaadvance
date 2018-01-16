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
public class Student {
    private String code;
    private String name;
    private int age;
    private String address;

    public Student() {
        System.out.println("this is default constructor");
        
    }

    public Student(String code, String name, int age, String address) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    
    public void setCode(String code){
        this.code = code;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getAddress(){
        return this.address;
    }

    @Override
    public String toString() {
        return this.code + " - " 
                + this.name + " - "  
                + this.age + " years old - "
                + this.address;
    }
    
}
