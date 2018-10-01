package homefinder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

import slider.ui.JRangeSlider;

public class Homefinder {
	private Map map;
	private JRangeSlider rs_room;
	private JRangeSlider rs_price;
	
	public static void main(String[] arguments) {
		Homefinder homefinder = new Homefinder();
				
		Home.fillHome(100);
	    Map map = new Map(450, 450);
	 
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Home Finder - LAFRASSE & TERRIER");
	    frame.setSize(800,500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	    JPanel rightPanel = new JPanel();
	    rightPanel.setLayout(new BorderLayout());
	    
	    homefinder.rs_room = new JRangeSlider("Number of rooms",0,100,25,25);
	    homefinder.rs_price = new JRangeSlider("Range of price",30000,150000,35000,30000);

	    
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		JLabel Title = new JLabel("Home Finder");
		Title.setFont(new Font("Serif", Font.BOLD,25));

		jp1.setLayout(new BoxLayout(jp1, BoxLayout.LINE_AXIS));
		
		jp1.add(Title);
		
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.LINE_AXIS));
		
		jp2.add(homefinder.rs_room);
		
		
		jp3.setLayout(new BoxLayout(jp3, BoxLayout.LINE_AXIS));
		
		jp3.add(homefinder.rs_price);
		
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);

		rightPanel.add(jp);
		
		
	    
	    
	    JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,map,rightPanel);
	    sp.setDividerLocation(500);
	    // add panel to main frame
	    frame.add(sp);
	    
	    frame.setVisible(true);
	 
	  }
	
//	public void updateMap(Homefinder homefinder) {
//		map.setNbPieceMin(homefinder.rs_room.getRangeSlider().getValue());
//		map.setNbPieceMax(homefinder.rs_room.getRangeSlider().getValue() + rs_room.getRangeSlider().getExtent());
//		map.setValeurBienMin(homefinder.rs_price.getRangeSlider().getValue());
//		map.setValeurBienMax(homefinder.rs_price.getRangeSlider().getValue() + rs_price.getRangeSlider().getExtent());
//	}	
}
