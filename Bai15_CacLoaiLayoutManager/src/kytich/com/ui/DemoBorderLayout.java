/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sulleynguyen
 */
public class DemoBorderLayout extends JFrame {

    public DemoBorderLayout(String title) {
        super(title);
        addControls(); 
    }

    public void addControls() {
        Container container = getContentPane();
        JPanel pnBoderLayout = new JPanel();
        pnBoderLayout.setLayout(new BorderLayout());
        
        JPanel pnNorth = new JPanel();
        pnNorth.setBackground(Color.BLUE);
        pnBoderLayout.add(pnNorth,BorderLayout.NORTH);
        pnNorth.setPreferredSize(new Dimension(0, 100));
        
        JPanel pnSouth = new JPanel();
        pnSouth.setBackground(Color.ORANGE);
        pnBoderLayout.add(pnSouth,BorderLayout.SOUTH);
        
        JPanel pnWest = new JPanel();
        pnWest.setBackground(Color.PINK);
        pnBoderLayout.add(pnWest,BorderLayout.WEST);
        pnWest.setPreferredSize(new Dimension(30, 0));
        
        JPanel pnEast = new JPanel();
        pnEast.setBackground(Color.CYAN);
        pnBoderLayout.add(pnEast,BorderLayout.EAST);
        
        JPanel pnCenter = new JPanel();
        pnCenter.setBackground(Color.GRAY);
        pnBoderLayout.add(pnCenter,BorderLayout.CENTER);
        
        JButton button1 = new JButton("Btn1");
        pnNorth.add(button1);
        
        container.add(pnBoderLayout);
        

    }

    public void showWindows() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
