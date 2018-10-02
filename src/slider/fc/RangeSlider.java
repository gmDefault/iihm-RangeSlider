package slider.fc;

import javax.swing.JSlider;
import javax.swing.event.EventListenerList;

public class RangeSlider extends JSlider  implements _RangeSlider{

	//              <---extent--->
	// |-----------[-------------]---|
	// min	     value        max
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// the minimum value of the slider range [min;max]
	private int minValue;
	// the maximum value of the slider range [min;max]
	private int maxValue;
	// the min value of the selected range
	private int value;
	// the width of the selected range
	private int extent;
	
    private final EventListenerList listeners = new EventListenerList();
	
	
	@Override
	public void setMin(int minValue) {
		this.minValue = minValue;
	}

	@Override
	public void setMax(int maxValue) {
		this.maxValue = maxValue;
	}
	
	@Override
	public void setValue(int value) {
		this.value = value;
		for(_RangeSliderListener listener : getRangeSliderListeners()) {
			listener.MinChanged(value);
		}
		for(_RangeSliderListener listener : getRangeSliderListeners()) {
			listener.MaxChanged(value);
		}
	}

	@Override
	public void setExtent(int extent) {
		this.extent = extent;
		for(_RangeSliderListener listener : getRangeSliderListeners()) {
			listener.MaxChanged(value);
		}
		for(_RangeSliderListener listener : getRangeSliderListeners()) {
			listener.MinChanged(value);
		}
	}

	@Override
	public int getMin() {
		return this.minValue;
	}

	@Override
	public int getMax() {
		return this.maxValue;
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public int getExtent() {
		return this.extent;
	}
	
	/**
	 * Constructor of the rangeslider model
	 * 
	 * <---extent---> |-----------[-------------]---| min value max
	 * 
	 * @param minValue the minimum of the range slider
	 * @param maxValue the maximum of the range slider
	 * @param value    the left value of the range slider
	 * @param extent   the width of the selected range
	 */
	public RangeSlider(int minValue, int maxValue, int value, int extent) {
		this.minValue=minValue;
		this.maxValue=maxValue;
		this.value=value;
		this.extent=extent;
	}

	public void addRangeSliderListener(_RangeSliderListener _RangeSliderListener) {
        listeners.add(_RangeSliderListener.class, _RangeSliderListener);
	}
	
	public void removeRangeSliderListener(_RangeSliderListener _RangeSliderListener) {
        listeners.remove(_RangeSliderListener.class, _RangeSliderListener);
	}
	
	public _RangeSliderListener[] getRangeSliderListeners() {
		return listeners.getListeners(_RangeSliderListener.class);
	}


	

}
