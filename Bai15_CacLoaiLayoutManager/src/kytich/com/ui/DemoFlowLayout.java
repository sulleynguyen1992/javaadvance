/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sulleynguyen
 */
public class DemoFlowLayout extends JFrame{
    public DemoFlowLayout(String title){
        super(title);
        
        addControls();
    }
    public void addControls(){
        Container container = getContentPane();
        JPanel jPanelFlowLayout = new JPanel();
        jPanelFlowLayout.setLayout(new FlowLayout());
        JButton button1 = new JButton("demo btn 1");
        JButton button2 = new JButton("demo btn 2");
        JButton button3 = new JButton("demo btn 3");
        JButton button4 = new JButton("demo btn 4");
        
        jPanelFlowLayout.add(button1);
        jPanelFlowLayout.add(button2);
        jPanelFlowLayout.add(button3);
        jPanelFlowLayout.add(button4);
        
        container.add(jPanelFlowLayout);
        
    }
    public void showWindows(){
        this.setSize(600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
