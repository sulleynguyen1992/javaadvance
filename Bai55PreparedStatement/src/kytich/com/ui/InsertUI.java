package kytich.com.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Driver;


public class InsertUI extends JFrame {
	
	JTextField txtCode, txtName, txtDate, txtYearUse, txtPrice;
	
	JButton btnSave;
	
	Connection conn=null;
	
	public InsertUI(String title) {
		super(title);
		addControls();
		addEvents();
		connectDatabase();
		
	}
	
	private void addEvents() {
		// TODO Auto-generated method stub
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				processSave();
			}
		});
		
	}

	protected void processSave() {
		// TODO Auto-generated method stub
		try{
			String sql = "insert into TaiSan values(?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, txtCode.getText());
			preparedStatement.setString(2, txtName.getText());
			preparedStatement.setString(3, txtDate.getText());
			preparedStatement.setInt(4, Integer.parseInt(txtYearUse.getText()));
			preparedStatement.setInt(5, Integer.parseInt(txtPrice .getText()));
			int x = preparedStatement.executeUpdate();
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Add item successfully");
				txtCode.setText("");
				txtName.setText("");
				txtPrice.setText("");
				txtYearUse.setText("");
				txtDate.setText("");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JPanel pnCode = new JPanel();
		pnCode.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblCode = new JLabel("Code: ");
		txtCode = new JTextField(20);
		pnCode.add(lblCode);
		pnCode.add(txtCode);
		container.add(pnCode);
		
		JPanel pnName = new JPanel();
		pnName.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblName = new JLabel("Name: ");
		txtName = new JTextField(20);
		pnName.add(lblName);
		pnName.add(txtName);
		container.add(pnName);
		
		JPanel pnDate = new JPanel();
		pnDate.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDate = new JLabel("Date: ");
		txtDate = new JTextField(20);
		pnDate.add(lblDate);
		pnDate.add(txtDate);
		container.add(pnDate);
		
		JPanel pnYearUse = new JPanel();
		pnYearUse.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblYear = new JLabel("Year Use: ");
		txtYearUse = new JTextField(20);
		pnYearUse.add(lblYear);
		pnYearUse.add(txtYearUse);
		container.add(pnYearUse);
		
		JPanel pnPrice = new JPanel();
		pnPrice.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrice = new JLabel("Price: ");
		txtPrice = new JTextField(20);
		pnPrice.add(lblPrice);
		pnPrice.add(txtPrice);
		container.add(pnPrice);
		
		JPanel pnButton = new JPanel();
		btnSave = new JButton("Save");
		pnButton.add(btnSave);
		
		container.add(pnButton);
		
		lblCode.setPreferredSize(lblYear.getPreferredSize());
		lblName.setPreferredSize(lblYear.getPreferredSize());
		lblPrice.setPreferredSize(lblYear.getPreferredSize());
		lblDate.setPreferredSize(lblYear.getPreferredSize());
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

	public void showWindows() {
		this.setSize(400,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
