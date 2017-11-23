package solution.Wrapper;

import Model.ResultModel;
import importclasses.Coordinate;

import java.util.EventObject;
import java.util.LinkedList;

public class ResultModelEvent extends EventObject {
    private ResultModel value;
    private int range;
    private LinkedList<Coordinate> expectedCentroids;

    public ResultModelEvent(Object source, ResultModel value, int range,LinkedList<Coordinate> expectedCentroids) {
        super(source);
        this.value = value;
        this.range = range;
        this.expectedCentroids = expectedCentroids;
    }

    public ResultModel getValue() {
        return value;
    }

    public void setValue(ResultModel value) {
        this.value = value;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public LinkedList<Coordinate> getExpectedCentroids() {
        return expectedCentroids;
    }

    public void setExpectedCentroids(LinkedList<Coordinate> expectedCentroids) {
        this.expectedCentroids = expectedCentroids;
    }
}
