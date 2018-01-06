package controller;

/**
 * Created by armanaxh on 1/3/18.
 */
public class Result {
    private int pageError;
    private int refer;
    private long numberOfFrame;

    public Result() {
    }

    public void setRsult(int refer, int pageError, long numberOfFrame) {
        this.pageError = pageError;
        this.refer = refer;
        this.numberOfFrame = numberOfFrame;
    }

    public int getPageError() {
        return pageError;
    }

    public int getRefer() {
        return refer;
    }

    public long getNumberOfFrame() {
        return numberOfFrame;
    }
}
