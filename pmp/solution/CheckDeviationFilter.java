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
    Integer range = 10;

    public CheckDeviationFilter(Writeable<ResultModel> output, LinkedList<Coordinate> expectedCentroids, Integer range)
            throws InvalidParameterException {
        super(output);
        this.range = range;
        _expectedCentroids = expectedCentroids;
    }

    public CheckDeviationFilter(Readable<ResultModel> input, LinkedList<Coordinate> expectedCentroids, Integer range)
            throws InvalidParameterException {
        super(input);
        this.range = range;
        _expectedCentroids = expectedCentroids;
    }

    public CheckDeviationFilter(Writeable<ResultModel> output) throws InvalidParameterException {
        super(output);
    }


    @Override
    public ResultModel process(ResultModel entity) {

        for (Ball ball : entity.getBalls()) {
            ball.setIsInTolerance(isInTolerance(ball.getCoordinates()));
        }
        return entity;
    }

    private Boolean isInTolerance(Coordinate toCheck) {
        int xToCheck = toCheck._x;
        int yToCheck = toCheck._y;
        for (Coordinate c : _expectedCentroids) {
            if (xToCheck >= (c._x - range / 2) && xToCheck <= (c._x + range / 2)) {
                if (yToCheck >= (c._y - range / 2) && yToCheck <= (c._y + range / 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public LinkedList<Coordinate> getExpectedCentroids() {
        return _expectedCentroids;
    }

    public void setExpectedCentroids(LinkedList<Coordinate> _expectedCentroids) {
        this._expectedCentroids = _expectedCentroids;
    }
}
