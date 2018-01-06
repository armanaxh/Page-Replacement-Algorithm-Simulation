package core.object;

/**
 * Created by armanaxh on 1/2/18.
 */
public class Frame {

    private long frameID;
    private Page inSidePage;

    public Frame(long frameNumber) {
        this.frameID = frameNumber;
        inSidePage = null;
    }

    public void setInSidePage(Page inSidePage) {
        this.inSidePage = inSidePage;
        this.inSidePage.setInSidePage(this);
    }

    public void beFree(){
        this.inSidePage = null;
    }

    public boolean isFree(){
        if(inSidePage == null)
            return true;
        return false;
    }

    public long getFrameID() {
        return frameID;
    }

    public Page getInSidePage() {
        return inSidePage;
    }

    public String toString(){
        return " frame : "+getFrameID();
    }
}
