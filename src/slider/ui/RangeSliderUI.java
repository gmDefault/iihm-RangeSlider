package slider.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicSliderUI;
import slider.fc.RangeSlider;

public class RangeSliderUI extends BasicSliderUI {

	private Rectangle minRectangle;
	private Rectangle maxRectangle;
	private int slider_width = 300;
	private int triangle_width = slider_width / 10;

	public RangeSliderUI(JSlider b) {

		super(b);

		minRectangle = new Rectangle(17,0,10,20);
		maxRectangle = new Rectangle(100,0,10,20);
	}

	@Override
	public void paintThumb(Graphics g) {

		Graphics2D graphics = (Graphics2D) g;
		int[] y;
		int[] x;

		x = new int[] { minRectangle.getLocation().x, minRectangle.getLocation().x,
				(int) (minRectangle.getLocation().x + minRectangle.getWidth()) };

		y = new int[] { minRectangle.getLocation().y, (int) (minRectangle.getLocation().y + minRectangle.getHeight()),
				(int) (minRectangle.getLocation().y + minRectangle.getHeight() / 2) };

		Shape shape = new Polygon(x, y, 3);
		graphics.setColor(Color.GREEN);
		graphics.fill(shape);
		graphics.setColor(Color.GRAY);
		graphics.draw(shape);

		x = new int[] { maxRectangle.getLocation().x, (int) (maxRectangle.getLocation().x + maxRectangle.getWidth()),
				(int) (maxRectangle.getLocation().x + maxRectangle.getWidth()) };

		y = new int[] { (int) (maxRectangle.getLocation().y + maxRectangle.getHeight() / 2),
				maxRectangle.getLocation().y, (int) (maxRectangle.getLocation().y + maxRectangle.getHeight()) };

		shape = new Polygon(x, y, 3);
		graphics.setColor(Color.GREEN);
		graphics.fill(shape);
		graphics.setColor(Color.GRAY);
		graphics.draw(shape);
		

        
	}

	@Override
	public void paint(Graphics g, JComponent c) {

		super.paint(g, c);

		
		// paintThumb pour rectqngle
	}
	
	
//	public void paintTrack(Graphics g) {
//		Rectangle trackBounds = new Rectangle((int) (0),
//				(int) (minRectangle.getLocation().y + minRectangle.getHeight() / 2), (int) maxRectangle.getHeight(), 0);
//		int cy = (trackBounds.height / 2) - 2;
//		int cw = trackBounds.width;
//
//		g.translate(trackBounds.x, trackBounds.y + cy);
//
//		g.setColor(getShadowColor());
//		g.drawLine(0, 0, cw - 1, 0);
//		g.drawLine(0, 1, 0, 2);
//		g.setColor(getHighlightColor());
//		g.drawLine(0, 3, cw, 3);
//		g.drawLine(cw, 0, cw, 3);
//		g.setColor(Color.black);
//		g.drawLine(1, 1, cw - 2, 1);
//
//		g.translate(-trackBounds.x, -(trackBounds.y + cy));
//
//	}

}
