package solution.Wrapper;

import interfaces.Writeable;
import solution.MedianFilter;

import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public class WrapperMedianFilter extends HandelPlanarImageListeners implements PlanarImageListener, Writeable<PlanarImage>,Serializable {
    private MedianFilter mf;
    private PlanarImage image;

    public WrapperMedianFilter(){
        mf = new MedianFilter(this);
    }

    public Integer getMaskSize(){
        return mf.getMaskSize();
    }

    public void setMaskSize(Integer i){
        mf.setMaskSize(i);
        fireE();
    }

    @Override
    public void inputFromPlanarImageEvent(PlanarImageEvent ife) {
        image = ife.getValue();
        fireE();
    }

    @Override
    public void write(PlanarImage value) throws StreamCorruptedException {

    }

    public void fireE(){
        PlanarImage resultMedianFilter = mf.process(image);
        if(listenersEmpty() == false) {
            fireFilterListener(resultMedianFilter);
            System.out.println("fire: MedianFilter");
        }
    }
}
