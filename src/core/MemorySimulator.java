package core;

import core.object.Frame;
import core.object.Page;
import java.util.ArrayList;

/**
 * Created by armanaxh on 1/2/18.
 */
public class MemorySimulator {

    private long numberOfFrame;
    private long frameSize;
    private long memoryCapacity; //By Word
    private ArrayList<Frame> frames;

    public MemorySimulator(long frameSize, long memoryCapacity) {
        this.frameSize = frameSize;
        this.memoryCapacity = memoryCapacity;
        this.numberOfFrame = memoryCapacity/frameSize;
        this.frames = new ArrayList<>();
        this.init();
    }

    private void init(){
        for(long i=0 ; i<numberOfFrame ; i++){
            this.frames.add(new Frame(i));
        }
    }

    public boolean allocateFrame(int i , Page page){
        Frame temp = frames.get(i);
        if(temp.isFree()) {
            temp.setInSidePage(page);
            return true;
        }
        return false;
    }
    public void beFreeFrame(int i){
        frames.get(i).beFree();
    }
    public long getNumberOfFrame() {
        return numberOfFrame;
    }
    public Frame getFreeFrame(){
        for(Frame f : frames){
            if(f.isFree())
                return f;
        }
        return null;
    }
    public Frame getFormewithPage(Page p){
        for(Frame f: frames){
            if(f.getInSidePage().equals(p)){
                return f;
            }
        }
        return null;
    }
    public void clearCatch(){
        for(Frame f:frames){
            f.beFree();
        }
    }
}
