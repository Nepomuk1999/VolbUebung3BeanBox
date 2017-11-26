package solution.Wrapper;

import interfaces.Writeable;
import solution.ImageSaveFilter;

import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public class WrapperImageSaveFilter extends HandelPlanarImageListeners implements PlanarImageListener, Writeable<PlanarImage>,Serializable {
    private ImageSaveFilter isf;
    private PlanarImage image;

    public WrapperImageSaveFilter(){
        isf = new ImageSaveFilter(this);
    }

    public String getPath(){
        return isf.getFileOutputPath();
    }

    public void setPath(String i){
        isf.setFileOutputPath(i);
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
        Boolean resultforward = isf.forward(image);
        if(listenersEmpty() == false) {
            fireFilterListener(image);
            System.out.println("fire: ImageSaveFilter");
        }
    }

}
