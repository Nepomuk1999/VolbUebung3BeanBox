package solution.Wrapper;

import Model.ResultModel;

import java.util.Vector;

public class HandelResultModelListener {
    private Vector listeners = new Vector();

    protected synchronized void fireFilterListener(ResultModel model) {
        Vector v;
        synchronized (this) {
            v = (Vector) listeners.clone();
        }
        ResultModelEvent event = new ResultModelEvent(this, model);
        if (model != null) {
            for (int i = 0; i < v.size(); i++) {
                ResultModelListener modelListener = (ResultModelListener) v.elementAt(i);
                modelListener.inputFromResultModelEvent(event);
            }
        }
    }

    public void addResultModelListener(ResultModelListener resultModelListener) {
        listeners.addElement(resultModelListener);
    }

    public void removeResultModelListener(ResultModelListener resultModelListener) {
        listeners.removeElement(resultModelListener);
    }

    public Boolean listenersEmpty() {
        if (listeners.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
