package GUI;

import GUI.util.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by armanaxh on 1/3/18.
 */
public class MenuPanel extends JPanel {

    public boolean chack[];
    private long frameSize;
    private long memoryCapacityHigh;
    private int memoryCapacityLow;
    private long pageSize;
    private long programVolume;

    private MainFrame f;
    public MenuPanel(MainFrame f) {
        super();
        this.f = f;
        this.setPreferredSize(new Dimension(Config.menuWight,Config.menuHeight));
        this.setBorder(new EmptyBorder(new Insets(10,10,10,10)));
        this.setLayout(new GridLayout(20,1));
        this.setBackground(new Color(23, 49, 53 , 254));
        chack = new boolean[4];

        JPanel pt1 = new JPanel();
        pt1.setBackground(new Color(23, 49, 53 , 254));
        pt1.setLayout(new GridLayout(1,2));

        JCheckBox aCheckBox1 = new JCheckBox("Optimum");
        aCheckBox1.setForeground(Color.lightGray);
        ItemListener itemListener1 = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                AbstractButton abstractButton = (AbstractButton)itemEvent.getSource();
                Color foreground = abstractButton.getForeground();
                Color background = abstractButton.getBackground();
                int state = itemEvent.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    abstractButton.setForeground(background);
                    abstractButton.setBackground(foreground);
                    chack[0] = true;
                }else if (state != ItemEvent.SELECTED) {
                    abstractButton.setForeground(background);
                    abstractButton.setBackground(foreground);
                    chack[0] = false;
                }
            }
        };
        aCheckBox1.addItemListener(itemListener1);
        pt1.add(aCheckBox1);

        JLabel lt1 = new JLabel("[+]");
        lt1.setPreferredSize(new Dimension(4,4));
        lt1.setBackground(Color.green);
        lt1.setForeground(Color.green);

        pt1.add(lt1);
        this.add(pt1);











        JPanel pt2 = new JPanel();
        pt2.setBackground(new Color(23, 49, 53 , 254));
        pt2.setLayout(new GridLayout(1,2));



        JCheckBox aCheckBox2 = new JCheckBox("FIFO");
        aCheckBox2.setForeground(Color.lightGray);
        ItemListener itemListener2 = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                AbstractButton abstractButton = (AbstractButton)itemEvent.getSource();
                Color foreground = abstractButton.getForeground();
                Color background = abstractButton.getBackground();
                int state = itemEvent.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    abstractButton.setForeground(background);
                    abstractButton.setBackground(foreground);
                    chack[1] = true;
                }else if (state != ItemEvent.SELECTED) {
                    abstractButton.setForeground(background);
                    abstractButton.setBackground(foreground);
                    chack[1] = false;
                }
            }
        };
        aCheckBox2.addItemListener(itemListener2);

        pt2.add(aCheckBox2);

        JLabel lt2 = new JLabel("[+]");
        lt2.setPreferredSize(new Dimension(4,4));
        lt2.setBackground(Color.red);
        lt2.setForeground(Color.red);

        pt2.add(lt2);
        this.add(pt2);







        JPanel pt3 = new JPanel();
        pt3.setBackground(new Color(23, 49, 53 , 254));
        pt3.setLayout(new GridLayout(1,2));





        JCheckBox aCheckBox3 = new JCheckBox("LRU");
        aCheckBox3.setForeground(Color.lightGray);
        ItemListener itemListener3 = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                AbstractButton abstractButton = (AbstractButton)itemEvent.getSource();
                Color foreground = abstractButton.getForeground();
                Color background = abstractButton.getBackground();
                int state = itemEvent.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    abstractButton.setForeground(background);
                    abstractButton.setBackground(foreground);
                    chack[2] = true;
                }else if (state != ItemEvent.SELECTED) {
                    abstractButton.setForeground(background);
                    abstractButton.setBackground(foreground);
                    chack[2] = false;
                }
            }
        };
        aCheckBox3.addItemListener(itemListener3);

        pt3.add(aCheckBox3);

        JLabel lt3 = new JLabel("[+]");
        lt3.setPreferredSize(new Dimension(4,4));
        lt3.setBackground(Color.BLUE);
        lt3.setForeground(Color.BLUE);

        pt3.add(lt3);
        this.add(pt3);






        JPanel pt4 = new JPanel();
        pt4.setBackground(new Color(23, 49, 53 , 254));
        pt4.setLayout(new GridLayout(1,2));



        JCheckBox aCheckBox4 = new JCheckBox("Clock");
        aCheckBox4.setForeground(Color.lightGray);

        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                AbstractButton abstractButton = (AbstractButton)itemEvent.getSource();
                Color foreground = abstractButton.getForeground();
                Color background = abstractButton.getBackground();
                int state = itemEvent.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    abstractButton.setForeground(background);
                    abstractButton.setBackground(foreground);
                    chack[3] = true;
                }else if (state != ItemEvent.SELECTED) {
                    abstractButton.setForeground(background);
                    abstractButton.setBackground(foreground);
                    chack[3] = false;
                }
            }
        };
        aCheckBox4.addItemListener(itemListener);


        pt4.add(aCheckBox4);

        JLabel lt4 = new JLabel("[+]");
        lt4.setPreferredSize(new Dimension(4,4));
        lt4.setBackground(Color.MAGENTA);
        lt4.setForeground(Color.MAGENTA);

        pt4.add(lt4);
        this.add(pt4);







        JTextField textField3 = new JTextField();
        InputVerifier verifier3 = new InputVerifier() {
            public boolean verify(JComponent comp) {
                boolean returnValue;
                JTextField textField = (JTextField) comp;
                try {
                    pageSize = Integer.parseInt(textField.getText());
                    returnValue = true;
                } catch (NumberFormatException e) {
                    returnValue = false;
                }
                return returnValue;
            }
        };


        textField3.setInputVerifier(verifier3);

        this.add(new JLabel("Page Size "));
        this.add(textField3, BorderLayout.NORTH);


        JTextField textField4 = new JTextField();
        InputVerifier verifier4 = new InputVerifier() {
            public boolean verify(JComponent comp) {
                boolean returnValue;
                JTextField textField = (JTextField) comp;
                try {
                    programVolume = Integer.parseInt(textField.getText());
                    returnValue = true;
                } catch (NumberFormatException e) {
                    returnValue = false;
                }
                return returnValue;
            }
        };

        textField4.setInputVerifier(verifier4);
        this.add(new JLabel("Program Volume"));
        this.add(textField4, BorderLayout.CENTER);










        JTextField textField1 = new JTextField();
        InputVerifier verifier = new InputVerifier() {
            public boolean verify(JComponent comp) {
                boolean returnValue;
                JTextField textField = (JTextField) comp;
                try {
                    frameSize = Integer.parseInt(textField.getText());
                    returnValue = true;
                } catch (NumberFormatException e) {
                    returnValue = false;
                }
                return returnValue;
            }
        };

        textField1.setInputVerifier(verifier);
        this.add(new JLabel("Frame Size "));
        this.add(textField1, BorderLayout.NORTH);


        JPanel p = new JPanel();
        p.setBackground(new Color(23, 49, 53 , 254));
        p.setLayout(new GridLayout(2,2));



        JTextField textField2 = new JTextField();
        InputVerifier verifier2 = new InputVerifier() {
            public boolean verify(JComponent comp) {
                boolean returnValue;
                JTextField textField = (JTextField) comp;
                try {
                    memoryCapacityLow = Integer.parseInt(textField.getText());
                    returnValue = true;
                } catch (NumberFormatException e) {
                    returnValue = false;
                }
                return returnValue;
            }
        };

        JTextField textField22 = new JTextField();
        InputVerifier verifier22 = new InputVerifier() {
            public boolean verify(JComponent comp) {
                boolean returnValue;
                JTextField textField = (JTextField) comp;
                try {
                    memoryCapacityHigh = Integer.parseInt(textField.getText());
                    returnValue = true;
                } catch (NumberFormatException e) {
                    returnValue = false;
                }
                return returnValue;
            }
        };



        p.add(new JLabel("Memory Capacity low"));
        p.add(new JLabel("Memory Capacity high"));

        textField2.setInputVerifier(verifier2);
        p.add(textField2, BorderLayout.CENTER);
        textField22.setInputVerifier(verifier22);
        p.add(textField22, BorderLayout.CENTER);

        this.add(p);


        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());


        JButton b1 = new JButton(" Simulation ");
        MouseListener mouseListener = new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                int modifiers = mouseEvent.getModifiers();
                if ((modifiers & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
                    MenuPanel.this.drow();
                }
            }
        };

        b1.addMouseListener(mouseListener);

        this.add(b1);


        this.setVisible(true);
    }

    public void drow(){
        f.changeScreen( frameSize,  memoryCapacityLow, memoryCapacityHigh,  pageSize,  programVolume);
    }


}
