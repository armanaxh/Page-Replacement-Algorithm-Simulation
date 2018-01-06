package core;

import core.object.Page;
import core.util.Arranger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by armanaxh on 1/2/18.
 */
public class ProgramSimulator {

    private long numberOfPage;
    private long pageSize;
    private long programVolume;
    private ArrayList<Page> pages;
    private ArrayList<Page> program;
    private final int PROGRAM_MEAN = 8;
    private final int SD = 50;



    public ProgramSimulator(long pageSize, long programVolume) {
        this.pageSize = pageSize;
        this.programVolume = programVolume;
        this.numberOfPage = programVolume/pageSize;
        this.pages = new ArrayList<>();
        this.program = new ArrayList<>();

        init();
        initArrangePages();
    }

    private void init(){
        for(long i=0 ; i<numberOfPage ; i++){
            this.pages.add(new Page(i));
        }
    }
    private void initArrangePages(){
        Arranger arranger = new Arranger(numberOfPage , PROGRAM_MEAN , SD );
        List<Long> list = arranger.calc();
        for (Long t : list) {
            program.add(pages.get(t.intValue()));
        }
    }

    public long getNumberOfPage() {
        return numberOfPage;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public ArrayList<Page> getProgram() {
        return program;
    }

}
