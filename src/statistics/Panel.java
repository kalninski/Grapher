package statistics;

import java.awt.*;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.geom.*;
import java.util.*;
import javax.imageio.ImageIO;
import  javax.swing.*;

import statistics.Panel;

import java.awt.event.*;
import java.awt.event.InputEvent;

import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;

public class Panel extends JPanel implements MouseWheelListener,KeyListener, MouseListener,MouseMotionListener, Runnable{
	public static String sep = File.separator;
	

	public static ArrayList<Function> listOfFunctions = new ArrayList<Function>();

	public static boolean repaintAfterInputOfNewFunction = false;
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 1200;
	public static double scaler = 1;
	public static double dX;
	public boolean isLooping = true;
	private boolean saveGraph = false;
	public ScreenShot screenShot = new ScreenShot();
	public BufferedImage img;
	public BufferedImage img1;
	public Graphics2D g2d;
	public Graphics2D g2d1;
	public Graphics2D g2d2;
	public static String folder = "C:" + sep + "Users" + sep + "Toms" + sep + "Desktop" + sep + "ImageEXPERIMENTS";//Default location, but should be set to desktop or something
	public String defaultFileName;
	public String extention;
	public Grid grid;
	
	
	
	public Panel() {
		addMouseWheelListener(this);
		this.setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
//		Function cos = new Cosine(5, 1);
//		cos.setAppear(false);
//		Function gauss = new GaussDistribution(1, 0);
//		Function gauss1 = new GaussDistribution(0.5, 2);
		grid = new Grid();
//		Function s = new Sine(5,1);
//		gauss.createValues();
//		Function c = new Cosine(1,1);
//		s.setAppear(false);
//		c.createValues();
		Thread t = new Thread(this);
		t.start();
	}



	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		img = new BufferedImage(1200, 1000, BufferedImage.TYPE_INT_ARGB);
		img1 = new BufferedImage(1200, 1000, BufferedImage.TYPE_INT_ARGB);
		g2d1 = img.createGraphics();
		g2d = (Graphics2D) g;
		
		Rectangle2D.Double back = new Rectangle2D.Double(0, 0, 1200 , 1000);
		g2d.setColor(new Color(255, 255, 255));
		g2d.fill(back);

		dX = 100;
		
		
		if(scaler == 1) {
			dX = 100;
		}
		dX = (int) (dX * (scaler));
		
		grid.drawGridOnScreen(dX, g2d);
		grid.drawGridOnImage(dX, img, g2d1);
		grid.drawAxisOnScreen(g2d, saveGraph, 150, 150, 150);
		grid.drawAxisOnImage(img, g2d1, saveGraph, HEIGHT, WIDTH, HEIGHT);
		recalculateAllValues();
		

		g2d1.dispose();
		
		g2d.dispose();
		
	}
	
	
	//SET THE SCROLL COEFFICIENT TO SOME VARIABLE TO BE ABLE TO CHANGE IT IN THE INTERFACE
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
//		repaint();
		double scroll = e.getPreciseWheelRotation();

		scaler += 5 * scroll / 100;
		if(scaler <= 0) {
			scaler = 1;
		}
//		System.out.println("dX * scaler = " + (scaler * dX) + " = " + scaler + " * " + dX);
		repaint();
		
	}

//	@Override
//	public void run() {
//		long lastTime = System.nanoTime();
//		double dt = 0;
//		double ns = 1000000000/60;
//		System.out.println("running called");
//		while(true) {
//
//			long now = System.nanoTime();
//			dt += (now - lastTime) / ns;
//			lastTime = now;
//			if(repaintAfterInputOfNewFunction) {
//				repaint();
//				repaintAfterInputOfNewFunction = false;
//			}
//			if(dt >= 1 && isLooping) {
//				System.out.println(dt);
//	//			repaint();
//				dt--;
//
//			}
//		}
//	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double dt = 0;
		double ns = 1000000000/60;
		System.out.println("running called");
		while(true) {

			long now = System.nanoTime();
			dt += (now - lastTime) / ns;
			lastTime = now;
			if(repaintAfterInputOfNewFunction) {
				repaint();
				System.out.println("repaint after entering function");
				repaintAfterInputOfNewFunction = false;
				
				
			}
			if(dt >= 1 && isLooping) {
				System.out.println(dt);
				
	//			repaint();
				dt--;

			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_S) {
			saveGraph=true;
			isLooping = false;
//			grid.drawAxisOnImage(img, g2d1, saveGraph, HEIGHT, WIDTH, HEIGHT);
			saveCurrentGraph(folder, "SINE_GRAPH02.05.25", ".png");
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {

		}
		if(e.getKeyCode() == KeyEvent.VK_V) {
			saveVectorOfFunction();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_S) {
			isLooping = true;
			saveGraph=false;
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {

		}
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		int button = e.getButton();
		System.out.println();
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int button = e.getButton();
	//	System.out.println("pressed at "  + e.getX() + ", " + e.getY());
	//	screenShot.setNewStartCorner(e.getX(), e.getY());
		


		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
	//	System.out.println("released at" + e.getX() + ", " + e.getY());
	//	screenShot.setNewEndCorner(e.getX(), e.getY());
		
		

	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//PUT THE METHOD INSIDE THE PAINT METHOD AND RURN METHOD LOOOP FOR LESS RENDER DELAYS
	public void recalculateAllValues() {
		for(Function f: this.listOfFunctions) {
			if(f.isVisable) {
				f.createValues();
				g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
//				System.out.println(listOfFunctions.size());
				g2d.setColor(new Color(50, 100, 150));
				g2d.drawPolyline(f.xC, f.yC, f.xC.length);
				g2d1.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
				g2d1.setColor(new Color(50, 100, 150));
				g2d1.drawPolyline(f.xC, f.yC, f.xC.length);
				System.out.println("y = "+  Arrays.toString(f.yC));
//				System.out.println(f.getClass() + " y = "+  Arrays.toString(f.yC) + Panel.dX);
				System.out.println("x = " + Arrays.toString(f.xC));
				
				g2d1.drawImage(img, null, 0, 0);
				
			}
		}
	}
	
//	public void recalculateAllValues1() {
//		for(Function f: this.listOfFunctions) {
//			if(f.isVisable) {
//				f.createValues();
////				Path2D path = new Path2D.Double();
////				path.moveTo(f.xC[0], f.yC[0]);
////				for(int i = 0; i < Panel.WIDTH; i++) {
////	
////						int nextX = f.xC[i];
////						int nextY = f.yC[i];
////						path.lineTo(nextX, nextY);
////
////						if(f.yC[i] == 0 || f.yC[i] == Panel.HEIGHT){
////						while(f.yC[i] == 0 || f.yC[i] == Panel.HEIGHT) {
////							i++;
////							path.moveTo(i, f.yC[i]);
////						}
////						i--;
////						path.moveTo(i, f.yC[i]);
////				}
////				}
//				g2d.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
//				g2d.setColor(new Color(150, 150, 50));
//				g2d.drawPolyline(f.xC, f.yC, f.xC.length);
//				g2d.drawImage(img, null, 0, 0);
//				g2d1.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
//				g2d1.setColor(new Color(150, 150, 50));
//				g2d1.drawPolyline(f.xC, f.yC, f.xC.length);
//				g2d1.drawImage(img, null, 0, 0);
//				
//			}
//		}
//	}
	
	//CHANGE PARAMETER FOR THE FILE OBJECT CONSTRUCTOR IN THIS METHOD TO --> new File(directoryPath + sep +  fileName + extention)
	//When user inputs the location to save the file to this method receives that as the parameter
	//Set default location if no location has been chosen
	public void saveCurrentGraph(String directoryPath, String fileName, String extention) {
		if(saveGraph) {
			try {
				File path = new File(folder+ sep + fileName + extention);
				ImageIO.write(img, "png", path);
				System.out.println("file "  + fileName + "  \t path " + path.getAbsolutePath());
				
				
				
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void saveVectorOfFunction() {
		StringBuilder svg = new StringBuilder("""
	            <?xml version="1.0" encoding="UTF-8"?>
	            <svg width="2000" height="2000" xmlns="http://www.w3.org/2000/svg">

	            """);
		String polyLine = """
	              <path d=" %s" stroke="black" fill="none" stroke-width="2"/>

				""";
		for(Function f : listOfFunctions) {
			f.coordiantesForSVG();
			String func = String.format(polyLine, f.coordinatesForSVG);
			svg.append(func);
		}
		svg.append("</svg>");
		String svgOut = svg.toString();
		try {
			System.out.println("SVG");
			System.out.println(svg.toString());
			FileWriter w = new FileWriter(folder + sep + "line11.svg");
			w.write(svgOut);
			w.close();

		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}



	
}
