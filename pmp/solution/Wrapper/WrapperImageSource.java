package solution.Wrapper;


import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;

import interfaces.Writeable;
import solution.ImageSource;

public class WrapperImageSource extends HandelPlanarImageListeners implements Writeable,Serializable {
    private String Path;
    private ImageSource is;
    private PlanarImage image;
    private Boolean Send;

    public WrapperImageSource() {
        is = new ImageSource(this);
        Path = new String();
        Send = false;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String imageSourcePath) {
        Path = imageSourcePath;
        if(Path != null && (false == Path.trim().isEmpty())) {
            is.setImageSource(Path);
            try {
                image = is.read();
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setSend(Boolean i){
        Send = i;
        if(Send == true) {
            startFilters();
        }
    }

    public Boolean getSend(){
        return Send;
    }

    public void startFilters(){
        if(listenersEmpty() == false && image != null) {
            fireFilterListener(image);
            System.out.println("fire: ImageSource");
        }
    }

    @Override
    public void write(Object value) throws StreamCorruptedException {

    }
}
