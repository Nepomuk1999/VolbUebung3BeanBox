package solution.Wrapper;

import importclasses.Coordinate;
import importclasses.FilterCalcCentroids;
import interfaces.Writeable;

import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

public class WrapperFilterCalcCentroids extends HandelArrayListListeners implements PlanarImageListener, Writeable<ArrayList<Coordinate>>,Serializable {
    private FilterCalcCentroids fcc;
    private PlanarImage image;

    public WrapperFilterCalcCentroids(){
        fcc = new FilterCalcCentroids(this);
    }

    @Override
    public void inputFromPlanarImageEvent(PlanarImageEvent ife) {
        image = ife.getValue();
        ArrayList<Coordinate> resultFilterCalcCentroids = fcc.process(image);
        System.out.println(resultFilterCalcCentroids);
        if(listenersEmpty() == false) {
            fireFilterListener(resultFilterCalcCentroids);
            System.out.println("fire: FilterCalcCentroids");
        }
    }


    @Override
    public void write(ArrayList<Coordinate> value) throws StreamCorruptedException {

    }
}
