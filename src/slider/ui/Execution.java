package slider.ui;

import javax.swing.plaf.basic.BasicSliderUI;

import slider.fc.RangeSlider;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class Execution {
	
	public static void main(String[] args) {
		JFrame J = new JFrame();
		J.setVisible(true);
		
		RangeSlider s = new RangeSlider(0, 10, 4,4);
		
		RangeSliderUI js = new RangeSliderUI(s);
//		JSlider js = new JSlider();
		s.setUI(js);
		J.add(s);
		J.pack();

	}
	
}
