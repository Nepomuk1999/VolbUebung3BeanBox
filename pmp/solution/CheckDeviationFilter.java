package solution;

import Model.Ball;
import Model.ResultModel;
import filter.DataTransformationFilter2;
import importclasses.Coordinate;
import interfaces.Readable;
import interfaces.Writeable;

import java.security.InvalidParameterException;
import java.util.LinkedList;

public class CheckDeviationFilter extends DataTransformationFilter2<ResultModel, ResultModel> {

    LinkedList<Coordinate> _expectedCentroids;
    Integer _range;

    public CheckDeviationFilter(Writeable<ResultModel> output, LinkedList<Coordinate> expectedCentroids, Integer range)
            throws InvalidParameterException {
        super(output);
        _range = range;
        _expectedCentroids = expectedCentroids;
    }

    public CheckDeviationFilter(Readable<ResultModel> input, LinkedList<Coordinate> expectedCentroids, Integer range)
            throws InvalidParameterException {
        super(input);
        _range = range;
        _expectedCentroids = expectedCentroids;
    }

    @Override
    protected ResultModel process(ResultModel entity) {

        for (Ball ball : entity.getBalls()) {
            ball.setIsInTolerance(isInTolerance(ball.getCoordinates()));
        }
        return entity;
    }

    private Boolean isInTolerance(Coordinate toCheck) {
        int xToCheck = toCheck._x;
        int yToCheck = toCheck._y;
        for (Coordinate c : _expectedCentroids) {
            if (xToCheck >= (c._x - _range / 2) && xToCheck <= (c._x + _range / 2)) {
                if (yToCheck >= (c._y - _range / 2) && yToCheck <= (c._y + _range / 2)) {
                    return true;
                }
            }
        }
        return false;
    }


}
