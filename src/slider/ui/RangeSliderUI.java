package slider.ui;
import java.awt.Rectangle;

import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;
import slider.fc.RangeSlider;

public class RangeSliderUI extends BasicSliderUI {
	
	private Rectangle minRectangle;
	private Rectangle maxRectangle;
	
	public RangeSliderUI(JSlider b) {
		super(b);
		RangeSlider s = new RangeSlider(0, 9, 2, 3);
		minRectangle = new Rectangle(2,2,10,10);
		
	}
	

}
