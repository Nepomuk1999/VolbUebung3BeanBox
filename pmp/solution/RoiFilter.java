package solution;

import filter.DataTransformationFilter2;
import interfaces.Readable;
import interfaces.Writeable;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.security.InvalidParameterException;

public class RoiFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {

    public RoiFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    public RoiFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    protected PlanarImage process(PlanarImage nextVal) {
        PlanarImage image = nextVal;
        Rectangle rectangle = new Rectangle(10, 35, image.getWidth(), image.getHeight() / 4);
        nextVal = PlanarImage.wrapRenderedImage(image.getAsBufferedImage(rectangle, image.getColorModel()));
        nextVal.setProperty("offsetX", 10);
        nextVal.setProperty("offsetY", 35);
        return nextVal;
    }

}
