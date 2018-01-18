/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.ui;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author sulleynguyen
 */
public class DemoBoxLayoutUI extends JFrame {

    public DemoBoxLayoutUI(String title) {
        super(title);
        addControls();
    }
    public void addControls(){
        Container container = getContentPane();
        JPanel pnBox = new  JPanel();
        pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
        JButton btn1 =new JButton("Demo btn 1");
        JButton btn2 =new JButton("Demo btn 2");
        JButton btn3 =new JButton("Demo btn 3");
        JButton btn4 =new JButton("Demo btn 4");
        
        pnBox.add(btn1);
        pnBox.add(btn2);
        pnBox.add(btn3);
        pnBox.add(btn4);
        
        container.add(pnBox);
               
    }

    public void showWindows() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
