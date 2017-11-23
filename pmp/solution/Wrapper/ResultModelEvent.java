package solution.Wrapper;

import Model.ResultModel;

import java.util.EventObject;

public class ResultModelEvent extends EventObject {
    private ResultModel value;

    public ResultModelEvent(Object source, ResultModel value) {
        super(source);
        this.value = value;
    }

    public ResultModel getValue() {
        return value;
    }

    public void setValue(ResultModel value) {
        this.value = value;
    }
}
