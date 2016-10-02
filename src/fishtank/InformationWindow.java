/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank;

import fishtank.fish.Species;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class InformationWindow extends JFrame{
    
    Border myBorder = (BorderFactory.createLineBorder(Color.BLACK));
    
    private class IndividualFishPanel extends JPanel{
        public IndividualFishPanel(Species species, int index){
            JPanel myRootPanel = new JPanel();
                myRootPanel.setLayout(new BorderLayout());
                JPanel imagePanel = new JPanel(){
                    public void paintComponent(Graphics g){
                        //super.paint(g);
                        g.drawImage(species.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight()*(5/8), this);
                    }
                };
                imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                imagePanel.add(new JLabel("Fish "+index));
                imagePanel.setBounds(imagePanel.getX(), imagePanel.getY(), imagePanel.getWidth(), imagePanel.getWidth());
                myRootPanel.add(imagePanel, (BorderLayout.NORTH));
                
                JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    timePanel.add(new JLabel(species.getAllFish().get(index).getReadableTimeLastFed()));
                    timePanel.setBorder(myBorder);
                    myRootPanel.add(timePanel);
                JPanel massPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    massPanel.add(new JLabel(species.getAllFish().get(index).pollMass()+"g"));
                    massPanel.setBorder(myBorder);
                    myRootPanel.add(massPanel);
                JPanel fedPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    fedPanel.add(new JLabel(species.getAllFish().get(index).pollDailyAverageConsumptionMass()+"g/day"));
                    fedPanel.setBorder(myBorder);
                    myRootPanel.add(fedPanel);
                    
            this.add(myRootPanel);
        }
    }
    
    public InformationWindow(Species species){
        JPanel rootPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                //super.paint(g);
                setOpaque(true);
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.drawImage(species.getImage(), -300, -200, this);
            }
        };
        
        JPanel westPanel = new JPanel(new BorderLayout());
            JPanel wp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                wp1.add(new JLabel(species.getSpeciesCommonName()), BorderLayout.CENTER);
                wp1.setBorder(myBorder);
                westPanel.add(wp1);
            JPanel wp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                wp2.add(new JLabel(species.getSpeciesScientificName()), BorderLayout.CENTER);
                wp2.setBorder(myBorder);
                westPanel.add(wp2);
            rootPanel.add(westPanel);
            
        JPanel eastPanel = new JPanel(new GridLayout(7,1));
            eastPanel.add(new JLabel());
            eastPanel.add(new JLabel("In Tank: "+species.getCount()));
            eastPanel.add(new JLabel("Burns "+species.getBurnRate()+"g/hour"));
            eastPanel.add(new JLabel("Metabolism Index: "+species.getMetabolismIndex()));
            eastPanel.add(new JLabel("This species feeds "+species.pollDailyConsumptionNumberAverage()+" times per day, on average."));
            eastPanel.add(new JLabel("Average Mass: "+species.pollAverageMass()));
            eastPanel.add(new JLabel());
            eastPanel.setBorder(myBorder);
            rootPanel.add(eastPanel);
            
        JPanel southPanel = new JPanel(new GridLayout(1, species.getCount()));
            IndividualFishPanel ifish[] = new IndividualFishPanel[species.getCount()];
            for(int i=0; i<species.getCount(); i++){
                ifish[i] = new IndividualFishPanel(species, i);
                southPanel.add(ifish[i]);
            }
            southPanel.setBorder(myBorder);
            rootPanel.add(southPanel, BorderLayout.SOUTH);
            
            this.add(rootPanel);
            
            
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        int ww = 644;
        int wh = 600/2;
        int wx = (int)(res.getWidth()/2 - ww/2);
        int wy = (int)(res.getHeight()/2 - wh/2);
        setBounds(wx, wy, ww, wh);
        setTitle("Info on "+species.getSpeciesScientificName());
        setVisible(true);
            
    }
}
