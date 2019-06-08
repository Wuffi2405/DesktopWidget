package de.wuffitv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Object extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Mittelpunkt des Polygons
	 */
	private Point centerPoint;
	
	/**
	 * Punkt links oben, des umrahmendes Rechtecks
	 */
	private Point startPoint;
	
	/**
	 * Radius des Umkreises
	 * Gleichzeitig die Kantenlänge
	 */
	private int radius;
	
	/**
	 * 
	 */
	Color backgroundColor = new Color(255, 255, 255, 0);
	
	/**
	 * Constructor
	 * @param centerPoint
	 * @param radius
	 */
	public Object(Point centerPoint, int radius) {
		/**
		 * Parameter als Attributen speichern
		 */
		this.radius = radius;
		this.centerPoint = centerPoint;
		
		/**
		 * startPoint berechnen
		 */
		int new_x = centerPoint.x - radius;
		int new_y = centerPoint.y - (int) (Math.round(radius * Math.cos(Math.toRadians(30))));
		this.startPoint = new Point(new_x, new_y);
		
		/**
		 * weitere Eigenschaften für Polygon definieren
		 */
		setBackground(backgroundColor);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.err.println("PAINT");

		/**
		 * erster Versuch
		 * 
		 * von P(0|0) aus
		 */
		int[] x = new int[6];
		int[] y = new int[6];

		int a = radius;
		int b = (int) (Math.round(a * Math.sin(Math.toRadians(30))));
		int c = (int) (Math.round(a * Math.cos(Math.toRadians(30))));

		// int[] x = {50, 150, 200, 150, 50, 0};
		// int[] y = {0, 0, 87, 174, 174, 87};

		// A
		x[0] = startPoint.x + b;
		y[0] = startPoint.y + 0;

		// B
		x[1] = startPoint.x + a + b;
		y[1] = startPoint.y + 0;

		// C
		x[2] = startPoint.x + a + 2 * b;
		y[2] = startPoint.y + c;

		// D
		x[3] = startPoint.x + a + b;
		y[3] = startPoint.y + 2 * c;

		// E
		x[4] = startPoint.x + b;
		y[4] = startPoint.y + 2 * c;

		// E
		x[5] = startPoint.x + 0;
		y[5] = startPoint.y + c;
		
		if(Debug.DEBUG_OBJECT_POINTS) {
			System.out.println("b: " + b);
			System.out.println("c: " + c);

			System.out.println("A: x=" + x[0] + " y=" + y[0]);
			System.out.println("B: x=" + x[1] + " y=" + y[1]);
			System.out.println("C: x=" + x[2] + " y=" + y[2]);
			System.out.println("D: x=" + x[3] + " y=" + y[3]);
			System.out.println("E: x=" + x[4] + " y=" + y[4]);
			System.out.println("F: x=" + x[5] + " y=" + y[5]);
			System.out.println("---");
			System.out.println(Math.round((radius * Math.cos(Math.toRadians(30)))));
			System.out.println("===");
		}

		Polygon polygon = new Polygon(x, y, 6);
		g.setColor(new Color(255, 255, 0, 150));
		g.drawPolygon(polygon);
		g.fillPolygon(polygon);
		
		//Icon
		BufferedImage image = SourceLoader.loadImage("/bild.png");
		g.drawImage(image, centerPoint.x-(radius/2), centerPoint.y-(radius/2), (radius/2)*2, (radius/2)*2, null);
	}

	public Point getCenterPoint() {
		return centerPoint;
	}

	public void setCenterPoint(Point centerPoint) {
		this.centerPoint = centerPoint;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
