package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import com.mysql.jdbc.Driver;

public class TaiSanUI extends JFrame {
	
	DefaultTableModel dtmTaiSan;
	JTable tblTaiSan;
	
	public static Connection conn = null;
	public static Statement statement = null;
	
	JButton btnAddItem, btnEdit, btnDelete;
	
	JMenuItem mnuEdit, mnuDelete;
	JPopupMenu popupMenu;
	public TaiSanUI(String title) {
		super(title);
		addControls();
		addEvents();
		connectDatabase();
		showTaiSan();
	}

	private void showTaiSan() {
		// TODO Auto-generated method stub
		try {
		String sqlQuerry = "select * from TaiSan";
		statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sqlQuerry);
		//xoa sach table
		dtmTaiSan.setRowCount(0);
		//trong khi result van con du lieu
		while(result.next()) {
			Vector<Object> vec = new Vector<>();
			vec.add(result.getString(1));
			vec.add(result.getString(2));
			vec.add(result.getDate(3));
			vec.add(result.getInt(4));
			vec.add(result.getInt(5));
			dtmTaiSan.addRow(vec);
			
		}
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}

	private void connectDatabase() {
		// TODO Auto-generated method stub
		try {
		String strConn = "jdbc:mysql://localhost:8889/dbTaiSan?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", "root");
		pro.put("password", "root");
		
		Driver driver = new Driver();
		conn = driver.connect(strConn, pro);
		if(conn!=null) {
			System.out.println("connect success!");
		}else {
			System.out.println("Connect fail");
		}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TaiSanChiTietUI ui = new TaiSanChiTietUI("them tai san");
				ui.showWindows();
				
				if(TaiSanChiTietUI.ketqua>0) {
					showTaiSan();
				}
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tblTaiSan.getSelectedRow();
				if(row==-1)return;
				String maTS = tblTaiSan.getValueAt(row, 0) + "";
				
				TaiSanChiTietUI ui = new TaiSanChiTietUI("sua tai san");
				ui.maTaiSanDaChon = maTS;
				ui.hienThiThongTinChiTiet();
				ui.showWindows();
				
				if(TaiSanChiTietUI.ketqua>0) {
					showTaiSan();
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tblTaiSan.getSelectedRow();
				if(row==-1)return;
				//String maTS = tblTaiSan.getValueAt(row, 0) + "";
				xuLyXoa();
				
			}
		});
		
		tblTaiSan.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.isPopupTrigger()) {
					int row = tblTaiSan.rowAtPoint(e.getPoint());
					int col = tblTaiSan.columnAtPoint(e.getPoint());
					
					//neu row chua duoc chon thi chon 
					if(!tblTaiSan.isRowSelected(row))
						tblTaiSan.changeSelection(row, col, false, false);
					
					
					popupMenu.show(e.getComponent(), e.getX(), e.getY()); 
				} //bam chuot phai phai khong
				
				
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
				
			}
		});
		mnuEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnEdit.doClick();
				
			}
		});
		mnuDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyXoa();
			}
		});
	}

	protected void xuLyXoa() {
		// TODO Auto-generated method stub
		String ma = tblTaiSan.getValueAt(tblTaiSan.getSelectedRow(), 0) + "";
		try {
			String sql = "delete from TaiSan where Ma='"+ma+"'";
			statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			if(x>0)
				showTaiSan();
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel("Danh sach tai san");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitle.setForeground(Color.CYAN);	
		pnNorth.add(lblTitle);
		container.add(pnNorth,BorderLayout.NORTH);
		
		//panel bang danh sach tai san
		JPanel pnSouth = new JPanel();
		
		dtmTaiSan = new DefaultTableModel();
		dtmTaiSan.addColumn("Ma");
		dtmTaiSan.addColumn("Ten tai san");
		dtmTaiSan.addColumn("Ngay nhap");
		dtmTaiSan.addColumn("Khau hao");
		dtmTaiSan.addColumn("gia tri");
		
		tblTaiSan = new JTable(dtmTaiSan);
		JScrollPane scTaiSan = new JScrollPane(tblTaiSan,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnSouth.setLayout(new BorderLayout());
		pnSouth.add(scTaiSan,BorderLayout.CENTER);
		container.add(pnSouth);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		container.add(pnButton,BorderLayout.SOUTH);
		
		btnAddItem = new JButton("Add Item");
		pnButton.add(btnAddItem);
		
		btnEdit = new JButton("Edit Item");
		pnButton.add(btnEdit);
		
		
		btnDelete = new JButton("Delete");
		pnButton.add(btnDelete);
		
		popupMenu = new JPopupMenu();
		mnuEdit = new JMenuItem("Edit");
		mnuDelete = new JMenuItem("Delete");
		popupMenu.add(mnuEdit);
		popupMenu.addSeparator();
		popupMenu.add(mnuDelete);
		
		
		
	}
	public void showWindows() {
		this.setSize(600,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
