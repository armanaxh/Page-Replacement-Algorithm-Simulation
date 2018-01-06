package Algorithm;

import core.MemorySimulator;
import core.ProgramSimulator;
import core.object.Frame;
import core.object.Page;
import javafx.util.Pair;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by armanaxh on 1/3/18.
 */
public class Clock extends Algo{


    private LinkedList<Page> queue;
    private Hashtable<Page,Boolean> chack;

    public Clock(MemorySimulator memorySim, ProgramSimulator programSim) {
        super(memorySim, programSim);
        this.queue = new LinkedList<>();
        this.chack = new Hashtable<>();
    }

    @Override
    public Algo calc() {
        memorySim.clearCatch();

        int eCount = 0 ;
        for(Page p : programSim.getProgram()){
            if(queue.contains(p)) {
                chack.put(p, true);
                continue;
            }

            queue.add(p);
            chack.put(p, true);
            Frame frame = memorySim.getFreeFrame();
            if(frame != null ){
                frame.setInSidePage(p);
                continue;
            }else{
                for(Page temp : queue) {
                    if(chack.get(temp) == true ){
                        chack.put(temp,false);
                    }else {
                        frame = temp.getIsInsideFrame();
                        queue.remove(temp);
                        frame.beFree();
                        if(frame.isFree()){
                            frame.setInSidePage(p);
                            eCount++;
                        }
                        break;
                    }
                }

                if(frame == null){
                    frame = queue.poll().getIsInsideFrame();
                    frame.beFree();
                    if(frame.isFree()){
                        frame.setInSidePage(p);
                        eCount++;
                    }
                }

            }
        }
        this.result.setRsult(programSim.getProgram().size() , eCount , memorySim.getNumberOfFrame());
        return this;
    }


}
