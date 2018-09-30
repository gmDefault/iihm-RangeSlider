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
		
		
		JPanel j1 = new JPanel();
		JLabel l1 = new JLabel("Prix");
		
		JPanel j2 = new JPanel();
		JLabel l2 = new JLabel("Piece");
		
		
		JFrame J = new JFrame();
		J.setVisible(true);
		
		RangeSlider s = new RangeSlider(0, 10, 4,3);
		J.setSize(200, 200);
		
		RangeSlider s2 = new RangeSlider(2, 20, 4,3);
		J.setSize(200, 200);
		
		RangeSliderUI js = new RangeSliderUI(s);
		s.setUI(js);

		RangeSliderUI js2 = new RangeSliderUI(s2);

//		JSlider js = new JSlider();
		s2.setUI(js2);
		
		
		j1.add(l1);
		j1.add(s,BorderLayout.PAGE_END);
		
		
		j2.add(l2);
		j2.add(s2,BorderLayout.PAGE_END);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                j1, j2);
		
		
		J.add(splitPane);

	}
	
}
