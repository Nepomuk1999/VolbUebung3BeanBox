package solution.Wrapper;

import Model.ResultModel;
import interfaces.Writeable;
import solution.ImageSink;

import java.io.Serializable;
import java.io.StreamCorruptedException;

public class WrapperImageSink extends HandelResultModelListener implements ResultModelListener, Writeable<ResultModel>, Serializable {

    private String fileOutputPath = "" + System.getProperty("user.dir");
    private String fileName = "" + System.currentTimeMillis();
    private ResultModel model;
    private ImageSink sink;
    ResultModelEvent resultModelEvent;

    public WrapperImageSink() {
        sink = new ImageSink();
    }

    @Override
    public void inputFromResultModelEvent(ResultModelEvent resultModelEvent) {
       this.resultModelEvent = resultModelEvent;
       model = resultModelEvent.getValue();
       fireE();
    }


    @Override
    public void write(ResultModel value) throws StreamCorruptedException {

    }

    //Getter & Setter

    public String getFileOutputPath() {
        return fileOutputPath;
    }

    public void setFileOutputPath(String fileOutputPath) {
        this.fileOutputPath = fileOutputPath;
        fireE();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        fireE();
    }

    public void fireE(){
        try {
            sink.setrange(resultModelEvent.getRange());
            sink.setStartcoordinates(resultModelEvent.getExpectedCentroids());
            sink.write(model);
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        }
    }

}
