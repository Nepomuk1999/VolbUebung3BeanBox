package solution;

import filter.ForwardingFilter;
import interfaces.Readable;
import interfaces.Writeable;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.FileStoreDescriptor;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

public class ImageSaveFilter extends ForwardingFilter<PlanarImage> {
    String fileOutputPath = "";

    public ImageSaveFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    public ImageSaveFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    public void setFileOutputPath(String path){
        fileOutputPath = path;
    }

    public String getFileOutputPath(){
        return fileOutputPath;
    }

    @Override
    public boolean forward(PlanarImage entity) {
        String filename = "" + System.currentTimeMillis() + ".jpg";
        try {
            ImageIO.write(entity, "JPG",new File(/*fileOutputPath +*/ filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ImageFile: " + filename);
        return true;
    }
}
