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
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ButtonUI;

public class FishPanelButton extends JButton{
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
        
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        //g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        g.drawImage(myImage, -32, 0, 269, 168, getRootPane().getContentPane().getBackground(), this);
        //g.setColor(Color.WHITE);
        g.drawString(labels[0]+species.getSpeciesCommonName(), 280-92, (2)*(200/5)-(6));
        g.drawString(labels[1]+species.getSpeciesScientificName(), 280-92, (200/2)-(6));
        g.drawString(labels[2]+species.getCount(), 280-92, (3)*(200/5)-(6));
        setOpaque(false);
    }
}
