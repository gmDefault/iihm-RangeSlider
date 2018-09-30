package slider.fc;

import java.util.EventListener;

public interface _RangeSliderListener extends EventListener{
	
    void MaxChanged(double newmax);
    
    void MinChanged(double newmax);

}
