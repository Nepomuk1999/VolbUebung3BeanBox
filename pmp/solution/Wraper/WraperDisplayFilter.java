package solution.Wraper;


import interfaces.Writeable;

import javax.media.jai.PlanarImage;
import java.io.StreamCorruptedException;

public class WraperDisplayFilter implements FilterListener, Writeable<PlanarImage> {
    String test = "";

    @Override
    public void write(PlanarImage value) throws StreamCorruptedException {

    }

    @Override
    public void inputFromValueChanged(InputfromEvent ife) {

    }

}
