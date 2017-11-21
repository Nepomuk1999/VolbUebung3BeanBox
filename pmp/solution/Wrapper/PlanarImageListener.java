package solution.Wrapper;

import java.util.EventListener;

public interface PlanarImageListener extends EventListener {
    public abstract void inputFromPlanarImageEvent(PlanarImageEvent ife);
}
