package kytich.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class HocJoptionPaneAndFileChooser extends JFrame {
	
	JMenuBar menuBar;
	JMenu menuFile;
	JMenuItem menuFileSave;
	JMenuItem menuFileOpen;
	JMenuItem menuFileExit;
	
	JTextArea txtDataArea;
	JFileChooser chooser;
	public HocJoptionPaneAndFileChooser(String title) {
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
				processExitProgram();
				
			}
		});
		menuFileOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				processOpenFile();
				
			}
		});
		menuFileSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				processSaveFile();
				
			}
		});
		
	}

	protected void processSaveFile() {
		// TODO Auto-generated method stub
		if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
			String data = txtDataArea.getText();
			try {
				FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile());
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				osw.write(data);
				
				osw.close();
				fos.close();
				JOptionPane.showMessageDialog(null, "Save file success!");
				 
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

	protected void processOpenFile() {
		// TODO Auto-generated method stub
		
		
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			File selectedFile =chooser.getSelectedFile();
			
			try {
				FileInputStream fis = new FileInputStream(selectedFile);
				InputStreamReader inputStreamReader = new InputStreamReader(fis);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader );
				String line = bufferedReader.readLine();
				StringBuilder builder = new StringBuilder();
				while(line!=null){
					builder.append(line);
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
				inputStreamReader.close();
				fis.close();
				txtDataArea.setText(builder.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		}
		
	}

	protected void processExitProgram() {
		// TODO Auto-generated method stub
		int choice = JOptionPane.showConfirmDialog(null, "Are you sure quit program?","Conirm Quit",JOptionPane.YES_NO_OPTION);
		if(choice==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

	private void setupMenuBar() {
		// TODO Auto-generated method stub
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuFile = new JMenu("System");
		menuBar.add(menuFile);
		menuFileOpen = new JMenuItem("Open");
		menuFile.add(menuFileOpen);
		menuFile.addSeparator();
		menuFileSave = new JMenuItem("Save");
		menuFile.add(menuFileSave);
		menuFile.addSeparator();
		menuFileExit = new JMenuItem("Exit program");
		menuFile.add(menuFileExit);
	}

	private void addControls() {
		// TODO Auto-generated method stub
		setupMenuBar();
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		txtDataArea = new JTextArea(50,50);
		txtDataArea.setLineWrap(true);
		txtDataArea.setWrapStyleWord(true);
		JScrollPane sc = new JScrollPane(txtDataArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		container.add(sc,BorderLayout.CENTER);
		
		
		//type file choose
		chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Document xml";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".xml");
			}
		});
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Word 2007, 2010, 2013, 2017";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".doc") || f.getAbsolutePath().endsWith(".docx ");
			}
		});
		
		
		
	}
	
	public void showWindow() {
		this.setSize(500,300);;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	
}
