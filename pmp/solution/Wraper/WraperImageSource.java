package solution.Wraper;


import interfaces.Writeable;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Vector;

import solution.ImageSource;

public class WraperImageSource implements Serializable {
    private String ImageSource;
    private ImageSource is;
    private PlanarImage image;
    private Vector listeners;

    public WraperImageSource() {
        is = new ImageSource();
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

    public void addFilterListener(FilterListener wl) {
        listeners.addElement(wl);
    }

    public void removeFilteristener(FilterListener wl) {
        listeners.removeElement(wl);
    }

}
