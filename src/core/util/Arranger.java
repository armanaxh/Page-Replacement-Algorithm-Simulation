package core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;

import org.uncommons.maths.number.NumberGenerator;
import org.uncommons.maths.random.GaussianGenerator;

/**
 * Created by armanaxh on 1/3/18.
 */
public class Arranger {
    private ArrayList<Long> temp;
    private NumberGenerator<Double> noise;
    private long numberOfElement;
    private Random rand;
    private double mean;
    private double sd;

    public Arranger(long  numberOfElement , long mean,long sd) {
        this.mean = mean;
        this.sd = sd;
        this.numberOfElement = numberOfElement;
        this.rand = new Random();
        this.noise = new GaussianGenerator(mean, sd, rand);
    }

    public ArrayList<Long> calc(){
        this.temp = new ArrayList<>();
        Hashtable<Long,Long> possibility = new Hashtable();
        for(long i=0 ; i<numberOfElement ; i++) {
            int t = Math.abs(this.noise.nextValue().intValue())%1000+5;
            possibility.put(new Long(i),new Long(t));
        }
        for(long i=0 ; i<numberOfElement ; i++){
            int t = possibility.get(i).intValue();
            while(t>0){
                t--;
                temp.add(new Long(i));
            }
        }
        Collections.shuffle(temp);

        return temp;
    }
}
