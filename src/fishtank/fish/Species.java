/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.fish;

import fishtank.classes.Time;
import java.awt.Image;
import java.util.ArrayList;

public abstract class Species {
    String scientificName;
    String commonName;
    int instances = 0;
    double avgDailyFeedCount;
    Image myImage;
    
    public Species(Image image, String common, String scientific, int inTank, double dailyAvgFeedCount){
        commonName = common;
        scientificName = scientific;
        instances = inTank;
        avgDailyFeedCount = dailyAvgFeedCount;
        myImage = image;
    }
    
    public Image getImage(){
        return myImage;
    }
}
