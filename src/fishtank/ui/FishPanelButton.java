/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.ui;

import fishtank.classes.Time;
import fishtank.fish.Species;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JButton;

public class FishPanelButton extends JButton{
    Image myImage;
    Species species;
    
    public FishPanelButton(Species species, Time lastFed){
        this.species = species;
        myImage = species.getImage();
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(myImage, this.getX(), this.getY(), 269, 168, Color.DARK_GRAY, this);
    }
}
