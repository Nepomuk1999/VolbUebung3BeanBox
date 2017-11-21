package solution.Wrapper;

import interfaces.Writeable;
import solution.ErodeDilateFilter;

import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public class WrapperErodeDilateFilter extends HandelPlanarImageListeners implements PlanarImageListener, Writeable<PlanarImage>,Serializable {
    private ErodeDilateFilter edf;
    private PlanarImage image;

    public WrapperErodeDilateFilter(){
        edf = new ErodeDilateFilter(this);
    }

    @Override
    public void inputFromPlanarImageEvent(PlanarImageEvent ife) {
        image = ife.getValue();
        PlanarImage resultErodeDilateFilter = edf.process(image);
        if(listenersEmpty() == false) {
            fireFilterListener(resultErodeDilateFilter);
            System.out.println("fire: ErodeDilateFilter");
        }
    }

    @Override
    public void write(PlanarImage value) throws StreamCorruptedException {

    }
}

