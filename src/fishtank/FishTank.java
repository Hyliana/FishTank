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
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author spenc
 */
public class FishTank extends JFrame implements ActionListener{
    
    
    int typesOfFish = 6;
    FeedStock feed = new FeedStock();
    Species[] species = new Species[typesOfFish];
    int[] speciesCount = new int[typesOfFish];
    Image[] speciesImage = new Image[typesOfFish];
    FishPanelButton[] fishButton;
    static int wx, wy, ww, wh;
    public boolean canTick = true;
    Clock clock;
    Time simulate24HourClock = new Time(this, 0,0,0);
    

    public FishTank(){
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        ww = 975;
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
            try{
            speciesImage[i] = new ImageIcon(this.getClass().getResource("../res/fish"+i+".png")).getImage();
            }
            catch(NullPointerException e){
                System.out.println("Unable to open file!");
            }
            speciesCount[i] = (int)(1+Math.random()*8);
        }
        
        //I love the feeling of initalizing a new "species"... I'm more or less the God of this FishTank.java.
        species[0] = new Species(this, clock, speciesImage[0], "Cheep Cheep", "Cheepus Purpuram", 0, speciesCount[0], 62);
        species[1] = new Species(this, clock, speciesImage[1], "Clown Fish", "Amphiprioninae", 1, speciesCount[1], 30);
        species[2] = new Species(this, clock, speciesImage[2], "Palette Surgeonfish", "Paracanthurus Hepatus", 2, speciesCount[2], 40);
        species[3] = new Species(this, clock, speciesImage[3], "Flounder", "Pseudopleuronectes Americanus", 3, speciesCount[3], 73);
        species[4] = new Species(this, clock, speciesImage[4], "Magikarp", "Kyoto Koiking", 4, speciesCount[4], 24);
        species[5] = new Species(this, clock, speciesImage[5], "Fishbone", "Cheepus Mortis", 5, speciesCount[5], 1);
        
        simulateTime();
        
        JPanel northPanel = new JPanel(new BorderLayout());
            JPanel northClockPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                northClockPanel.add(new JLabel(new SimpleDateFormat("hh:mm").format(new Date())));
                northPanel.add(northClockPanel, BorderLayout.NORTH);
            JPanel northInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                northInfoPanel.add(new JLabel("Click on a fish for more detailed information."));
                northPanel.add(northInfoPanel, BorderLayout.SOUTH);
        JPanel mainPanel = new JPanel(new GridLayout(3,2));
            fishButton = new FishPanelButton[typesOfFish];
            for(int i = 0; i<fishButton.length; i++){
                fishButton[i] = new FishPanelButton(species[i], new Time(this, 0,0,0));
                fishButton[i].addActionListener(this);
                mainPanel.add(fishButton[i]);
                //mainPanel.add(new JButton(String.valueOf(i)));
            }
            
        JPanel rootPanel = new JPanel(new BorderLayout());
        this.add(rootPanel);
        rootPanel.add(northPanel, (BorderLayout.NORTH));
        rootPanel.add(mainPanel, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /////////////////////////////////////////
    //          Main                       //
    /////////////////////////////////////////
    
    public static void main(String[] args) {
        FishTank f1 = new FishTank();
        f1.setBounds(wx, wy, ww, wh);
        f1.setTitle("Fishtank A - Room 428C, Old Main");
        f1.setVisible(true);
    }
    
    /////////////////////////////////////////
    //          ActionPerformed            //
    /////////////////////////////////////////
    
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        for(int i=0; i<fishButton.length; i++){
            if(src == fishButton[i])
            {
                InformationWindow infoWindow = new InformationWindow(species[i]);
            }
        }
    }
    
    public void simulateTime(){
        int fakeSeconds = 0;

        while(fakeSeconds< (60*60*24*7))
        {
            simulate24HourClock.tick();
            clock.tick();
            for(int i=0; i<species.length; i++){
                for(int j = 0; j<species[i].getAllFish().size(); j++)
                {
                    species[i].getAllFish().get(j).tick();
                }
            }
            fakeSeconds++;
        }
    }
    
    public FeedStock getFeedStock(){
        return feed;
    }
    
    public Time getTime(){
        return new Time(this, simulate24HourClock);
    }

    public int getSpeciesCount() {
        return species.length;
    }
    
    public Species getSpecies(int index){
        return species[index];
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
                
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
            
        }
        
        public void actionPerformed(ActionEvent event) {
            this.dispose();
        }
    }
    
}
