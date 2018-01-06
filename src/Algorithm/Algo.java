package Algorithm;

import controller.Result;
import core.MemorySimulator;
import core.ProgramSimulator;

/**
 * Created by armanaxh on 1/3/18.
 */
public abstract class Algo {
    protected MemorySimulator memorySim;
    protected ProgramSimulator programSim;
    protected Result result;

    public Algo(MemorySimulator memorySim, ProgramSimulator programSim) {
        this.memorySim = memorySim;
        this.programSim = programSim;
        this.result = new Result();
    }

    public abstract Algo calc();

    public  Result getResult(){
        return this.result;
    }
}
