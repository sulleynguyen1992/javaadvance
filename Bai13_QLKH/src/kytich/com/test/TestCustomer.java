/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import kytich.com.io.SerializeFileFactory;
import kytich.com.model.Customer;

/**
 *
 * @author sulleynguyen
 */
public class TestCustomer {

    static ArrayList<Customer> listCustomer = new ArrayList<>();
    
    public static void menu() {
        System.out.println("1. Enter Customer");
        System.out.println("2. Export Customer");
        System.out.println("3. Find Customer");
        System.out.println("4. Sort Customer");
        System.out.println("5. Save Customer");
        System.out.println("6. Read Customer");
        System.out.println("7. Analystic customer of DC");
        System.out.println("8. Exit");
        int choose = 0;
        System.out.println("Choose functions: ");
        choose = new Scanner(System.in).nextInt();
        switch (choose) {
            case 1:
                inputCustomer();
                break;
            case 2:
                exportCustomer();
                break;
            case 3:                
                findCustomer();
                break;
            case 4:                
                sortCustomer();
                break;
            case 5:
                saveCustomer();
                break;
            case 6:
                readCustomer();
                break;
            case 7:
                analysticPhoneOfCustomer();
                break;
            case 8:
                exitProgram();
                break;
            default:
                break;
        }
        
    }
    
    public static void main(String[] args) {
        while (true) {
            menu();
        }
        
    }
    
    private static void inputCustomer() {
        Customer customer = new Customer();
        System.out.println("Enter the customer id");
        int codeId = new Scanner(System.in).nextInt();
        System.out.println("Enter the customer name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter the phone");
        String phone = new Scanner(System.in).nextLine();
        customer.setCodeId(codeId);
        customer.setName(name);
        customer.setPhone(phone);
        listCustomer.add(customer);
    }
    
    private static void exportCustomer() {
        System.out.println("==============================");
        System.out.println("CodeId\tName\tPhone");
        for(Customer cus : listCustomer){
            System.out.println(cus);
        }
        System.out.println("==============================");
    }
    
    private static void findCustomer() {
        System.out.println("Enter the prefix you want find: ");
        String phone = new Scanner(System.in).nextLine();
        System.out.println("============================");
        System.out.println("Customer have prefix "+phone+"");
        System.out.println("CodeI\tName\tPhone");
        for(Customer cus : listCustomer){
            if(cus.getPhone().startsWith(phone)){
                System.out.println(cus);
            }
        }
        System.out.println("============================");
    }
    
    private static void sortCustomer() {
        Collections.sort(listCustomer);
        System.out.println("Sorted by phone!");
    }
    
    private static void saveCustomer() {
        boolean check = SerializeFileFactory.saveFile(listCustomer, "/Users/sulleynguyen/Desktop/javaadvance/Bai13_QLKH/qlkh.db");
        if(check ==true){
            System.out.println("Save file success!");
        }else{
            System.out.println("Save fail!");
        }
    }
    
    private static void readCustomer() {
        listCustomer = SerializeFileFactory.readFile("/Users/sulleynguyen/Desktop/javaadvance/Bai13_QLKH/qlkh.db");
        System.out.println("Read file success!");
        exportCustomer();
    }
    
    private static void analysticPhoneOfCustomer() {
        int n = 0;
        for (Customer customer : listCustomer) {
            if ((customer.getPhone().startsWith("098")) ||
                    (customer.getPhone().startsWith("097"))) {
                n++;
            }
        }
        System.out.println("have " + n + " Viettel customer");
    }
    
    private static void exitProgram() {
        System.out.println("Bye Bye");
        System.exit(0);
    }
    
}
