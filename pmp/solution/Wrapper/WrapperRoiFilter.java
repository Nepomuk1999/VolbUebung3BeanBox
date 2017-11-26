package solution.Wrapper;

import interfaces.Writeable;
import solution.RoiFilter;

import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public class WrapperRoiFilter extends HandelPlanarImageListeners implements PlanarImageListener, Writeable<PlanarImage>,Serializable {
    private RoiFilter rf;
    private PlanarImage image;

    public WrapperRoiFilter(){
        rf = new RoiFilter(this);
    }

    @Override
    public void inputFromPlanarImageEvent(PlanarImageEvent ife) {
        image = ife.getValue();
        PlanarImage resultRoiFilter = rf.process(image);
        if(listenersEmpty() == false) {
            fireFilterListener(resultRoiFilter);
            System.out.println("fire: RoiFilter");
        }
    }

    @Override
    public void write(PlanarImage value) throws StreamCorruptedException {

    }

}
