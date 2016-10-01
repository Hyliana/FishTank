/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.fish;

import fishtank.FishTank;
import fishtank.classes.Time;
import java.awt.Image;
import java.util.ArrayList;

public abstract class Species {
    String scientificName;
    String commonName;
    int instances = 0;
    double avgDailyFeedCount;
    Image myImage;
    
    /**
     * Species is an abstract class meant to provide a 
     * parent class for each of the six species of fish
     * so that the info can be easily read universally.
     * @param tank The FishTank in which this species (and thus its fish) exist.
     * @param image The image that will be displayed for the fish.
     * @param common The common name of the species of fish.
     * @param scientific The scientific name of the species of fish.
     * @param speciesIndex FishTank will assign this number - serves as a global species identifier.
     * @param inTank The count of how many of that species of fish exist inside FishTank
     * @param metabolismIndex
     * @param dailyAvgFeedCount
     * @param feedTimes 
     */
    public Species(FishTank tank, Image image, String common, String scientific, int speciesIndex, int inTank, int metabolismIndex, double dailyAvgFeedCount,ArrayList<Time> feedTimes){
        commonName = common;
        scientificName = scientific;
        instances = inTank;
        avgDailyFeedCount = dailyAvgFeedCount;
        myImage = image;
    }
    
    /**
     * This method directly provides the answer to objective 2:
     * ~How many times per day are fishes fed on average? Group by species.~
     * @return returns a double representing how many times per day the fish in this species feed per day (average value)
     */
    public double pollDailyAverage(){
        
        return 0.0;
    }
    
    public Image getImage(){
        return myImage;
    }
}
