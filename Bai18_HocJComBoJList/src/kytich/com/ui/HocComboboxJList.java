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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author sulleynguyen
 */
public class HocComboboxJList extends JFrame {

    JComboBox cbNumber;
    JList listNumber;
    JButton btnOk;

    public HocComboboxJList(String title) {
        super(title);
        addControls();
        addEvents();
    }

    private void addControls() {
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel pnCombo = new JPanel();
        pnCombo.setLayout(new FlowLayout());
        JLabel lblChooseNumber = new JLabel("Choose number: ");
        pnCombo.add(lblChooseNumber);
        cbNumber = new JComboBox();
        Random rd = new Random();
        for (int i = 0; i < 100; i++) {
            int x = rd.nextInt(500);
            cbNumber.addItem(x);
        }
        pnCombo.add(cbNumber);
        container.add(pnCombo);

        JPanel pnList = new JPanel();
        pnList.setLayout(new FlowLayout());
        JLabel lblChooseNumber2 = new JLabel("Choose number: ");
        listNumber = new JList();
        Vector<Integer> vec = new Vector<>();
        for (int i = 0; i < 100; i++) {
            int x = rd.nextInt(500);
            vec.add(x);

        }
        listNumber.setListData(vec);
        pnList.add(lblChooseNumber2);
        JScrollPane scList = new JScrollPane(listNumber, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        pnList.add(scList);
        container.add(pnList);

        JPanel pnOk = new JPanel();
        pnOk.setLayout(new FlowLayout());
        btnOk = new JButton("Ok");
        pnOk.add(btnOk);
        container.add(pnOk);

    }

    private void addEvents() {
        cbNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = cbNumber.getSelectedIndex();
                Object value = cbNumber.getSelectedItem();
                if (pos != -1)//co lua chon
                {
                    JOptionPane.showMessageDialog(null, "position: " + pos
                            + "\n" + "value: " + value.toString());
                }
            }
        });
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processViewDataList();
            }
        });
    }

    private void processViewDataList() {
        Object ob = listNumber.getSelectedValue();
        int pos = listNumber.getSelectedIndex();
        JOptionPane.showMessageDialog(null, "List: position selectd: "
                + pos + "\n" + "Value selected: " + ob);

    }

    public void showWindows() {
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

}
