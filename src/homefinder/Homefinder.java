package homefinder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import slider.fc._RangeSliderListener;
import slider.ui.JRangeSlider;

public class Homefinder {
	private Map map;
	private JRangeSlider rs_room;
	private JRangeSlider rs_price;
	private JFrame frame;

	public static void main(String[] arguments) {

		// Creation and initialization
		Homefinder homefinder = new Homefinder();
		Home.fillHome(100);
		Map map = new Map(450, 450);
		homefinder.rs_room = new JRangeSlider("Number of rooms", 0, 10, 1, 3);
		homefinder.rs_price = new JRangeSlider("Range of price", 30000, 150000, 30000, 120000);
		homefinder.setMap(map);

		JFrame.setDefaultLookAndFeelDecorated(true);
		homefinder.frame = new JFrame("Home Finder - LAFRASSE & TERRIER");
		homefinder.frame.setSize(800, 500);
		homefinder.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());

		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		JLabel Title = new JLabel("Home Finder");
		Title.setFont(new Font("Serif", Font.BOLD, 25));

		jp1.setLayout(new BoxLayout(jp1, BoxLayout.LINE_AXIS));

		jp1.add(Title);

		jp2.setLayout(new BoxLayout(jp2, BoxLayout.LINE_AXIS));

		jp2.add(homefinder.rs_room);

		jp3.setLayout(new BoxLayout(jp3, BoxLayout.LINE_AXIS));

		jp3.add(homefinder.rs_price);

		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));

		jp.add(jp1);
		jp.add(new Box.Filler(new Dimension(5, 100), new Dimension(5, 100), new Dimension(5, 100)));
		jp.add(jp2);
		jp.add(jp3);

		rightPanel.add(jp);

		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, map, rightPanel);
		sp.setDividerLocation(500);
		sp.setMinimumSize(new Dimension(665,475));
		// add JSplitPane to main frame
		homefinder.frame.add(sp);

		homefinder.frame.setVisible(true);

		// Adding a listener to redraw the JFrame if the JRangeSlider (number of rooms)
		// model has changed
		homefinder.rs_room.getRangeSliderUI().getRangeSlider().addRangeSliderListener(new _RangeSliderListener() {

			@Override
			public void MaxChanged(double newmax) {
				homefinder.updateMap(homefinder);
			}

			@Override
			public void MinChanged(double newmax) {
				homefinder.updateMap(homefinder);
			}
		});

		// Adding a listener to redraw the JFrame if the JRangeSlider (price) model has
		// changed
		homefinder.rs_price.getRangeSliderUI().getRangeSlider().addRangeSliderListener(new _RangeSliderListener() {

			@Override
			public void MaxChanged(double newmax) {
				homefinder.updateMap(homefinder);
			}

			@Override
			public void MinChanged(double newmax) {
				homefinder.updateMap(homefinder);
			}
		});
		homefinder.updateMap(homefinder);

	}

	public void setMap(Map m) {
		this.map = m;
	}

	public Map getMap() {
		return this.map;
	}

	/**
	 * Update the homefinder object (update and redraw the map using rangesliders
	 * values)
	 * 
	 * @param homefinder
	 */
	public void updateMap(Homefinder homefinder) {
		homefinder.getMap().setNbPieceMin(homefinder.rs_room.getRangeSlider().getValue());
		homefinder.getMap()
				.setNbPieceMax(homefinder.rs_room.getRangeSlider().getValue() + rs_room.getRangeSlider().getExtent());
		homefinder.getMap().setValeurBienMin(homefinder.rs_price.getRangeSlider().getValue());
		homefinder.getMap().setValeurBienMax(
				homefinder.rs_price.getRangeSlider().getValue() + rs_price.getRangeSlider().getExtent());
		homefinder.frame.repaint();
	}
}
