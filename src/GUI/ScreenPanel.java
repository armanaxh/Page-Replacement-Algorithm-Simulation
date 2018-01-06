package GUI;

import GUI.Plot.cartesian.coordinate.CCSystem;
import GUI.util.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by armanaxh on 1/3/18.
 */
public class ScreenPanel extends CCSystem {

    public ScreenPanel() {
        super(-1*Config.X/500+(-1.99), -1*Config.Y/500+(-1.99), Config.X , Config.Y);
        this.setPreferredSize(new Dimension(Config.screenWight,Config.screenHeight));
        this.setLayout(null);
        this.setBackground(new Color(183, 218, 225,100));
        this.setBorder(new EmptyBorder(new Insets(10,10,10,10)));

        JLabel label1 = new JLabel("Page fault");


        label1.setForeground(Color.BLACK);
        label1.setBounds(4,280,100,100);
        label1.setFont(new Font(getFont().getFontName()  , 15 , 15 ));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        this.add(label1);


        JLabel label2 = new JLabel("Number of assigned frames");


        label2.setForeground(Color.black);
        label2.setBounds(400,700,600,100);
        label2.setFont(new Font(getFont().getFontName()  , 15 , 15 ));
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));

        this.add(label2);


        this.setVisible(true);

    }

}
