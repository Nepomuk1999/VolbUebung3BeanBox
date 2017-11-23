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


    public WrapperCheckDeviationFilter() {
        filter = new CheckDeviationFilter(this);
    }

    public Integer getRange() {
        return filter.getRange();
    }

    public void setRange(Integer range) {
        filter.setRange(range);
    }

    @Override
    public void inputFromResultModelEvent(ResultModelEvent resultModelEvent) {
        model = resultModelEvent.getValue();
        ResultModel result = filter.process(model);
        if (!listenersEmpty()) {
            fireFilterListener(result);
            System.out.println("fire: CheckDeviationFilter");
        }
    }

    @Override
    public void write(ResultModel value) throws StreamCorruptedException {

    }
}
