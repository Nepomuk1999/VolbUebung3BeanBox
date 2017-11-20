package solution.Wraper;


import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.util.Vector;

import solution.ImageSource;

public class WraperImageSource implements Serializable {
    private String ImageSource;
    private ImageSource is = new ImageSource();;
    private PlanarImage image;
    private Vector listeners;

    public WraperImageSource() {
    }

    public String getImageSource() {
        return ImageSource;
    }

    public void setImageSource(String imageSource) {
        ImageSource = imageSource;
        is.setImageSource(ImageSource);
    }

    protected synchronized void fireFilterListener() {
        Vector v;
        synchronized(this) {
            v = (Vector)listeners.clone();
        }
        InputfromEvent ie = new InputfromEvent(this, image);
        for(int i = 0; i < v.size(); i++) {
            FilterListener fl = (FilterListener) v.elementAt(i);
            fl.inputFromValueChanged(ie);
        }
    }

    protected synchronized void fireFilterEvent() {
        InputfromEvent ie = new InputfromEvent(this,image);
    }

    public void addFilterListener(FilterListener wl) {
        listeners.addElement(wl);
    }

    public void removeFilteristener(FilterListener wl) {
        listeners.removeElement(wl);
    }

}
