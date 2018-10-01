package slider.ui;

import java.awt.BorderLayout;


import javax.swing.*;


import slider.fc.RangeSlider;
import slider.fc._RangeSliderListener;

public class JRangeSlider extends JPanel {

	private RangeSlider rs;
	private RangeSliderUI rsUI;
	private JLabel Title;
	private JLabel Min;
	private JLabel Max;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JRangeSlider(String Title, int minValue, int maxValue, int value, int extent) {

		this.rs = new RangeSlider(minValue, maxValue, value, extent);

		rsUI = new RangeSliderUI(rs);

		rs.setUI(rsUI);

		this.Title = new JLabel(Title);

		this.Min = new JLabel("Min :" + value +"   ");

		this.Max = new JLabel("Max :" + (value + extent));

		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();


		setLayout(new BorderLayout());
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.LINE_AXIS));
		
		jp1.add(this.Title);
		
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.LINE_AXIS));
		
		jp2.add(rs);
		
		
		jp3.setLayout(new BoxLayout(jp3, BoxLayout.LINE_AXIS));
		
		jp3.add(this.Min,BorderLayout.LINE_START);
		jp3.add(this.Max,BorderLayout.LINE_END);
		
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);

		add(jp);

		this.rsUI.getRangeSlider().addRangeSliderListener(new _RangeSliderListener() {

			@Override
			public void MaxChanged( double newmax) {
				redraw();
			}

			@Override
			public void MinChanged( double newmax) {
				redraw();
			}



		});

	}
	
	public void redraw() {
		this.Max.setText("Max : "+(rs.getValue()+rs.getExtent()));
		this.Min.setText("Min : "+rs.getValue()+"   ");
	}
	
	public RangeSlider getRangeSlider() {
		return this.rs;
	}
}
