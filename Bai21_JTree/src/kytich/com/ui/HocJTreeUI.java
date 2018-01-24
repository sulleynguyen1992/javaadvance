package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class HocJTreeUI extends JFrame {
	
	DefaultMutableTreeNode root = null;
	JTree tree;
	
	public HocJTreeUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		tree.addMouseListener(new MouseListener() {
			
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
				//chinh la node tren giao dien dc chon
				Object obj = tree.getLastSelectedPathComponent();
				DefaultMutableTreeNode nodeSelected = (DefaultMutableTreeNode)obj;
				JOptionPane.showMessageDialog(null, nodeSelected.getUserObject()+"");
				
			}
		});
		
	}
 
	private void addControls() {
		// TODO Auto-generated method stub
		Container container = getContentPane();
		JPanel pnTree = new JPanel();
		pnTree.setLayout(new BorderLayout());
		root = new DefaultMutableTreeNode("Ky tich");
		tree = new JTree(root);
		
		DefaultMutableTreeNode nodeDepartmentIT = new DefaultMutableTreeNode("IT Department");
		root.add(nodeDepartmentIT);
		DefaultMutableTreeNode nodeEmp1 = new DefaultMutableTreeNode("Nguyen Van A");
		nodeDepartmentIT.add(nodeEmp1);
		DefaultMutableTreeNode nodeEmp2 = new DefaultMutableTreeNode("Nguyen Van B");
		nodeDepartmentIT.add(nodeEmp2);
		

		DefaultMutableTreeNode nodeDepartmentSale = new DefaultMutableTreeNode("Sale  Department");
		root.add(nodeDepartmentSale);
		
		DefaultMutableTreeNode nodeEducation = new DefaultMutableTreeNode("Education  Department");
		root.add(nodeEducation);
		tree.expandRow(0);
		tree.expandRow(1);
		
		//tao ra scrollPane va day tree vao
		JScrollPane scrollPane = new JScrollPane(tree,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTree.add(scrollPane, BorderLayout.CENTER);
		
		container.setLayout(new BorderLayout());
		pnTree.setPreferredSize(new Dimension(300, 0));
		
		JPanel pnRight = new JPanel();
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnTree,pnRight);
		jSplitPane.setOneTouchExpandable(true);
		
		container.add(jSplitPane,BorderLayout.CENTER);
		
		
		
		
		
	}
	public void showWindows() {
		this.setSize(500,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
