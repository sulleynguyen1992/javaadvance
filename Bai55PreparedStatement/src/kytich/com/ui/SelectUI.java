package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;


public class SelectUI extends JFrame {
	
	DefaultTableModel dtmTaiSan;
	JTable tblTaiSan;
	
	Connection conn=null;
	
	public SelectUI(String title) {
		super(title);
		addControls();
		addEvents();
		connectDatabase();
		hienThiDanhSachTaiSan();
		
	}
	public void connectDatabase() {
		try {
		String strConnect = "jdbc:mysql://localhost:8889/dbTaiSan?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", "root");
		pro.put("password", "root"); 
		Driver driver = new Driver();
		conn = driver.connect(strConnect, pro);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private void hienThiDanhSachTaiSan() {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from TaiSan where GiaTriBanDau>?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setInt(1, 1000000);
			dtmTaiSan.setRowCount(0);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				//su dung mang hoac vector
//				Object[] arrTaiSan = {resultSet.getString(1),
//				                      resultSet.getString(2),
//				                      resultSet.getDate(3),
//				                      resultSet.getInt(4),
//				                      resultSet.getInt(5)};
				
				Vector<Object> vec = new Vector<>();
				vec.add(resultSet.getString(1));
				vec.add(resultSet.getString(2));
				vec.add(resultSet.getDate(3));
				vec.add(resultSet.getInt(4));
				vec.add(resultSet.getInt(5));
				dtmTaiSan.addRow(vec);
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		dtmTaiSan = new DefaultTableModel();
		dtmTaiSan.addColumn("Ma");
		dtmTaiSan.addColumn("Ten Tai San");
		dtmTaiSan.addColumn("Ngay nhap");
		dtmTaiSan.addColumn("Khau hao");
		dtmTaiSan.addColumn("Gia tri");
		
		tblTaiSan = new JTable(dtmTaiSan);
		JScrollPane sc = new JScrollPane(tblTaiSan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		container.add(sc,BorderLayout.CENTER);
		
	}
	public void showWindows() {
		this.setSize(400,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
