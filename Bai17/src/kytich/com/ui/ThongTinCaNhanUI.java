/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class ThongTinCaNhanUI extends JFrame {

    JTextField txtName;
    JTextArea txtAddress;
    JButton btnOk;
    public ThongTinCaNhanUI(String title) {
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
        JLabel lblName = new JLabel("Nhap ten: ");
        txtName = new JTextField(20);
        pnName.add(lblName);
        pnName.add(txtName);
        pnInfo.add(pnName);

        JPanel pnAddress = new JPanel();
        pnAddress.setLayout(new FlowLayout());
        JLabel lblAddress = new JLabel("Dia chi: ");
        
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
        TitledBorder titledBorderInfo = new TitledBorder(borderInfo, "Thong tin:");
        pnInfo.setBorder(titledBorderInfo);
        titledBorderInfo.setTitleColor(Color.RED);
        titledBorderInfo.setTitleJustification(TitledBorder.LEFT);
        JPanel pnOk = new JPanel();
        pnOk.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnOk = new JButton("Dong y");
        pnOk.add(btnOk);
        panelMain.add(pnOk);
        
        lblAddress.setPreferredSize(lblName.getPreferredSize());
        
        //Phan tao jcheckbox
        JPanel pnExtraInfo = new JPanel();
        
        
    }

    private void addEvents() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Xin chao");
            }
        });

    }

}
