package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class HocJMenu extends JFrame {

	JMenuBar menuBar; // noi chua cac menu
	JMenu menuFile;
	JMenu menuEdit;
	JMenu menuHelp;
	JMenuItem menuFileNew;
	JMenuItem menuFileOpen;
	JMenuItem menuFileExit;

	JMenuItem menuEditCopy;
	JMenuItem menuEditPaste;

	JMenuItem menuHelpContact;
	JMenuItem menuHelpUpdate;
	
	JButton btn1;
	JButton btn2;
	JMenuItem menuPopUpGreen, menuPopUpRed;
	JButton btnLastedChoose = null;
	
	JToolBar toolBar;
	JButton btnAction1, btnAction2;
	JCheckBox cbx1, cbx2; 

	public HocJMenu(String title) {
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		menuFileExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		menuFileNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Ban vua go cmd N");
			}
		});
                btnAction1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       JOptionPane.showMessageDialog(null, "Hello Jtollbar called");
                    }
                });

	}

	private void addControls() {
		// TODO Auto-generated method stub
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);

		// menu item cua menu File
		menuFileNew = new JMenuItem("New");
		menuFileNew.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		menuFile.add(menuFileNew);
		menuFileOpen = new JMenuItem("Open");
		menuFile.addSeparator();
		menuFile.add(menuFileOpen);
		menuFile.addSeparator();
		menuFileExit = new JMenuItem("Exit");
		menuFileExit.setIcon(new ImageIcon("img/exit.png"));
		menuFile.add(menuFileExit);

		// menu item cua menu Edit
		menuEditCopy = new JMenuItem("Copy");
		menuEdit.add(menuEditCopy);
		menuEdit.addSeparator();
		menuEditPaste = new JMenuItem("Paste");
		menuEdit.add(menuEditPaste);

		// menu item cua menu help
		menuHelpContact = new JMenuItem("Contact");
		menuHelp.add(menuHelpContact);
		menuHelp.addSeparator();
		menuHelpUpdate = new JMenuItem("Update");
		menuHelp.add(menuHelpUpdate);
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		toolBar = new JToolBar();
		btnAction1 = new JButton("Action 1");
		btnAction2 = new JButton("Action 2");
		toolBar.add(btnAction1);
		toolBar.add(btnAction2);
		cbx1 = new JCheckBox("Auto save data after 10 minute");
		cbx2 = new JCheckBox("Auto shutdown computer when completed");
		container.add(toolBar,BorderLayout.NORTH);
		
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new FlowLayout());
		btn1  = new JButton(" Btn1 CLick me! Please!");
		panelMain.add(btn1);
		btn2  = new JButton(" Btn2 CLick me! Please!");
		panelMain.add(btn2);
		container.add(panelMain,BorderLayout.CENTER);
		
		btn1.addMouseListener(new PopClickListener());
		btn2.addMouseListener(new PopClickListener());
	}
	class PopUpDemo extends JPopupMenu {
		
		public PopUpDemo(){
			menuPopUpRed = new JMenuItem("CLick Me Red!");
			add(menuPopUpRed);
			menuPopUpGreen = new JMenuItem("Draw Green");
			add(menuPopUpGreen);
			
			menuPopUpRed.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					if(btnLastedChoose!=null) {
						btnLastedChoose.setBackground(Color.RED);
						btnLastedChoose.setOpaque(true);
					} 
				}
			});
			menuPopUpGreen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(btnLastedChoose!=null) {
						btnLastedChoose.setBackground(Color.GREEN);
						btnLastedChoose.setOpaque(true);
					}
					
				}
			});
		}
	}
	class PopClickListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.isPopupTrigger())
				doPop(e);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.isPopupTrigger())
				doPop(e);
		}

		private void doPop(MouseEvent e) {
			// TODO Auto-generated method stub
			PopUpDemo menu = new PopUpDemo();
			btnLastedChoose = (JButton) e.getComponent();
			
			menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	public void showWindows() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
