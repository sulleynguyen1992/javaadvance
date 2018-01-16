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
public class HocOverloading {
    
    public static int fn(int x, int y){
        return x+y;
    }
    //overloading khac nhau ve kieu du lieu
    public static double fn(double x, double y){
        return x+y+100;
    }
    public static int fn2(int x, int y, int z){
        return x+y+z;
    }
    //overloading khac nhau ve so luong doi so
    public static int fn2(int x){
        return x;
    }
    //parameter list
    public static int fn3(int ...arr){
        int sum = 0;
        for(int x : arr){
            sum+=x;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(fn(1, 1));
        System.out.println(fn(1.0, 1.0));
        System.out.println(fn2(1));
        System.out.println(fn2(1,2,3));
        System.out.println(fn3(1,2,3,4,5));
        System.out.println(fn3(9,2,3,4,5,2));
    }
}
