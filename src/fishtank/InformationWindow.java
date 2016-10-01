/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank;

import fishtank.fish.Species;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationWindow extends JFrame{
    public InformationWindow(Species species){
        JPanel rootPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paint(g);
                g.drawImage(species.getImage(), -300, -200, this);
            }
        };
        JPanel westPanel = new JPanel(new BorderLayout());
            JPanel wp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                wp1.add(new JLabel(species.getSpeciesCommonName()), BorderLayout.CENTER);
                westPanel.add(wp1);
            JPanel wp2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                wp2.add(new JLabel(species.getSpeciesScientificName()), BorderLayout.CENTER);
                westPanel.add(wp2);
            rootPanel.add(westPanel);
            
        JPanel eastPanel = new JPanel(new GridLayout(7,1));
            eastPanel.add(new JLabel());
            eastPanel.add(new JLabel("In Tank: "+species.getCount()));
            eastPanel.add(new JLabel("Burns "+species.getBurnRate()+"g/hour"));
            eastPanel.add(new JLabel("Metabolism Index: "+species.getMetabolismIndex()));
            eastPanel.add(new JLabel("This species feeds "+species.pollDailyAverage()+" times per day, on average."));
            eastPanel.add(new JLabel("Average Mass: "+species.pollAverageMass()));
            rootPanel.add(eastPanel);
            
    }
}
