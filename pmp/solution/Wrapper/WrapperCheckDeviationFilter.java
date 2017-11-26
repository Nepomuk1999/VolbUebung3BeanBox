package solution.Wrapper;

import Model.ResultModel;
import importclasses.Coordinate;
import interfaces.Writeable;
import solution.CheckDeviationFilter;

import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.LinkedList;

public class WrapperCheckDeviationFilter extends HandelResultModelListener implements ResultModelListener, Writeable<ResultModel>, Serializable {
    private CheckDeviationFilter filter;
    private ResultModel model;
    private LinkedList<Coordinate> expectedCentroids = new LinkedList<>();
    private Integer x1 = 71;
    private Integer y1 = 77;
    private Integer x2 = 110;
    private Integer y2 = 80;
    private Integer x3 = 202;
    private Integer y3 = 80;
    private Integer x4 = 265;
    private Integer y4 = 79;
    private Integer x5 = 330;
    private Integer y5 = 81;
    private Integer x6 = 396;
    private Integer y6 = 81;


    public WrapperCheckDeviationFilter() {
        filter = new CheckDeviationFilter(this);
    }

    @Override
    public void inputFromResultModelEvent(ResultModelEvent resultModelEvent) {
        model = resultModelEvent.getValue();
        fireE();
    }

    @Override
    public void write(ResultModel value) throws StreamCorruptedException {
    }

    public void fireE(){
        expectedCentroids = new LinkedList<>();
        //setup for expected Cords
        Coordinate c1 = new Coordinate(x1, y1);
        expectedCentroids.add(c1);
        Coordinate c2 = new Coordinate(x2, y2);
        expectedCentroids.add(c2);
        Coordinate c3 = new Coordinate(x3, y3);
        expectedCentroids.add(c3);
        Coordinate c4 = new Coordinate(x4, y4);
        expectedCentroids.add(c4);
        Coordinate c5 = new Coordinate(x5, y5);
        expectedCentroids.add(c5);
        Coordinate c6 = new Coordinate(x6, y6);
        expectedCentroids.add(c6);
        filter.setExpectedCentroids(expectedCentroids);

        ResultModel result = filter.process(model);
        if (!listenersEmpty()) {
            fireFilterListener(result, getRange(), expectedCentroids);
            System.out.println("fire: CheckDeviationFilter");
        }
    }

    // Getter & Setter


    public Integer getRange() {
        return filter.getRange();
    }

    public void setRange(Integer range) {
        filter.setRange(range);
        fireE();
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
        fireE();
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
        fireE();
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
        fireE();
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
        fireE();
    }

    public Integer getX3() {
        return x3;
    }

    public void setX3(Integer x3) {
        this.x3 = x3;
        fireE();
    }

    public Integer getY3() {
        return y3;
    }

    public void setY3(Integer y3) {
        this.y3 = y3;
        fireE();
    }

    public Integer getX4() {
        return x4;
    }

    public void setX4(Integer x4) {
        this.x4 = x4;
        fireE();
    }

    public Integer getY4() {
        return y4;
    }

    public void setY4(Integer y4) {
        this.y4 = y4;
        fireE();
    }

    public Integer getX5() {
        return x5;
    }

    public void setX5(Integer x5) {
        this.x5 = x5;
        fireE();
    }

    public Integer getY5() {
        return y5;
    }

    public void setY5(Integer y5) {
        this.y5 = y5;
        fireE();
    }

    public Integer getX6() {
        return x6;
    }

    public void setX6(Integer x6) {
        this.x6 = x6;
        fireE();
    }

    public Integer getY6() {
        return y6;
    }

    public void setY6(Integer y6) {
        this.y6 = y6;
        fireE();
    }

}
