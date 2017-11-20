package solution.Wraper;

import java.util.EventListener;

public interface FilterListener extends EventListener {
    public abstract void inputFromValueChanged(InputfromEvent ife);
}
