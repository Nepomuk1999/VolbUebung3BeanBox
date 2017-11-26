package solution.Wrapper;

import interfaces.Writeable;
import solution.SelectionFilter;

import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public class WrapperSelectionFilter extends HandelPlanarImageListeners implements PlanarImageListener, Writeable<PlanarImage>,Serializable {
    private SelectionFilter sf;
    private PlanarImage image;

    public WrapperSelectionFilter(){
        sf = new SelectionFilter(this);
    }

    public Integer getLow() {
        return sf.getLow();
    }

    public void setLow(Integer low) {
        sf.setLow(low);
        fireE();
    }

    public Integer getHigh() {
        return sf.getHigh();
    }

    public void setHigh(Integer high) {
        sf.setHigh(high);
        fireE();
    }

    public Integer getConstants() {
        return sf.getConstants();
    }

    public void setConstants(Integer constants) {
        sf.setConstants(constants);
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
        PlanarImage resultSelectionFilter = sf.process(image);
        if(listenersEmpty() == false) {
            fireFilterListener(resultSelectionFilter);
            System.out.println("fire: SelectionFilter");
        }
    }

}
