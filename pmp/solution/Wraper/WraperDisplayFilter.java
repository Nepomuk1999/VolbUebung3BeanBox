package solution.Wraper;


import interfaces.Writeable;
import solution.DisplayFilter;

import javax.media.jai.PlanarImage;
import java.io.StreamCorruptedException;

public class WraperDisplayFilter implements FilterListener, Writeable<PlanarImage> {
    DisplayFilter df;
    PlanarImage image;

    public WraperDisplayFilter(){
        df = new DisplayFilter(this,"DisplayFilter");
    }

    @Override
    public void inputFromEvent(InputEvent ife) {
       image = ife.getValue();
       Boolean test = df.forward(image);
    }

    @Override
    public void write(PlanarImage value) throws StreamCorruptedException {

    }
}
