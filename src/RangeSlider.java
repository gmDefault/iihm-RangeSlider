import javax.swing.JSlider;

public class RangeSlider implements _RangeSlider {

	private int minValue;
	private int maxValue;
	private int value;
	private int extent;
	
	
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
	}

	@Override
	public void setExtent(int extent) {
		this.extent = extent;
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
	

}
