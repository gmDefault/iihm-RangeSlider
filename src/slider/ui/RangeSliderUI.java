package slider.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JSlider;

import javax.swing.plaf.basic.BasicSliderUI;


import slider.fc.RangeSlider;

public class RangeSliderUI extends BasicSliderUI {

	// hit-box of the left range slider bound 
	private Rectangle minRectangle;
	//hit-box of the right range slider bound
	private Rectangle maxRectangle;
	
	// range slider model
	private RangeSlider rs; 
	
	private int posXRect1;
	private int posXRect2;


	private Boolean movingRect1 = false;
	private Boolean movingRect2 = false;
	private Boolean movingLeft = true;
	
	public RangeSliderUI(JSlider b) {

		super(b);

		rs= (RangeSlider) b;

	}

	@Override
	protected int xPositionForValue( int value )    {
        int min = rs.getMin();
        int max = rs.getMax();
        float quotient = ((float) tickRect.width * ((float) value - (float) min)/ (float) (max-min));
        return (int) quotient;
	    }

	public RangeSlider getRangeSlider() {
		return this.rs;
	}

	
	@Override
	public void paintThumb(Graphics g) {

		Graphics2D graphics = (Graphics2D) g;
		int[] y;
		int[] x;

		posXRect1 = rs.getValue();
		posXRect2 = rs.getValue() + rs.getExtent();
	

		// list of points to create the left green triangle
		x = new int[] { xPositionForValue(posXRect1), xPositionForValue(posXRect1),
				(int) ( xPositionForValue(posXRect1) + 10 ) };

		y = new int[] { tickRect.y - 20, tickRect.y , tickRect.y - 10  };
		
		minRectangle = new Rectangle(xPositionForValue(posXRect1) -10,tickRect.y - 20, 20, 20);
		

		Shape shape = new Polygon(x, y, 3);
		graphics.setColor(Color.GREEN);
		graphics.fill(shape);
		graphics.setColor(Color.GRAY);
		graphics.draw(shape);

		// list of points to create the right green triangle
		x = new int[] { xPositionForValue(posXRect2) + 10, xPositionForValue(posXRect2) + 10 ,
				(int) ( xPositionForValue(posXRect2) ) };

		y = new int[] { tickRect.y - 20, tickRect.y , tickRect.y - 10  };

		shape = new Polygon(x, y, 3);
		graphics.setColor(Color.GREEN);
		graphics.fill(shape);
		graphics.setColor(Color.GRAY);
		graphics.draw(shape);
		
		maxRectangle = new Rectangle(xPositionForValue(posXRect2) ,tickRect.y - 20, 10, 20);

	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		g.drawString("Min : " + rs.getValue() + " Max : " + (rs.getValue() + rs.getExtent()), tickRect.x , tickRect.y + 20);

	}
	
	@Override
    protected TrackListener createTrackListener(JSlider slider) {
        return new MyTrackListener();
    }
	
	private class MyTrackListener extends TrackListener{
	
		public void mouseDragged(MouseEvent e) {
			// if we start dragging from the left triangle
			if(movingRect1) {
				float Value = ((float) e.getX())*( (float) rs.getMax()- (float) rs.getMin())/((float) tickRect.width);
				int ValueCasted = (int) Value + rs.getMin();
				//if we are not hitting a border or the other triangle 
				if( ValueCasted <= rs.getMax() && ValueCasted >= rs.getMin() && ValueCasted <= (rs.getValue() + rs.getExtent() )) {
					rs.setExtent(rs.getValue() - ValueCasted + rs.getExtent()); 
					rs.setValue(ValueCasted );
					rs.repaint();
				}
			}
				// else if we start dragging from the right triangle
			else if (movingRect2 ) {
				float Extent = ((float) e.getX())*( (float) rs.getMax()- (float) rs.getMin())/((float) tickRect.width);
				int ExtentCasted = (int) Extent + rs.getMin();
				//if we are not hitting a border or the other triangle 
				if( ExtentCasted <= rs.getMax() && ExtentCasted >= rs.getMin() && ExtentCasted - rs.getValue()  >= 0 ){
					rs.setExtent(ExtentCasted - rs.getValue() );
					rs.repaint();
				}
			}
		}
		
		public void mousePressed(MouseEvent e) {
		if(rs.getValue() >= ((rs.getMin() + rs.getMax()/2))) {

			if(minRectangle.contains(e.getX(), e.getY())) {
				movingRect1 = true;
			}
			else if (maxRectangle.contains(e.getX(), e.getY())) {
				movingRect2 = true;
			}
		}
		else {
			if (maxRectangle.contains(e.getX(), e.getY())) {
				movingRect2 = true;
			}
			else if(minRectangle.contains(e.getX(), e.getY())) {
				movingRect1 = true;
			}
			}
		}
		
		public void mouseReleased(MouseEvent e ){
			movingRect1 = false;
			movingRect2 = false;
		}

	}


}


