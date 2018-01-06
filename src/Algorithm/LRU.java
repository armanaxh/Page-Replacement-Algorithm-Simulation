package Algorithm;

import core.MemorySimulator;
import core.ProgramSimulator;
import core.object.Frame;
import core.object.Page;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by armanaxh on 1/3/18.
 */
public class LRU extends Algo{

    private ArrayList<Page> lastPages;
    private Queue<Page> queue;


    public LRU(MemorySimulator memorySim, ProgramSimulator programSim) {
        super(memorySim, programSim);
        lastPages = new ArrayList<>();
        queue = new LinkedList<>();

    }

    @Override
    public Algo calc() {
        memorySim.clearCatch();
        int eCount = 0;
        for(Page p : programSim.getProgram()){

            if(lastPages.contains(p)) {
                lastPages.remove(p);
                lastPages.add(p);
            }else {
                lastPages.add(p);
            }
            if(queue.contains(p)) {
                continue;
            }

            queue.add(p);



            Frame frame = memorySim.getFreeFrame();
            if(frame != null ){
                frame.setInSidePage(p);
                continue;
            }else{
                    frame = memorySim.getFormewithPage(lastPages.get(lastPages.size()-(int)memorySim.getNumberOfFrame()-1));
                    queue.remove(frame.getInSidePage());
                    frame.beFree();
                    frame.setInSidePage(p);
                    eCount++;
            }

        }
        this.result.setRsult(programSim.getProgram().size() , eCount , memorySim.getNumberOfFrame());
        return this;
    }


}
