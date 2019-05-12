package de.wuffitv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;

public class Object extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final int CORNERS = 4;
	private Point centerPoint;
	private int radius;
	
	public Object(Point middle, int radius) {
		centerPoint = middle;
		this.radius = radius;
		
//		setBackground(Color.YELLOW);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.err.println("PAINT");
		
		int degreesPerPart = 360/CORNERS;
		int[] listX = new int[CORNERS];
		int[] listY = new int[CORNERS];
		
		for(int i = 0; i < CORNERS; i++) {
			int currentDegree = degreesPerPart * (i);
			
			double x = centerPoint.x + Math.cos(currentDegree) * radius;
			listX[i] = (int)x;
			
			double y = centerPoint.y + Math.sin(currentDegree) * radius;
			listY[i] = (int)y;

//			System.out.println("currentDegree: " + currentDegree + " z: " + listX.get(i));
//			System.out.println(i);
			System.out.println("X: " + (Math.cos(currentDegree) * radius) + " Y: " + (Math.sin(currentDegree) * radius));
			System.out.println("Winkel: " + currentDegree);
			
		}
		System.out.println("===================================");
		
		int h = listX[3];
		
		g.setColor(Color.BLACK);
		g.drawOval((int)(centerPoint.x-0.5*radius), (int)(centerPoint.y-0.5*radius), 10, 10);
		
		g.setColor(Color.GRAY);
		g.drawOval(centerPoint.x+150, centerPoint.y+0, 5, 5);
		g.drawOval(centerPoint.x+79, centerPoint.y+127, 5, 5);
		g.drawOval(centerPoint.x-67, centerPoint.y+134, 5, 5);
		g.drawOval(centerPoint.x-149, centerPoint.y+13, 5, 5);
		g.drawOval(centerPoint.x-89, centerPoint.y-120, 5, 5);
		g.drawOval(centerPoint.x+55, centerPoint.y-139, 5, 5);
		g.drawOval(centerPoint.x+148, centerPoint.y-26, 5, 5);
		g.drawOval(centerPoint.x+100, centerPoint.y+111, 5, 5);
		
		g.setColor(Color.RED);
		g.drawOval((int)(centerPoint.x-0.5*radius), (int)(centerPoint.y-0.5*radius), radius, radius);
		
		Polygon polygon = new Polygon(listX, listY, CORNERS);
		g.setColor(Color.BLUE);
		g.drawPolygon(polygon);
//		g.fillPolygon(polygon);
		
//		g.setColor(Color.RED);
//		g.fillRect(0, 0, 100, 100);
	}
	
}
