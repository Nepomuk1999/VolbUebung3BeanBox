package solution.Wrapper;

import importclasses.Coordinate;

import javax.media.jai.PlanarImage;
import java.util.ArrayList;
import java.util.Vector;

public class HandelPlanarImageListeners {
    private Vector listeners = new Vector();

    protected synchronized void fireFilterListener(PlanarImage image) {
        Vector v;
        synchronized(this) {
            v = (Vector)listeners.clone();
        }
        PlanarImageEvent ie = new PlanarImageEvent(this, image);
        if(image != null) {
            for (int i = 0; i < v.size(); i++) {
                PlanarImageListener fl = (PlanarImageListener) v.elementAt(i);
                fl.inputFromPlanarImageEvent(ie);
            }
        }
    }

    public void addPlanarImageListener(PlanarImageListener wl) {
        listeners.addElement(wl);
    }

    public void removePlanarImageListener(PlanarImageListener wl) {
        listeners.removeElement(wl);
    }


    public Boolean listenersEmpty(){
        if(listeners.isEmpty()){
         return true;
        } else {
          return false;
        }
    }

}
