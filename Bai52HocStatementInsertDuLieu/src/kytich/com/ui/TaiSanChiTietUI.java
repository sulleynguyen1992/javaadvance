package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaiSanChiTietUI extends JDialog {

	private JTextField txtMa, txtTen, txtNgayNhap, txtKhauHao, txtGia;
	private JButton btnSave;

	Connection conn = TaiSanUI.conn;
	Statement statement = TaiSanUI.statement;

	public static int ketqua = -1;

	public String maTaiSanDaChon = "";

	public TaiSanChiTietUI(String title) {
		this.setTitle(title);
		addControls();
		addEvents();

	}

	public void hienThiThongTinChiTiet() {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from TaiSan where Ma='" + maTaiSanDaChon + "'";
			statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				txtMa.setText(resultSet.getString(1));
				txtTen.setText(resultSet.getString(2));
				txtNgayNhap.setText(resultSet.getDate(3) + "");
				txtKhauHao.setText(resultSet.getInt(4) + "");
				txtGia.setText(resultSet.getInt(5) + "");

				txtMa.setEditable(false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMa = new JLabel("Ma tai san");
		txtMa = new JTextField(20);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		container.add(pnMa);

		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTen = new JLabel("Ten");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		container.add(pnTen);

		JPanel pnNgayNhap = new JPanel();
		pnNgayNhap.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNgayNhap = new JLabel("Ngay nhap");
		txtNgayNhap = new JTextField(20);
		pnNgayNhap.add(lblNgayNhap);
		pnNgayNhap.add(txtNgayNhap);
		container.add(pnNgayNhap);

		JPanel pnKhauHao = new JPanel();
		pnKhauHao.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblKhauHao = new JLabel("Khau Hao");
		txtKhauHao = new JTextField(20);
		pnKhauHao.add(lblKhauHao);
		pnKhauHao.add(txtKhauHao);
		container.add(pnKhauHao);

		JPanel pnGia = new JPanel();
		pnGia.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGia = new JLabel("Gia");
		txtGia = new JTextField(20);
		pnGia.add(lblGia);
		pnGia.add(txtGia);
		container.add(pnGia);

		lblTen.setPreferredSize(new Dimension(lblNgayNhap.getPreferredSize()));
		lblMa.setPreferredSize(new Dimension(lblNgayNhap.getPreferredSize()));
		lblKhauHao.setPreferredSize(new Dimension(lblNgayNhap.getPreferredSize()));
		lblGia.setPreferredSize(new Dimension(lblNgayNhap.getPreferredSize()));

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnSave = new JButton("Save me");
		pnButton.add(btnSave);
		container.add(pnButton);

	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLuu();

			}
		});

	}

	protected void xuLyLuu() {
		// TODO Auto-generated method stub
		if (maTaiSanDaChon.length() == 0) {
			try {
				String sql = "insert into TaiSan values('" + txtMa.getText() + "'," + "'" + txtTen.getText() + "',"
						+ "'" + txtNgayNhap.getText() + "'," + "'" + txtKhauHao.getText() + "'," + "'"
						+ txtGia.getText() + "')";
				statement = conn.createStatement();
				int x = statement.executeUpdate(sql);

				ketqua = x;
				dispose(); // an man hinh nay di

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}else {
			try {
				String sql = "update TaiSan set ten='"+txtTen.getText()+"'"
						+ ",NgayNhap='"+txtNgayNhap.getText()+"'"
						+ ",SoNamKhauHao='"+txtKhauHao.getText()+"'"
						+ ",GiaTriBanDau='"+txtGia.getText()+"'"
						+ " where Ma='"+txtMa.getText()+"'";
				
				statement = conn.createStatement();
				int x = statement.executeUpdate(sql);
				ketqua = x;
				dispose(); // an man hinh nay di
				
				
			}catch(Exception ex) {
				ex.printStackTrace();
				
			}
		}

	}

	public void showWindows() {
		this.setSize(450, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}
}
