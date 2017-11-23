package solution;

import Model.ResultModel;
import filter.DataTransformationFilter2;
import importclasses.Coordinate;
import interfaces.Readable;
import interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class CountBallsFilter extends DataTransformationFilter2<ArrayList<Coordinate>, ResultModel> {

    public CountBallsFilter(Writeable<ResultModel> output) throws InvalidParameterException {
        super(output);
    }

    public CountBallsFilter(Readable<ArrayList<Coordinate>> input) throws InvalidParameterException {
        super(input);
    }

    @Override
    public ResultModel process(ArrayList<Coordinate> entity) {
        if (entity != null) {
            return new ResultModel(entity);
        } else {
            return null;
        }
    }
}
