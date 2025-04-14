package statistics;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;


public class Main{

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createFrame();
			}
		});
		
		for(Functions f : Functions.values()) {
			System.out.println(f);
		}

	}
	
	public static void createFrame() {
		Panel p = new Panel();
		p.setPreferredSize(new Dimension(1200, 1000));//fill the w and h attributes of the actual panel object
		JFrame f = new JFrame();
		f.add(p);		
		f.setResizable(false);
		f.setTitle("Graph");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		
		//a.setVisible(true);
		


		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setBackground(new Color(255, 255, 255));
		InputWindow a = new InputWindow("Text");
		

	}

}
