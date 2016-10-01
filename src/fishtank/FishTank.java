/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank;

import fishtank.classes.Clock;
import fishtank.ui.FishPanelButton;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import fishtank.classes.Time;
import fishtank.fish.Species;

/**
 *
 * @author spenc
 */
public class FishTank extends JFrame implements ActionListener{
    
    
    int typesOfFish = 6;
    FeedStock feed = new FeedStock();
    Species[] species = new Species[typesOfFish];
    int[] speciesCount = new int[typesOfFish];
    Image[] speciesImage;
    static int wx, wy, ww, wh;
    public boolean canTick = true;
    Clock clock;
    Time simulate24HourClock = new Time(0,0,0);
    

    public FishTank(){
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        ww = 800;
        wh = 600;
        wx = (int)(res.getWidth()/2 - ww/2);
        wy = (int)(res.getHeight()/2 - wh/2);
        setBounds(wx, wy, ww, wh);
        setTitle("Fishtank A - Room 428C, Old Main");
        setVisible(true);
        
        AboutWindow w1 = new AboutWindow();
        w1.setBounds(w1.wx, w1.wy, w1.ww, w1.wh);
        w1.setVisible(true);
        w1.requestFocus();
        
        //Initialize clock
        clock = new Clock(this);
        
        for(int i=0; i<typesOfFish; i++) //Load fish images into program, and determine how many fish will be present for each species. (RNG)
        {
            speciesImage[i] = Toolkit.getDefaultToolkit().getImage("../res/fish"+i+".png");
            speciesCount[i] = (int)(Math.random()*6);
        }
        
        //I love the feeling of initalizing a new species... I'm more or less the God of this FishTank.java.
        species[0] = new Species(this, clock, speciesImage[0], "Cheep Cheep", "Cheepus Purpuram", 0, speciesCount[0], 16);
        
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel northClockPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel northInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel mainPanel = new JPanel(new GridLayout(3,2));
            FishPanelButton[] fishButton = new FishPanelButton[6];
            for(int i = 0; i<fishButton.length; i++){
                fishButton[i] = new FishPanelButton(species[i], Time.getFalseTime());
            }
        
    }
    
    public static void main(String[] args) {
        FishTank f1 = new FishTank();
        f1.setBounds(wx, wy, ww, wh);
        f1.setTitle("Fishtank A - Room 428C, Old Main");
        f1.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    public void tick(){
        for(int i=0; i<species.length; i++){
            for(int j = 0; j<species[i].inTank; j++)
            {
                species[i].getAllFish().get(species[i].inTank).tick();
            }
        }
    }
    
    public FeedStock getFeedStock(){
        return feed;
    }
    
    public Time getTime(){
        return new Time(simulate24HourClock);
    }
    
    //INNER CLASS AboutWindow
    class AboutWindow extends JFrame implements ActionListener
    {

        JButton closeButton = new JButton("Okay!");
        JLabel[] iLabel = new JLabel[3];
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            int wx, wy, ww, wh;
            
        
        public AboutWindow(){
            ww = 400;
            wh = 128;
            wx = (int)(res.getWidth()/2 - ww/2);
            wy = (int)(/*res.getHeight()/2 - wh/2*/ 64);
             iLabel[0] = new JLabel("This program generates its own unique data for each");
             iLabel[1] = new JLabel("species of fish, since no real data or peripheral is");
             iLabel[2] = new JLabel("attached. Let me know where improvement can be made!");
            JPanel northPanel = new JPanel();
            JPanel southPanel = new JPanel();
            northPanel.setLayout(new GridLayout(3,1));
            
            this.add(northPanel);
                for(int i=0; i<3; i++){
                    northPanel.add(iLabel[i], BorderLayout.CENTER);
                }
            this.add(southPanel, BorderLayout.SOUTH);
                southPanel.add(closeButton);
                closeButton.addActionListener(this);
                
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
            
        }
        
        public void actionPerformed(ActionEvent event) {
            this.dispose();
        }
    }
    
}
