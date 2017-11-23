package solution.Wrapper;

import Model.ResultModel;
import importclasses.Coordinate;
import interfaces.Writeable;
import solution.CountBallsFilter;

import javax.media.jai.PlanarImage;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

public class WrapperCountBallsFilter extends HandelResultModelListener implements ArrayListListener, Writeable<ResultModel>, Serializable {
    private CountBallsFilter cbf;
    private ArrayList<Coordinate> centroids;


    public WrapperCountBallsFilter() {
        cbf = new CountBallsFilter(this);
    }

    @Override
    public void inputFromArrayListEvent(ArrayListEvent ale) {
        centroids = ale.getValue();
        ResultModel result = cbf.process(centroids);
        if (!listenersEmpty()) {
            fireFilterListener(result,-1,null);
            System.out.println("fire: FilterCountBalls");
        }
    }


    @Override
    public void write(ResultModel value) throws StreamCorruptedException {
    }
}
