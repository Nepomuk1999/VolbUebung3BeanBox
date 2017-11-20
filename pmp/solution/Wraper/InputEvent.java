package solution.Wraper;

import interfaces.Writeable;

import javax.media.jai.PlanarImage;
import java.io.StreamCorruptedException;
import java.util.EventObject;

public class InputEvent extends EventObject {
    private PlanarImage value;

    public InputEvent(Object source, PlanarImage value) {
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
