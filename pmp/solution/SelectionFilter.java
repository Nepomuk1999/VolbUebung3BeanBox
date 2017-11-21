package solution;

import filter.DataTransformationFilter2;
import interfaces.Readable;
import interfaces.Writeable;

import javax.media.jai.PlanarImage;
import javax.media.jai.operator.ThresholdDescriptor;
import java.security.InvalidParameterException;

public class SelectionFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {
    private Integer _low;
    private Integer _high;
    private Integer _constants;

    public SelectionFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
        _low = 0;
        _high = 35;
        _constants = 255;
    }

    public SelectionFilter(Readable<PlanarImage> input) {
        super(input);
    }

    public Integer getLow() {
        return _low;
    }

    public void setLow(Integer low) {
        this._low = low;
    }

    public Integer getHigh() {
        return _high;
    }

    public void setHigh(Integer high) {
        this._high = high;
    }

    public Integer getConstants() {
        return _constants;
    }

    public void setConstants(Integer constants) {
        this._constants = constants;
    }

    @Override
    public PlanarImage process(PlanarImage entity) {
        double[] low = {(Double.parseDouble(_low.toString()))};
        double[] high = {(Double.parseDouble(_high.toString()))};
        double[] constants = {(Double.parseDouble(_constants.toString()))};
        return entity = ThresholdDescriptor.create(entity, low, high, constants, null);
    }

}
