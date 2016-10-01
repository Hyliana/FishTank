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

public class Species {
    FishTank tank;
    String scientificName;
    String commonName;
    int inTank;
    Image myImage;
    int speciesIndex;
    int metabolismIndex;
    ArrayList<Time> feedTimes = new ArrayList<>();
    ArrayList<Double> speciesWideAverageFeedForDay = new ArrayList<>();
    ArrayList<Fish> speciesFish;
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
     * @param metabolismIndex metabolismIndex is a rating from 1 to 100  describing the rate of digestion for this species.
     * @param feedTimes 
     */
    public Species(FishTank tank, Image image, String common, String scientific, int speciesIndex, int inTank, int metabolismIndex){
        this.tank = tank;
        myImage = image;
        commonName = common;
        scientificName = scientific;
        this.speciesIndex = speciesIndex;
        this.inTank = inTank;
            speciesFish = new ArrayList();
        this.metabolismIndex = metabolismIndex;
    }
    
    /**
     * This method directly provides the answer to objective 2:
     * ~How many times per day are fishes fed on average? Group by species.~
     * @return returns a double representing how many times per day the fish in this species feed per day (average value)
     */
    public double pollDailyAverage(){
        //double average
        //for(int
        return 0.0;
    }
    
    public int getSpeciesIndex(){
        return speciesIndex;
    }
    
    public Image getImage(){
        return myImage;
    }
    
    public void commitDataForDay(){
        double sum = 0;
        for(int i = 0; i<speciesFish.size(); i++){
            sum += speciesFish.get(i).pollConsumptionWeight();
        }
        speciesWideAverageFeedForDay.add((sum/speciesFish.size()));
    }
}
