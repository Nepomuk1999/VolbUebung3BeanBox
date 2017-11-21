package solution;

import filter.DataTransformationFilter2;
import interfaces.Readable;
import interfaces.Writeable;

import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.operator.DilateDescriptor;
import java.security.InvalidParameterException;

public class ErodeDilateFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {
    KernelJAI kernel;

    public ErodeDilateFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    public ErodeDilateFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    public PlanarImage process(PlanarImage entity) {
        float[] kernelMatrix = new float[]{0, 50, 50, 0
                , 50, 0, 0, 50
                , 50, 0, 0, 50
                , 0, 50, 50, 0};
        kernel = new KernelJAI(4, 4, kernelMatrix);
        return entity = DilateDescriptor.create(entity, kernel, null);
    }
}
