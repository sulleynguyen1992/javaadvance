/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.EventListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sulleynguyen
 */
public class PhuongTrinhBac1UI extends JFrame {

    JTextField txtHeSoA;
    JTextField txtHeSoB;
    JButton btnGiai;
    JButton btnThoat;
    JButton btnHelp;
    JTextField txtKetQua;

    ActionListener eventGiai = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            xuLyGiaiPhuongTrinh();
        }
    };

    public PhuongTrinhBac1UI(String title) {
        super(title);
        addControls();
        addEvents();
    }

    private void addControls() {
        Container container = getContentPane();
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        container.add(panelMain);

        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Giai phuong trinh bac 1");
        lblTitle.setForeground(Color.BLUE);
        Font fontTitle = new Font("arial", Font.BOLD, 20);
        lblTitle.setFont(fontTitle);
        pnTitle.add(lblTitle);
        panelMain.add(pnTitle);

        JPanel pnHeSoA = new JPanel();
        pnHeSoA.setLayout(new FlowLayout());
        JLabel lblHeSoA = new JLabel("He so a:");
        txtHeSoA = new JTextField(15);
        pnHeSoA.add(lblHeSoA);
        pnHeSoA.add(txtHeSoA);
        panelMain.add(pnHeSoA);

        JPanel pnHeSoB = new JPanel();
        pnHeSoB.setLayout(new FlowLayout());
        JLabel lblHeSoB = new JLabel("He so b:");
        txtHeSoB = new JTextField(15);
        pnHeSoB.add(lblHeSoB);
        pnHeSoB.add(txtHeSoB);
        panelMain.add(pnHeSoB);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout());
        btnGiai = new JButton("Giai");
        btnThoat = new JButton("Thoat");
        btnHelp = new JButton("Help");
        //btnThoat.setIcon(new ImageIcon("icon/exit.png"));
        ImageIcon imageIcon = new ImageIcon("icon/exit.png");
        Image image = imageIcon.getImage(); //transform it
        Image newImg = image.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);
        btnThoat.setIcon(imageIcon);
        pnButton.add(btnGiai);
        pnButton.add(btnThoat);
        pnButton.add(btnHelp);
        panelMain.add(pnButton);

        JPanel pnKetQua = new JPanel();
        pnKetQua.setLayout(new FlowLayout());
        JLabel lblKetQua = new JLabel("Ket qua");
        txtKetQua = new JTextField(15);
        txtKetQua.setEditable(false);
        pnKetQua.add(lblKetQua);
        pnKetQua.add(txtKetQua);
        panelMain.add(pnKetQua);

    }

    public void addEvents() {
        //loai inline anynomous listener
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //loai listener variable
        btnGiai.addActionListener(eventGiai);
        btnHelp.addActionListener(new HelpEvent());
    }

    protected void xuLyGiaiPhuongTrinh() {
        String heSoA = txtHeSoA.getText();
        String heSoB = txtHeSoB.getText();

        try {
            double a = Double.parseDouble(heSoA);
            double b = Double.parseDouble(heSoB);

            if (txtHeSoA.getText().trim().isEmpty() && txtHeSoB.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ban can nhap he so a va b");
            } else {

                if (a == 0 && b == 0) {
                    //gan gia tri len jtextField
                    txtKetQua.setText("Vo so nghiem");
                } else if (a == 0 && b != 0) {
                    txtKetQua.setText("Vo nghiem");
                } else {
                    double x = -b / a;
                    txtKetQua.setText("x=" + x);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ban can nhap so");
        }
    }

    class HelpEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Chi tiet xin lien he thangnt@hocmai.vn");
        }

    }

    public void showWindows() {
        this.setSize(400, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
