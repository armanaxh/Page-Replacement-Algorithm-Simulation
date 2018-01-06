package GUI;

import GUI.Plot.cartesian.coordinate.CCPolygon;
import GUI.Plot.cartesian.coordinate.CCSystem;
import GUI.util.Config;
import controller.Controller;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by armanaxh on 1/3/18.
 */
public class MainFrame extends JFrame{

    private CCSystem screenPanel;
    private  MenuPanel menuPanel;

    public MainFrame() throws HeadlessException{
        super("Page Replacement Algorithm Simulation");
        this.setSize( Config.wight , Config.height );
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        this.screenPanel = new ScreenPanel();
        this.menuPanel = new MenuPanel(this);

        this.add(screenPanel,BorderLayout.CENTER);
        this.add(menuPanel,BorderLayout.EAST);

        this.setVisible(true);
    }
    public void changeScreen(long frameSize,int memoryCapacityLow , long memoryCapacityHigh, long pageSize, long programVolume){
        calc(frameSize, memoryCapacityLow, memoryCapacityHigh , pageSize, programVolume);
    }

    public void calc(long frameSize, int memoryCapacityLow , long memoryCapacityHigh, long pageSize, long programVolume){
        if(false
                || frameSize == 0
                || memoryCapacityLow == 0
                || memoryCapacityHigh == 0
                || pageSize == 0
                || programVolume == 0
                ){
            return;
        }


        ArrayList<Pair<Integer,Integer>> eFifo = new ArrayList<>();
        ArrayList<Pair<Integer,Integer>> eLRU = new ArrayList<>();
        ArrayList<Pair<Integer,Integer>> eOPT = new ArrayList<>();
        ArrayList<Pair<Integer,Integer>> clock = new ArrayList<>();

        for(int i = memoryCapacityLow ; i<=memoryCapacityHigh ; i+= frameSize) {
            Controller c = new Controller(frameSize, i, pageSize, programVolume).calc();
            eFifo.add(new Pair((int)(i/frameSize), c.getResults()[0].getPageError()));
            eLRU.add(new Pair((int)(i/frameSize), c.getResults()[1].getPageError()));
            eOPT.add(new Pair((int)(i/frameSize), c.getResults()[2].getPageError()));
            clock.add(new Pair((int)(i/frameSize), c.getResults()[3].getPageError()));
        }
        if(false
                || eFifo.isEmpty()
                || eLRU.isEmpty()
                || eOPT.isEmpty()
                || clock.isEmpty()
                )
            return;


        Config.X = (int)memoryCapacityHigh+5;
        Config.Y = eFifo.get(0).getValue()+100;
        screenPanel.setVisible(false);
        this.remove(screenPanel);
        this.screenPanel = new ScreenPanel();
        this.add(screenPanel,BorderLayout.CENTER);


        if(menuPanel.chack[0])
            drow(eFifo , 0);
        if(menuPanel.chack[1])
            drow(eLRU , 1);
        if(menuPanel.chack[2])
            drow(eOPT, 2 );
        if(menuPanel.chack[3])
            drow(clock , 3);
    }

    public void drow(ArrayList<Pair<Integer,Integer>> list , int type){


        for(int i=0 ; i<list.size()-1 ; i++) {
            double xpoints[] = {
                    list.get(i).getKey().doubleValue(), list.get(i + 1).getKey().doubleValue()
            };
            double ypoints[] = {
                    list.get(i).getValue().doubleValue(), list.get(i + 1).getValue().doubleValue()
            };
            CCPolygon p = null;
            if (type == 0)
                 p = new CCPolygon(xpoints, ypoints, Color.red, Color.red, new BasicStroke(2f));
            else if(type == 1){
                p = new CCPolygon(xpoints, ypoints, Color.BLUE, Color.BLUE, new BasicStroke(2f));
            }else if(type == 2 ){
                p = new CCPolygon(xpoints, ypoints, Color.GREEN, Color.GREEN, new BasicStroke(2f));
            }else if(type == 3 ){
                p = new CCPolygon(xpoints, ypoints, Color.ORANGE, Color.orange, new BasicStroke(2f));
            }

            if(p != null)
                screenPanel.add(p);
        }

    }

}
