package solution.Wrapper;

import javax.media.jai.PlanarImage;
import java.util.EventObject;

public class PlanarImageEvent extends EventObject {
    private PlanarImage value;

    public PlanarImageEvent(Object source, PlanarImage value) {
        super(source);
        this.value = value;
    }

    public PlanarImage getValue() {
        return value;
    }

    public void setValue(PlanarImage value) {
        this.value = value;
    }

}
