package solution.Wrapper;

import importclasses.Coordinate;

import java.util.ArrayList;
import java.util.Vector;

public class HandelArrayListListeners {
    private Vector listeners = new Vector();


    protected synchronized void fireFilterListener(ArrayList<Coordinate> list) {
        Vector v;
        synchronized(this) {
            v = (Vector)listeners.clone();
        }
        ArrayListEvent ie = new ArrayListEvent(this, list);
        if(list != null) {
            for (int i = 0; i < v.size(); i++) {
                ArrayListListener fl = (ArrayListListener) v.elementAt(i);
                fl.inputFromArrayListEvent(ie);
            }
        }
    }

    public void addArrayListListener(ArrayListListener wl) {
        listeners.addElement(wl);
    }

    public void removeArrayListListener(ArrayListListener wl) {
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
