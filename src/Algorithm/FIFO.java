package Algorithm;

import core.MemorySimulator;
import core.ProgramSimulator;
import core.object.Frame;
import core.object.Page;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by armanaxh on 1/3/18.
 */
public class FIFO extends Algo{

    private Queue<Page> queue;

    public FIFO(MemorySimulator memorySim, ProgramSimulator programSim) {
        super(memorySim, programSim);
        this.queue = new LinkedList<>();
    }

    @Override
    public Algo calc() {
        memorySim.clearCatch();

        int eCount = 0 ;
        for(Page p : programSim.getProgram()){

            if(queue.contains(p)) {
                continue;
            }

            queue.add(p);
            Frame frame = memorySim.getFreeFrame();
            if(frame != null ){
                frame.setInSidePage(p);
                continue;
            }else{
                frame = queue.poll().getIsInsideFrame();
                frame.beFree();
                if(frame.isFree()){
                    frame.setInSidePage(p);
                    eCount++;
                }
            }
        }
        this.result.setRsult(programSim.getProgram().size() , eCount , memorySim.getNumberOfFrame());
        return this;
    }

}
