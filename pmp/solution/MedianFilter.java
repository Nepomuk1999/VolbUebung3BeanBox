package solution;

import filter.DataTransformationFilter2;
import interfaces.Readable;
import interfaces.Writeable;

import javax.media.jai.PlanarImage;
import javax.media.jai.operator.MedianFilterDescriptor;
import javax.media.jai.operator.MedianFilterShape;
import java.security.InvalidParameterException;

import static javax.media.jai.operator.MedianFilterDescriptor.MEDIAN_MASK_SQUARE;

public class MedianFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {

    public MedianFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    public MedianFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    protected PlanarImage process(PlanarImage entity) {
        Integer maskSize = 21;
        MedianFilterShape shape = MEDIAN_MASK_SQUARE;
        return entity = MedianFilterDescriptor.create(entity, shape, maskSize,
                null);
    }
}
