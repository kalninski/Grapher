package statistics;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.*;
import java.awt.image.BufferedImage;
public class Grid {
	
	int color;
	int red;
	int green;
	int blue;
	
	
	public void drawAxisOnScreen(Graphics2D g2d, boolean saveGraph, int red, int green, int blue) {
		
		Path2D.Double pathX = new Path2D.Double();
		Path2D.Double pathY = new Path2D.Double();

		int centerX = (int) Panel.WIDTH / 2;
		int centerY = (int) Panel.HEIGHT / 2;
		pathX.moveTo(centerX, 0);
		pathX.lineTo(centerX, Panel.HEIGHT);
		pathY.moveTo(0, centerY);
		pathY.lineTo(Panel.WIDTH, centerY);
		g2d.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2d.setColor(new Color(150, 150, 150));
		g2d.draw(pathX);
		g2d.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2d.setColor(new Color(150, 150, 150));
		g2d.draw(pathY);
		
	}
	
	public void drawAxisOnImage(BufferedImage img, Graphics2D g2d1, boolean saveGraph, int red, int green, int blue) {
		
		Path2D.Double pathX = new Path2D.Double();
		Path2D.Double pathY = new Path2D.Double();

		int centerX = (int) Panel.WIDTH / 2;
		int centerY = (int) Panel.HEIGHT / 2;
		pathX.moveTo(centerX, 0);
		pathX.lineTo(centerX, Panel.HEIGHT);
		pathY.moveTo(0, centerY);
		pathY.lineTo(Panel.WIDTH, centerY);
		g2d1.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2d1.setColor(new Color(150, 150, 150));
		g2d1.draw(pathX);
		g2d1.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2d1.setColor(new Color(150, 150, 150));
		g2d1.draw(pathY);
		g2d1.drawImage(img, null, 0, 0);
		
	}
	
	public void saveBackground(double dX, Graphics2D g2d1) {
		
	}
	
	public void drawGridOnImage(double dX,BufferedImage img, Graphics2D g2d1) {
		Path2D.Double pathX = new Path2D.Double();
		Path2D.Double pathY = new Path2D.Double();
		
		int centerX = (int) Panel.WIDTH / 2;
		int centerY = (int) Panel.HEIGHT / 2;
		
		int numOfLinesH =(int)(Panel.WIDTH / dX);
		int numOfLinesV = (int) (Panel.HEIGHT/dX);
		double leftDX = -dX;
		double rightDX = dX;
		double lowDY = -dX;
		double upDY = dX;
		
		for(int x = 1 ; x <= numOfLinesH; x ++) {
			pathX.moveTo(centerX + (x * leftDX), 0);
			pathX.lineTo(centerX + (x * leftDX), Panel.HEIGHT);
			pathX.moveTo(centerX + (x * rightDX), 0);
			pathX.lineTo(centerX + (x * rightDX), Panel.HEIGHT);
			g2d1.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			g2d1.setColor(new Color(150, 150, 150));
			g2d1.draw(pathX);
			if(x <= numOfLinesV) {
				pathY.moveTo(0, centerY + (x * lowDY));
				pathY.lineTo(Panel.WIDTH, centerY + (x * lowDY));
				pathY.moveTo(0, centerY + (x * upDY));
				pathY.lineTo(Panel.WIDTH, centerY + (x * upDY));
				g2d1.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
				g2d1.setColor(new Color(150, 150, 150));
				g2d1.draw(pathY);
				g2d1.drawImage(img, null, 0, 0);
			}
		}
	}
	
	public void drawGridOnScreen(double dX, Graphics2D g2d) {
		Path2D.Double pathX = new Path2D.Double();
		Path2D.Double pathY = new Path2D.Double();
		
		int centerX = (int) Panel.WIDTH / 2;
		int centerY = (int) Panel.HEIGHT / 2;
		
		int numOfLinesH =(int)(Panel.WIDTH / dX);
		int numOfLinesV = (int) (Panel.HEIGHT/dX);
		double leftDX = -dX;
		double rightDX = dX;
		double lowDY = -dX;
		double upDY = dX;
		
		for(int x = 1 ; x <= numOfLinesH; x ++) {
			pathX.moveTo(centerX + (x * leftDX), 0);
			pathX.lineTo(centerX + (x * leftDX), Panel.HEIGHT);
			pathX.moveTo(centerX + (x * rightDX), 0);
			pathX.lineTo(centerX + (x * rightDX), Panel.HEIGHT);
			g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			g2d.setColor(new Color(150, 150, 150));
			g2d.draw(pathX);
			if(x <= numOfLinesV) {
				pathY.moveTo(0, centerY + (x * lowDY));
				pathY.lineTo(Panel.WIDTH, centerY + (x * lowDY));
				pathY.moveTo(0, centerY + (x * upDY));
				pathY.lineTo(Panel.WIDTH, centerY + (x * upDY));
				g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
				g2d.setColor(new Color(150, 150, 150));
				g2d.draw(pathY);
			}
		}
	}
	

}
