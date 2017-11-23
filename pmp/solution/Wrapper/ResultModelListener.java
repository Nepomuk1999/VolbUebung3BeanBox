package solution.Wrapper;

import java.util.EventListener;

public interface ResultModelListener extends EventListener {
    public abstract void inputFromResultModelEvent(ResultModelEvent resultModelEvent);
}
