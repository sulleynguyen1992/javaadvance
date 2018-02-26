package kytich.com.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainUI extends JFrame {
	
	JButton btnSelect, btnInsert, btnUpdate, btnDelete;
	public MainUI(String title) {
		super(title);
		addControls();
		addEvents();
		
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelectUI ui = new SelectUI("Man hinh select Prepared Statement");
				ui.showWindows();
			}
		});
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InsertUI ui = new InsertUI("Man hinh insert Prepared Statement");
				ui.showWindows();
				
			}
		});
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container container = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new FlowLayout());
		btnSelect = new JButton("Prepared Statement - Select");
		btnInsert = new JButton("Prepared Statement - Insert");
		btnUpdate = new JButton("Prepared Statement - Update");
		btnDelete = new JButton("Prepared Statement - Delete");
		pnMain.add(btnSelect);
		pnMain.add(btnInsert);
		pnMain.add(btnUpdate);
		pnMain.add(btnDelete);
		
		
		container.add(pnMain);
		
	}
	public void showWindows() {
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
}
