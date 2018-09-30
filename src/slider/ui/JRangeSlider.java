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

		rs = new RangeSlider(minValue, maxValue, value, extent);

		rsUI = new RangeSliderUI(rs);

		rs.setUI(rsUI);

		this.Title = new JLabel(Title);

		this.Min = new JLabel("Min :" + value);

		this.Max = new JLabel("Max :" + (value + extent));

		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jpminmax = new JPanel();

		setLayout(new BorderLayout());

		jp.add(this.Title);
		jp2.add(rs);
		jp.add(jp2, BorderLayout.PAGE_END);
		jpminmax.add(this.Min, BorderLayout.EAST);
		jpminmax.add(this.Max, BorderLayout.WEST);
		jp.add(jpminmax);

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
		this.Min.setText("Min : "+rs.getValue());
	}
}
