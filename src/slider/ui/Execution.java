package slider.ui;

import javax.swing.plaf.basic.BasicSliderUI;

import slider.fc.RangeSlider;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;

public class Execution {
	
public static void main(String[] args) {
				
		
		JFrame J = new JFrame();
		J.setVisible(true);
		
		JRangeSlider Jrs = new JRangeSlider("Prix",0, 10, 4,3);
		J.setSize(200, 200);
		
		
		J.add(Jrs);


	}
	
}
