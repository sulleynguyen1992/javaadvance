package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class HocJSplitPanelUI extends JFrame {
	public HocJSplitPanelUI(String title) {
		super(title);
		addCotrols();
		addEvents();
	}

	public void showWindows() {
		// TODO Auto-generated method stub
		this.setSize(new Dimension(400, 300));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public void addEvents() {
		
	}

	private void addCotrols() {
		// TODO Auto-generated method stub
		Container container = getContentPane();
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(200, 0));
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		splitPane.setOneTouchExpandable(true );
		container.add(splitPane);
		
		//split man hinh ben phai theo chieu doc
		JPanel pnRighUp = new JPanel();
		JPanel pnRightDown = new JPanel();
		JSplitPane righSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pnRighUp,pnRightDown);
		righSplitPane.setOneTouchExpandable(true);
		pnRightDown.setPreferredSize(new Dimension(0, 200));
		pnRight.add(righSplitPane);
		pnRight.add(righSplitPane,BorderLayout.CENTER);
		
	}
}
