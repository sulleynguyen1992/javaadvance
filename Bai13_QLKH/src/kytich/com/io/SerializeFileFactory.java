/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import kytich.com.model.Customer;

/**
 *
 * @author sulleynguyen
 */
public class SerializeFileFactory {

    public static boolean saveFile(ArrayList<Customer> listCustomer, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listCustomer);
            oos.close();
            fos.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Customer> readFile(String path) {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object data = ois.readObject();
            listCustomer = (ArrayList< Customer>) data;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCustomer;
    }
}
