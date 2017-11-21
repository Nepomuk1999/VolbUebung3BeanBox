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
    Integer _maskSize;

    public MedianFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
        _maskSize = 21;
    }

    public MedianFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    public PlanarImage process(PlanarImage entity) {
        MedianFilterShape shape = MEDIAN_MASK_SQUARE;
        return entity = MedianFilterDescriptor.create(entity, shape, _maskSize,
                null);
    }

    public void setMaskSize(Integer i){
        _maskSize = i;
    }

    public Integer getMaskSize() {
        return _maskSize;
    }
}
