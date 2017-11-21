package solution.Wrapper;

import importclasses.Coordinate;

import java.util.ArrayList;
import java.util.EventObject;

public class ArrayListEvent extends EventObject {
    private ArrayList<Coordinate> value;

    public ArrayListEvent(Object source, ArrayList<Coordinate> value) {
        super(source);
        this.value = value;
    }

    public ArrayList<Coordinate> getValue() {
        return value;
    }

    public void setValue(ArrayList<Coordinate> value) {
        this.value = value;
    }

}
