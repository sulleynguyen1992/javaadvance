package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HocJTableUI extends JFrame {
	
	DefaultTableModel tableModel;
	JTable tableStudent;
	JButton btnAdd;
	JButton btnDelete;
	
	public HocJTableUI(String title) {
		super(title);
		addControls();
		addEvents();
	}
	private void addControls() {
		// TODO Auto-generated method stub
		Container container = getContentPane();
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(300, 0));
		JPanel pnRight = new JPanel();
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		container.add(jSplitPane);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Name");
		tableModel.addColumn("Address");
		
		//add some row data
		String[] row1 = {"nv1","Tran Van A","Ha Noi"};
		tableModel.addRow(row1);
		String[] row2 = {"nv2","Tran Van B","Ha Noi"};
		tableModel.addRow(row2);
		
		Vector<String> vector3 = new Vector<>();
		vector3.add("sv3");
		vector3.add("Ho Van Do");
		vector3.add("Lao Cai");
		tableModel.addRow(vector3);
		tableStudent = new JTable(tableModel);
		JScrollPane jscrollTable = new JScrollPane(tableStudent,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.setLayout(new BorderLayout());
		pnLeft.add(jscrollTable,BorderLayout.CENTER);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnAdd = new JButton("Add");
		btnDelete = new JButton("Delete");
		pnButton.add(btnAdd);
		pnButton.add(btnDelete);
		pnLeft.add(pnButton,BorderLayout.SOUTH);
		
	}
	public void showWindows() {
		// TODO Auto-generated method stub
		this.setSize(new Dimension(600, 300));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public void addEvents() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<String> vector = new Vector<>();
				vector.add("Ma xyz");
				vector.add("Hello motor");
				vector.add("Dia chi nhe");
				tableModel.addRow(vector);
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tableStudent.getSelectedRow();
				if(row==-1)return;
				
				tableModel.removeRow(row); //xoa dong dang chon
				
			}
		});
		tableStudent.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableStudent.getSelectedRow();
				if(row==-1)return;
				String id =  tableStudent.getValueAt(row, 0) + "";
				String name = tableStudent.getValueAt(row, 1) + "";
				String add = tableStudent.getValueAt(row, 2) + "";
				
				JOptionPane.showMessageDialog(null, "Id: " + id + "\n"
						+ "Name: " + name + "\n"
						+ "Add: " + add);
				
			}
		});
	}

}
