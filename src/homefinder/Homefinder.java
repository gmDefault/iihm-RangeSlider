package homefinder;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Homefinder {
	
	public static void main(String[] arguments) {
		Home.fillHome(100);
	    Map map = new Map(450, 450);
	 
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("JFrame Color Example");
	    frame.setSize(500,500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	    // add panel to main frame
	    frame.add(map);
	 
	    frame.setVisible(true);
	 
	  }
	
}
