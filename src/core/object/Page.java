package core.object;

/**
 * Created by armanaxh on 1/2/18.
 */
public class Page {

    private long pageID;
    private Frame isInsideFrame;

    public Page(long pageID ) {
        this.pageID = pageID;
    }

    public void setInSidePage(Frame isInsideFrame) {
        this.isInsideFrame = isInsideFrame;
    }

    public long getPageID() {
        return pageID;
    }

    public Frame getIsInsideFrame() {
        return isInsideFrame;
    }
    public String toString(){
        return " page : "+getPageID();
    }
}
