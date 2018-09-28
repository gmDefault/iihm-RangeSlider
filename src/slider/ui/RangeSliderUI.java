package slider.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicSliderUI;

import java.awt.event.*;
import slider.fc.RangeSlider;

public class RangeSliderUI extends BasicSliderUI {

	private Rectangle minRectangle;
	private Rectangle maxRectangle;
	private Rectangle trackRect;
	private int triangle_width;
	private RangeSlider rs; 
	
	private int posXRect1;
	private int posXRect2;

	private Boolean movingRect1 = false;
	private Boolean movingRect2 = false;
	
	public RangeSliderUI(JSlider b) {

		super(b);
		
		rs = (RangeSlider) b;
		

	}

@Override
	protected int xPositionForValue( int value )    {
        int min = rs.getMin();
        int max = rs.getMax();
        float quotient = ((float) tickRect.width * (float) value/ (float) (max-min));
        return (int) quotient;
	    }

	

	
	@Override
	public void paintThumb(Graphics g) {

		Graphics2D graphics = (Graphics2D) g;
		int[] y;
		int[] x;

		posXRect1 = rs.getValue();
		posXRect2 = rs.getValue() + rs.getExtent();
	

		triangle_width = this.tickRect.width / 10;		

		x = new int[] { xPositionForValue(posXRect1), xPositionForValue(posXRect1) ,
				(int) ( xPositionForValue(posXRect1) + 10) };

		y = new int[] { tickRect.y - 20, tickRect.y , tickRect.y - 10  };
		minRectangle = new Rectangle(xPositionForValue(posXRect1),tickRect.y - 20, 10, 20);
		g.fillRect(xPositionForValue(posXRect1),tickRect.y - 20, 10, 20);
//		System.out.println(xPositionForValue(posXRect1) + 10 + " " + tickRect.y);
		Shape shape = new Polygon(x, y, 3);
		graphics.setColor(Color.GREEN);
		graphics.fill(shape);
		graphics.setColor(Color.GRAY);
		graphics.draw(shape);

		x = new int[] { xPositionForValue(posXRect2), xPositionForValue(posXRect2) ,
				(int) ( xPositionForValue(posXRect2) - 10) };

		y = new int[] { tickRect.y - 20, tickRect.y , tickRect.y - 10  };

		g.fillRect(xPositionForValue(posXRect2) - 10 ,tickRect.y - 20, 10, 20);
		shape = new Polygon(x, y, 3);
		graphics.setColor(Color.GREEN);
		graphics.fill(shape);
		graphics.setColor(Color.GRAY);
		graphics.draw(shape);
		
		maxRectangle = new Rectangle(xPositionForValue(posXRect2) - 10 ,tickRect.y - 20, 10, 20);

		
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
	}
	
	@Override
	protected TrackListener createTrackListener(JSlider slider) {
		return new MyTrackListener();
		
	}
	
	private class MyTrackListener extends TrackListener{
		private Point Point_depart;
		
		
		public void mouseDragged(MouseEvent e) {
			
			if(movingRect1) {
				float Value = (float) e.getX()*( (float) rs.getMax()- (float) rs.getMin())/((float) tickRect.width);
				rs.setExtent(rs.getValue() - (int) Value + rs.getExtent()); 
				rs.setValue((int) Value);
				rs.repaint();
			}
			else if (movingRect2 ) {
				float Extent = (float) e.getX()*( (float) rs.getMax()- (float) rs.getMin())/((float) tickRect.width);
				rs.setExtent((int) Extent - rs.getValue() );
				rs.repaint();
			}
		}
		
		public void mousePressed(MouseEvent e) {
//			Click = new Rectangle(e.getX()-2, e.getY()-2, 20, 20);
//			ClickOk = true;
			if(minRectangle.contains(e.getX(), e.getY())) {
				movingRect1 = true;


			}
			else if (maxRectangle.contains(e.getX(), e.getY())) {
				System.out.println(e.getX() + " " + e.getY());

				movingRect2 = true;

			}
		}
		
		public void mouseReleased(MouseEvent e) {
			movingRect1 = false;
			movingRect2 = false;
		}
	}
}
