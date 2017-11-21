package solution.Wrapper;

import importclasses.Coordinate;

import java.util.ArrayList;
import java.util.EventListener;

public interface ArrayListListener extends EventListener {
        public abstract void inputFromArrayListEvent(ArrayListEvent ale);
}
