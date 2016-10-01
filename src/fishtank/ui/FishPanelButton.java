/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.ui;

import fishtank.classes.Time;
import fishtank.fish.Species;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FishPanelButton extends JPanel{
    Image myImage;
    Species species;
    String[] labels = {"Common Name: ", "Scientific Name: ", "In Tank: "};
    
    
    public FishPanelButton(Species species, Time lastFed){
        this.setBackground(Color.DARK_GRAY);
        this.species = species;
        myImage = species.getImage();
        
        JLabel[] infoLabels = {
            new JLabel(labels[0]+species.getSpeciesCommonName()), 
            new JLabel(labels[1]+species.getSpeciesScientificName()), 
            new JLabel(labels[2]+species.getCount())
        };
        
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel(new GridLayout(3,1));
            for(int i=0; i<infoLabels.length; i++){
                eastPanel.add(infoLabels[i]);
            }
            
            JPanel rootPanel = new JPanel();
            rootPanel.add(westPanel, (BorderLayout.WEST));
            rootPanel.add(eastPanel, BorderLayout.EAST);
            this.add(rootPanel);
            invalidate();
            validate();
        
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(myImage, this.getX(), this.getY()+16, 269, 168, Color.DARK_GRAY, this);
    }
}
