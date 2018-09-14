package slider.ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;
import slider.fc.RangeSlider;

public class RangeSliderUI extends BasicSliderUI {
	
	private Rectangle minRectangle;
	private Rectangle maxRectangle;
	
	public RangeSliderUI(JSlider b) {
		super(b);
		minRectangle = new Rectangle(2,9,100,100);
		
	}
	
	@Override
	public void paint(Graphics g,JComponent c) {
        Rectangle trackBounds = minRectangle;

            int cy = (trackBounds.height / 2) - 2;
            int cw = trackBounds.width;

            g.translate(trackBounds.x, trackBounds.y + cy);

            g.setColor(getShadowColor());
            g.drawLine(0, 0, cw - 1, 0);
            g.drawLine(0, 1, 0, 2);
            g.setColor(getHighlightColor());
            g.drawLine(0, 3, cw, 3);
            g.drawLine(cw, 0, cw, 3);
            g.setColor(Color.black);
            g.drawLine(1, 1, cw-2, 1);

            g.translate(-trackBounds.x, -(trackBounds.y + cy));
	}

}
