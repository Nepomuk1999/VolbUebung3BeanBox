package solution;

import java.io.StreamCorruptedException;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import interfaces.Writeable;
import interfaces.Readable;

import filter.Source;


public class ImageSource extends Source<PlanarImage> {

    String ImageSource;
    boolean b = true;

    public ImageSource(){
    }

    public ImageSource(Readable<PlanarImage> output){

    }

    public ImageSource(Writeable<PlanarImage> output){
        super(output);
    }

    @Override
    public PlanarImage read() throws StreamCorruptedException {
        PlanarImage current = null;
        current = JAI.create("fileload", ImageSource);
        
        return current;

    }

    public void setImageSource(String imageSource) {
        ImageSource = imageSource;
    }
}
