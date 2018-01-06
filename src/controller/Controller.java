package controller;

import Algorithm.*;
import core.MemorySimulator;
import core.ProgramSimulator;


/**
 * Created by armanaxh on 1/3/18.
 */
public class Controller {

    private long frameSize;
    private long memoryCapacity;
    private long pageSize;
    private long programVolume;

    private MemorySimulator memorySim;
    private ProgramSimulator programSim;

    private Result results[];

    public Controller(long frameSize, long memoryCapacity, long pageSize, long programVolume) {
        this.frameSize = frameSize;
        this.memoryCapacity = memoryCapacity;
        this.pageSize = pageSize;
        this.programVolume = programVolume;
        this.results = new Result[4];
        init();
    }

    private void init(){
        this.programSim = new ProgramSimulator(pageSize , programVolume);
        this.memorySim = new MemorySimulator(frameSize , memoryCapacity);
    }

    public Controller calc(){
        results[0]  = new FIFO(memorySim,programSim).calc().getResult();
        results[1]  = new LRU(memorySim,programSim).calc().getResult();
        results[2] = new OPT(memorySim,programSim).calc().getResult();
        results[3] = new Clock(memorySim,programSim).calc().getResult();
        return this;
    }

    public Result[] getResults() {
        return results;
    }
}
