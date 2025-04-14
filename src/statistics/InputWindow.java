package statistics;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class InputWindow extends JFrame implements WindowListener{
	
	private TextField textField;
	
	public InputWindow(String title) {
		super(title);
		setLayout(new FlowLayout());
		setSize(400, 200);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		addWindowListener(this);
		textField = new TextField(15);
		textField.setText("Sample text");;
		add(textField);
		JButton button = new JButton("ok");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText());
				FunctionMaker maker = new FunctionMaker(textField.getText());
			}
		});
		button.setPreferredSize(new Dimension(50, 35));
		this.add(button);
		

	}
	


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
