package solution.Wrapper;


import interfaces.Writeable;
import solution.DisplayFilter;

import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public class WrapperDisplayFilter extends HandelPlanarImageListeners implements PlanarImageListener, Writeable<PlanarImage>,Serializable {
    private DisplayFilter df;
    private PlanarImage image;


    public WrapperDisplayFilter(){
        df = new DisplayFilter(this,"DisplayFilter");
    }

    @Override
    public void inputFromPlanarImageEvent(PlanarImageEvent ife) {
       image = ife.getValue();
       Boolean resultforward = df.forward(image);
       if(listenersEmpty() == false) {
           fireFilterListener(image);
           System.out.println("fire: DisplayFilter");
       }
    }

    @Override
    public void write(PlanarImage value) throws StreamCorruptedException {
    }

}
