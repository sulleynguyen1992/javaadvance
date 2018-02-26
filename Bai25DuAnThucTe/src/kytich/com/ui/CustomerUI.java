package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import kytich.com.model.Customer;
import kytich.com.model.GroupCustomer;

public class CustomerUI extends JFrame {
	
	DefaultMutableTreeNode root = null;
	JTree treeOfCustomerGroup;
	DefaultTableModel dtm;
	JTable tblCustomer;
	
	JTextField txtCusId, txtCusName, txtCusPhone,txtCusEmail;
	JButton btnSave, btnDelete;
	
	ArrayList<GroupCustomer> listGroupCustomer;
	ArrayList<Customer> listCustomer;
	GroupCustomer groupCustomerSelected;
	
	public CustomerUI(String title) {
		super(title);
		addControls();
		addEvents();
		
		fakeData();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		treeOfCustomerGroup.addMouseListener(new MouseListener() {
			
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
				DefaultMutableTreeNode nodeSelected = (DefaultMutableTreeNode) treeOfCustomerGroup.getLastSelectedPathComponent();
				if(nodeSelected!=null && nodeSelected.getLevel()==1) {
					groupCustomerSelected = (GroupCustomer) nodeSelected.getUserObject();
					showListCustomerOfGroup();
				}
			} 
		});
		
		tblCustomer.addMouseListener(new MouseListener() {
			
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
				int rowSelected = tblCustomer.getSelectedRow();
				if(rowSelected==-1)return;
				String cusId = tblCustomer.getValueAt(rowSelected, 0)+"";
				String cusName = tblCustomer.getValueAt(rowSelected, 1)+"";
				String cusPhone = tblCustomer.getValueAt(rowSelected, 2)+"";
				String cusEmail = tblCustomer.getValueAt(rowSelected, 3)+"";
				
				txtCusId.setText(cusId);
				txtCusName.setText(cusName);
				txtCusEmail.setText(cusEmail);
				txtCusPhone.setText(cusPhone);
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Customer customer = new Customer(txtCusId.getText(),
						txtCusName.getText(),
						txtCusPhone.getText(),
						txtCusEmail.getText());
				groupCustomerSelected.addCustomer(customer);		
//				dtm.fireTableDataChanged();
				showListCustomerOfGroup();
			}
			
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rowSelected = tblCustomer.getSelectedRow();
				if(rowSelected==-1)return;
				dtm.removeRow(rowSelected);
				
			}
		});
	}

	protected void showListCustomerOfGroup() {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		for(Customer customer : groupCustomerSelected.getCustomers()) {
			Vector<String> vec = new Vector<>();
			vec.add(customer.getCustomerId());
			vec.add(customer.getName());
			vec.add(customer.getPhone());
			vec.add(customer.getEmail());
			dtm.addRow(vec);
		}
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container container = getContentPane();		
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(300, 0));
		JPanel pnRight = new JPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		container.setLayout(new BorderLayout());
		container.add(splitPane,BorderLayout.CENTER);
		
		pnRight.setLayout(new BorderLayout());
		JPanel pnTopOfRight = new JPanel();
		pnTopOfRight.setPreferredSize(new Dimension(0, 350));
		JPanel pnBottomOfRight = new JPanel();
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pnTopOfRight,pnBottomOfRight);
		pnRight.add(spRight,BorderLayout.CENTER);
		
		pnLeft.setLayout(new BorderLayout());
		root = new DefaultMutableTreeNode("HOCMAI company");
		treeOfCustomerGroup = new JTree(root);
		JScrollPane scTree = new JScrollPane(treeOfCustomerGroup,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(scTree,BorderLayout.CENTER);
		
		pnTopOfRight.setLayout(new BorderLayout()); 
		dtm=new DefaultTableModel();
		dtm.addColumn("Customer ID");
		dtm.addColumn("Customer Name");
		dtm.addColumn("Phone");
		dtm.addColumn("Email");
		
		tblCustomer = new JTable(dtm);
		JScrollPane scTable = new JScrollPane(tblCustomer,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTopOfRight.add(scTable,BorderLayout.CENTER);
		
		pnBottomOfRight.setLayout(new BoxLayout(pnBottomOfRight, BoxLayout.Y_AXIS));
		JPanel pnCusId = new JPanel();
		pnCusId.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblCusId = new JLabel("Customer ID: ");
		txtCusId = new JTextField(20);
		pnCusId.add(lblCusId);
		pnCusId.add(txtCusId);
		pnBottomOfRight.add(pnCusId);
		
		JPanel pnCusName= new JPanel();
		pnCusName.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblCusName = new JLabel("Customer Name: ");
		txtCusName = new JTextField(20);
		pnCusName.add(lblCusName);
		pnCusName.add(txtCusName);
		pnBottomOfRight.add(pnCusName);
		
		JPanel pnCusPhone= new JPanel();
		pnCusPhone.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblCusPhone = new JLabel("Customer Phone: ");
		txtCusPhone = new JTextField(20);
		pnCusPhone.add(lblCusPhone);
		pnCusPhone.add(txtCusPhone);
		pnBottomOfRight.add(pnCusPhone);
		
		JPanel pnCusEmail= new JPanel();
		pnCusEmail.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblCusEmail = new JLabel("Customer Email: ");
		txtCusEmail = new JTextField(20);
		pnCusEmail.add(lblCusEmail);
		pnCusEmail.add(txtCusEmail);
		pnBottomOfRight.add(pnCusEmail);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnSave = new JButton("Save");
		btnDelete = new JButton("Delete");
		pnButton.add(btnSave);
		pnButton.add(btnDelete);
		pnBottomOfRight.add(pnButton);
		
		lblCusId.setPreferredSize(new Dimension(lblCusName.getPreferredSize()));
		lblCusEmail.setPreferredSize(new Dimension(lblCusName.getPreferredSize()));
	}
	public void showWindow() { 
		this.setSize(800	,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	public void fakeData() {
		listGroupCustomer = new ArrayList<>();
		GroupCustomer vipGroup = new GroupCustomer("G1","Customer VIP ");
		GroupCustomer generalGroup = new GroupCustomer("G2","Customer General ");
		GroupCustomer youngGroup = new GroupCustomer("G3","Customer Young ");
		listGroupCustomer.add(vipGroup);
		listGroupCustomer.add(generalGroup);
		listGroupCustomer.add(youngGroup);
		
		
		//fake customer of groups
		vipGroup.getCustomers().add(new Customer("cus1","Thang Nguyen","012345678","thang@hocmai.vn"));
		vipGroup.getCustomers().add(new Customer("cus2","Thang sulley","9749732421","thang22@hocmai.vn"));
		vipGroup.getCustomers().add(new Customer("cus3","Binh Bong","21324325","binhbong@hocmai.vn"));
		vipGroup.getCustomers().add(new Customer("cus4","Joy Hou","231535","joy@hocmai.vn"));
		vipGroup.addCustomer(new Customer("cus5","Tester","2314214","tester@hocmai.vn"));
		 
		for(GroupCustomer groupCustomer : listGroupCustomer) {
			DefaultMutableTreeNode nodeCustomerGroup = new DefaultMutableTreeNode(groupCustomer);
			root.add(nodeCustomerGroup);
			for(Customer cus : groupCustomer.getCustomers()) {
				DefaultMutableTreeNode nodeCustomer = new DefaultMutableTreeNode(cus);
				nodeCustomerGroup.add(nodeCustomer); 
			}
		}
		treeOfCustomerGroup.expandRow(0);
	}
}
