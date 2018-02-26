package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;

public class TaiSanUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel dtm;
	JTable tblTaiSan;
	Connection conn = null;
	Statement statement = null;
	public TaiSanUI(String title) {
		super(title);
		addControls();
		addEvents();
		connectDatabaseMySQL();
		ShowTaiSan();
	}

	private void ShowTaiSan() {
		// TODO Auto-generated method stub	
		try {
			String sql = "select * from TaiSan";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			dtm.setRowCount(0); //xoa sach tale
			while(resultSet.next()) {
				Vector<Object> vec = new Vector<>();
				vec.add(resultSet.getString(1));
				vec.add(resultSet.getString(2));
				vec.add(resultSet.getDate(3));
				vec.add(resultSet.getInt(4));
				vec.add(resultSet.getInt(5));
				dtm.addRow(vec);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void connectDatabaseMySQL() {
		// TODO Auto-generated method stub
		try {
			
			String strConn = "jdbc:mysql://localhost:8889/dbTaiSan";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "root");
			
			Driver driver = new Driver();
			conn = driver.connect(strConn, pro);
			if(conn!=null) {
				System.out.println("ket noi thanh cong");
			}else {
				System.out.println("ket noi that bai");
			}	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel("Chuong trinh quan ly tai san") ;
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitle.setForeground(Color.BLUE);
		pnNorth.add(lblTitle);
		container.add(pnNorth,BorderLayout.NORTH);
		
		dtm = new DefaultTableModel();
		dtm.addColumn("Ma Tai San");
		dtm.addColumn("Ten Tai San");
		dtm.addColumn("Ngay nhap");
		dtm.addColumn("So nam khau hao");
		dtm.addColumn("Tri gia");
		
		tblTaiSan = new JTable(dtm);
		
		JScrollPane sc = new JScrollPane(tblTaiSan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel pnSouth = new JPanel();
		pnSouth.add(sc);
		container.add(pnSouth,BorderLayout.CENTER);
		
		
		
	}
	
	public void showWindows() {
		this.setSize(500,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
