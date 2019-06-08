package de.wuffitv;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

public class DesktopWidget {
	
	private static Color transparent = new Color(255, 255, 255, 0);
	
	static DesktopWidget desktopWidget;
	private JFrame frame;
	
	public static void main(String[] args) {
		
		desktopWidget = new DesktopWidget();
		desktopWidget.frame.setLayout(null);
		desktopWidget.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktopWidget.frame.setSize(600, 400);
		desktopWidget.frame.setUndecorated(true);		
		desktopWidget.frame.setBackground(transparent);
		
		Object o = new Object(new Point(100, 87), 30);
		o.setBounds(0, 0, 200, 200);
		desktopWidget.frame.add(o);
		
		desktopWidget.frame.setVisible(true);
	}
	
	public DesktopWidget() {
		frame = new JFrame();
//		BufferedImage test = SourceLoader.loadImage("/test.png");
	}
	
}
