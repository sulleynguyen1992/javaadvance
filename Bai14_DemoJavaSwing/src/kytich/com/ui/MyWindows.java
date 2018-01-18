/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.ui;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sun.swing.FilePane;

/**
 *
 * @author sulleynguyen
 */
public class MyWindows extends JFrame{
    public MyWindows(String title){
        //super(title);
        this.setTitle(title);
        addControls();
    }
    public void showWindow(){
        this.setSize(500,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    public void addControls(){
        //get class contain Windows
        Container container = getContentPane();
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.red);
        
        JButton button = new JButton("My button! yoho");
        jPanel.add(button);
        //set panel on screen
        container.add(jPanel);
    }
}
