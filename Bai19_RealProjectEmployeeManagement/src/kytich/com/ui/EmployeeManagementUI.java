package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import kytich.com.model.Department;
import kytich.com.model.Employee;

public class EmployeeManagementUI extends JFrame {

	private JComboBox<Department> cbDepartment;
	private JList<Employee> listEmployee;
	private JTextField txtEmployeeId, txtName, txtStartDate, txtDoB;
	private JButton btnSave, btnDelete, btnExit;

	ArrayList<Department> listDepartment;
	ArrayList<Employee> listEmployeeWithDepartment;

	Department departmentSelected = null;
	Employee employeeSelected = null;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public EmployeeManagementUI(String title) {
		super(title);
		addControls();
		addEvents();
		fakeData();
	}

	public void addControls() {
		// them container bao quanh, tao main panel theo boxlayout Y_AXIS
		Container container = getContentPane();
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		container.add(panelMain);

		// panel 1 thanh phan department, thanh phan flowlayout
		JPanel pnDepartment = new JPanel();
		pnDepartment.setLayout(new FlowLayout());
		JLabel lblDepartmentName = new JLabel("Department: ");
		cbDepartment = new JComboBox<>();
		cbDepartment.setPreferredSize(new Dimension(200, 30));
		pnDepartment.add(lblDepartmentName);
		pnDepartment.add(cbDepartment);
		panelMain.add(pnDepartment);

		// panel 2 thanh phan danh sach thong tin chi tiet nhan vien, grid layout vi bao
		// gom 2 grid la danh sach va tt chi tiet (1 hang, 2 cot)
		JPanel pnListEmployeeAndDetail = new JPanel();
		pnListEmployeeAndDetail.setLayout(new GridLayout(1, 2));
		panelMain.add(pnListEmployeeAndDetail);

		// panel 2.1 danh sach nhan vien, Border layout
		JPanel pnList = new JPanel();
		pnList.setLayout(new BorderLayout());
		Border borderList = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderList = new TitledBorder(borderList, "Employee List");
		titleBorderList.setTitleJustification(TitledBorder.LEFT);
		pnList.setBorder(titleBorderList);

		listEmployee = new JList<>();
		JScrollPane scrollPane = new JScrollPane(listEmployee, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnList.add(scrollPane, BorderLayout.CENTER);
		pnListEmployeeAndDetail.add(pnList);

		// panel 2.2 chi tiet nhan vien, boxlayout y_Axis
		JPanel pnDetail = new JPanel();
		pnDetail.setLayout(new BoxLayout(pnDetail, BoxLayout.Y_AXIS));
		pnListEmployeeAndDetail.add(pnDetail);
		Border borderEmpDetail = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderEmpDetail = new TitledBorder(borderEmpDetail, "Employee Information");
		titleBorderEmpDetail.setTitleJustification(TitledBorder.LEFT);
		pnDetail.setBorder(titleBorderEmpDetail);

		// 2.2.1 panel EmployeeId
		JPanel pnEmployeeId = new JPanel();
		pnEmployeeId.setLayout(new FlowLayout());
		JLabel lblEmployeeId = new JLabel("Employee Id: ");
		txtEmployeeId = new JTextField(15);
		pnEmployeeId.add(lblEmployeeId);
		pnEmployeeId.add(txtEmployeeId);
		pnDetail.add(pnEmployeeId);

		// 2.2.2 panel Name
		JPanel pnName = new JPanel();
		pnName.setLayout(new FlowLayout());
		JLabel lblName = new JLabel("Name: ");
		txtName = new JTextField(15);
		pnName.add(lblName);
		pnName.add(txtName);
		pnDetail.add(pnName);

		// 2.2.3 panel startDate
		JPanel pnStartDate = new JPanel();
		pnStartDate.setLayout(new FlowLayout());
		JLabel lblStartDate = new JLabel("Start Date");
		txtStartDate = new JTextField(15);
		pnStartDate.add(lblStartDate);
		pnStartDate.add(txtStartDate);
		pnDetail.add(pnStartDate);

		// 2.2.4 panel Date of birth
		JPanel pnDoB = new JPanel();
		pnDoB.setLayout(new FlowLayout());
		JLabel lblDob = new JLabel("Date of Birth");
		txtDoB = new JTextField(15);
		pnDoB.add(lblDob);
		pnDoB.add(txtDoB);
		pnDetail.add(pnDoB);

		// 3 panel Buttons
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		Border borderButton = BorderFactory.createLineBorder(Color.RED);
		pnButton.setBorder(borderButton);

		btnSave = new JButton("Save");
		btnDelete = new JButton("Delete");
		btnExit = new JButton("Exit");

		pnButton.add(btnSave);
		pnButton.add(btnDelete);
		pnButton.add(btnExit);
		panelMain.add(pnButton);

		lblDob.setPreferredSize(lblEmployeeId.getPreferredSize());
		lblName.setPreferredSize(lblEmployeeId.getPreferredSize());
		lblStartDate.setPreferredSize(lblEmployeeId.getPreferredSize());

	}

	public void fakeData() {
		listDepartment = new ArrayList<>();
		Department techDepartment = new Department();
		techDepartment.setDepartmentName("Technology Department");
		techDepartment.setDepartmentId("1");

		Department eduDepartment = new Department();
		eduDepartment.setDepartmentId("2");
		eduDepartment.setDepartmentName("Education Department");

		Department saleDepartment = new Department();
		saleDepartment.setDepartmentId("3");
		saleDepartment.setDepartmentName("Sale Department");

		listDepartment.add(techDepartment);
		listDepartment.add(eduDepartment);
		listDepartment.add(saleDepartment);

		techDepartment.addEmployee(
				new Employee("1", "Sulley Nguyen", new Date(2016 - 1900, 11, 28), new Date(1992 - 1900, 06, 30)));
		techDepartment.addEmployee(
				new Employee("2", "Kindre Happo", new Date(2012 - 1900, 11, 28), new Date(1995 - 1900, 06, 23)));

		eduDepartment.addEmployee(
				new Employee("3", "Kinzu Nguyen", new Date(2013 - 1900, 11, 28), new Date(1996 - 1900, 06, 30)));
		eduDepartment.addEmployee(
				new Employee("4", "Handu Happo", new Date(2018 - 1900, 11, 28), new Date(1993 - 1900, 06, 23)));

		for (Department department : listDepartment) {
			cbDepartment.addItem(department);
		}

	}

	public void addEvents() {
		cbDepartment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cbDepartment.getSelectedIndex() == -1)
					return;

				departmentSelected = (Department) cbDepartment.getSelectedItem();
				listEmployee.setListData(departmentSelected.getListEmployee());

			}
		});
		listEmployee.addMouseListener(new MouseListener() {

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
				if (listEmployee.getSelectedIndex() == -1)
					return;
				employeeSelected = listEmployee.getSelectedValue();
				txtEmployeeId.setText(employeeSelected.getEmployeeId());
				txtName.setText(employeeSelected.getEmployeeName());

				txtStartDate.setText(simpleDateFormat.format(employeeSelected.getStartDay()));
				txtDoB.setText(simpleDateFormat.format(employeeSelected.getYearBorn()));

			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveData();

			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteData();

			}
		});
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	protected void deleteData() {
		// TODO Auto-generated method stub
		if (employeeSelected != null) {
			departmentSelected.getListEmployee().remove(employeeSelected);
			employeeSelected = null;
			listEmployee.setListData(departmentSelected.getListEmployee());
			clearFields();
		}

	}

	protected void saveData() {
		// TODO Auto-generated method stub
		try {
			Employee employee = new Employee(txtEmployeeId.getText(), txtName.getText(),
					simpleDateFormat.parse(txtStartDate.getText()), simpleDateFormat.parse(txtDoB.getText()));
			if(departmentSelected!=null) {
				departmentSelected.addEmployee(employee);
				listEmployee.setListData(departmentSelected.getListEmployee());
				clearFields();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}

	}

	protected void clearFields() {

		txtEmployeeId.setText("");
		txtDoB.setText("");
		txtStartDate.setText("");
		txtName.setText("");
	}

	public void showWindow() {
		// TODO Auto-generated method stub
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		System.out.println("Application run now");
	}

}
