package solution.Wraper;


import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Vector;

import interfaces.Writeable;
import solution.ImageSource;

public class WraperImageSource implements Writeable,Serializable {
    private String Path;
    private ImageSource is;
    private PlanarImage image;
    private Vector listeners;

    public WraperImageSource() {
        is = new ImageSource(this);
        listeners = new Vector();
        Path = new String();
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String imageSourcePath) {
        Path = imageSourcePath;
        if(Path != null || (false == Path.trim().isEmpty())) {
            is.setImageSource(Path);
            try {
                image = is.read();
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            }
            fireFilterListener();
        }
    }

    protected synchronized void fireFilterListener() {
        Vector v;
        synchronized(this) {
            v = (Vector)listeners.clone();
        }
        InputEvent ie = new InputEvent(this, image);
        for(int i = 0; i < v.size(); i++) {
            FilterListener fl = (FilterListener) v.elementAt(i);
            fl.inputFromEvent(ie);
        }
    }


    public void addFilterListener(FilterListener wl) {
        listeners.addElement(wl);
    }

    public void removeFilterListener(FilterListener wl) {
        listeners.removeElement(wl);
    }


    @Override
    public void write(Object value) throws StreamCorruptedException {

    }
}
