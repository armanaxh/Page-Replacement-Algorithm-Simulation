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
public class OPT extends Algo{

    private Queue<Page> queue;


    public OPT(MemorySimulator memorySim, ProgramSimulator programSim) {
        super(memorySim, programSim);
        this.queue = new LinkedList<>();
    }

    @Override
    public Algo calc() {
        memorySim.clearCatch();
        int eCount = 0;
        Page p = null;
        ArrayList<Page> prog = programSim.getProgram();
        for(int i=0  ; i<(int)prog.size() ; i++ ){
            p = prog.get(i);
            if(queue.contains(p)) {
                continue;
            }

            queue.add(p);

            Frame frame = memorySim.getFreeFrame();
            if(frame != null ){
                frame.setInSidePage(p);
                continue;
            }else{
                LinkedList<Page> temp = new LinkedList<>();
                temp.addAll(queue);
                int j = 0;
                while(j+i < prog.size()){
                    Page l = prog.get(j+i);
                    if(temp.contains(l)) {
                        temp.remove(l);
                    }
                    if(temp.size() == 1){
                        Frame f = temp.get(0).getIsInsideFrame();
                        queue.remove(f.getInSidePage());
                        f.beFree();
                        f.setInSidePage(p);
                        temp.clear();
                        break;
                    }
                    j++;
                }
                if(!temp.isEmpty()){
                    Frame f = temp.get(0).getIsInsideFrame();
                    queue.remove(f.getInSidePage());
                    f.beFree();
                    f.setInSidePage(p);
                    temp.clear();
                }
                eCount++;
            }

        }
        this.result.setRsult(programSim.getProgram().size() , eCount , memorySim.getNumberOfFrame());
        return this;
    }
}
