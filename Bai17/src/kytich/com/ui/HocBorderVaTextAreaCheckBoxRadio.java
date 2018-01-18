/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


/**
 *
 * @author sulleynguyen
 * Hoc ve border, border title, jTextArea, JScrollPane,
 * JCheckbox, JRadioButton-ButtonGroup
 */
public class HocBorderVaTextAreaCheckBoxRadio extends JFrame {

    JTextField txtName;
    JTextArea txtAddress;
    JButton btnOk;
    
    JCheckBox chkSwim, chkCinema;
    JRadioButton rdMale, rdFemale;
    ButtonGroup groupSex;
    public HocBorderVaTextAreaCheckBoxRadio(String title) {
        super(title);
        addControls();
        addEvents();
    }

    public void showWindows() {
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void addControls() {
        Container container = getContentPane();
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        container.add(panelMain);

        JPanel pnInfo = new JPanel();
        pnInfo.setLayout(new BoxLayout(pnInfo, BoxLayout.Y_AXIS));
        panelMain.add(pnInfo);
        

        JPanel pnName = new JPanel();
        pnName.setLayout(new FlowLayout());
        JLabel lblName = new JLabel("Name: ");
        txtName = new JTextField(20);
        pnName.add(lblName);
        pnName.add(txtName);
        pnInfo.add(pnName);

        JPanel pnAddress = new JPanel();
        pnAddress.setLayout(new FlowLayout());
        JLabel lblAddress = new JLabel("Address: ");
        
        //xuong dong khi tu nhieu hon khung text area
        txtAddress = new JTextArea(5, 19);
        txtAddress.setWrapStyleWord(true);
        txtAddress.setLineWrap(true);
        //-----------------------------
        JScrollPane scrollPane = new JScrollPane(txtAddress,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnAddress.add(lblAddress);
        pnAddress.add(scrollPane);
        pnInfo.add(pnAddress);
        
        Border borderInfo = BorderFactory.createLineBorder(Color.BLUE);
        TitledBorder titledBorderInfo = new TitledBorder(borderInfo, "Information:");
        pnInfo.setBorder(titledBorderInfo);
        titledBorderInfo.setTitleColor(Color.RED);
        titledBorderInfo.setTitleJustification(TitledBorder.LEFT);
        JPanel pnOk = new JPanel();
        pnOk.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //Phan tao so thich va gioi tinh
        JPanel pnExtraInfo = new JPanel();
        //pnExtraInfo.setLayout(new BoxLayout(pnExtraInfo,BoxLayout.X_AXIS));
        pnExtraInfo.setLayout(new GridLayout(1, 2));
                
        JPanel pnHobbit = new JPanel();
        Border borderHobbit = BorderFactory.createLineBorder(Color.GREEN);
        TitledBorder titleBorderHobbit = new TitledBorder(borderHobbit, "Hobbit");
        pnHobbit.setBorder(titleBorderHobbit);
        
        
        pnHobbit.setLayout(new BoxLayout(pnHobbit, BoxLayout.Y_AXIS));
        chkSwim = new JCheckBox("Go to swim");
        chkCinema = new JCheckBox("Go to Cinema");
        pnHobbit.add(chkSwim);
        pnHobbit.add(chkCinema);
        pnExtraInfo.add(pnHobbit);
        
         //panel so thich
        JPanel pnSex = new JPanel();
        Border borderSex = BorderFactory.createLineBorder(Color.ORANGE);
        TitledBorder titleBorderSex = new TitledBorder(borderSex, "Hobbit");
        pnSex.setBorder(titleBorderSex);
        
        pnSex.setLayout(new BoxLayout(pnSex, BoxLayout.Y_AXIS));
        rdMale = new JRadioButton("Male");
        rdFemale = new JRadioButton("Female");
        groupSex = new ButtonGroup();
        groupSex.add(rdMale);
        groupSex.add(rdFemale); 
        pnSex.add(rdMale);
        pnSex.add(rdFemale); 
        pnExtraInfo.add(pnSex);
        
        panelMain.add(pnExtraInfo);
        
        
        btnOk = new JButton("Dong y");
        pnOk.add(btnOk);
        panelMain.add(pnOk);
        
        lblName.setPreferredSize(lblAddress.getPreferredSize());
        
        
        
        
    }

    private void addEvents() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Xin chao");
                //xu ly lay thong tin
                String msg = "Customer name: " + txtName.getText() + "\n";
                msg+= "Address: " + txtAddress.getText() + "\n";
                
                String hobbit = "Hobbit: ";
                if(chkSwim.isSelected()){
                    hobbit+= chkSwim.getText() + " - ";
                }
                if(chkCinema.isSelected()){
                    hobbit+= chkCinema.getText();
                }
                
                String lastWordHobbit = hobbit.substring(hobbit.lastIndexOf(" ")-2);
                System.out.println("Lastword: " + lastWordHobbit);
                if(lastWordHobbit.trim().equals("-")){
                    hobbit = hobbit.substring(0, hobbit.lastIndexOf("-")-1);
                    System.out.println(hobbit);
                }
                msg+=hobbit;
                
                String sex = "Gender: ";
                if(rdMale.isSelected()){
                    sex += rdMale.getText();
                }else
                    sex+=rdFemale.getText();
                msg+= "\n" + sex;
                JOptionPane.showMessageDialog(null, msg);
            }
        });

    }

}
