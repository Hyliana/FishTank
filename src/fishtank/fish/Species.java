/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.fish;

import fishtank.FishTank;
import fishtank.classes.Clock;
import fishtank.classes.Time;
import java.awt.Image;
import java.util.ArrayList;

public class Species {
    FishTank tank;
    String scientificName;
    String commonName;
    public int inTank;
    Image myImage;
    int speciesIndex;
    int metabolismIndex;
    ArrayList<Time> feedTimes = new ArrayList<>();
    ArrayList<Double> speciesWideAverageFeedForDay = new ArrayList<>();
    ArrayList<Fish> speciesFish = new ArrayList<>();
    Clock clock;
    double burnRate;
    /**
     * Species is an abstract class meant to provide a 
     * parent class for each of the six species of fish
     * so that the info can be easily read universally.
     * @param tank The FishTank in which this species (and thus its fish) exist.
     * @param clock The universal "clock" for the program - keeps track of time passed.
     * @param image The image that will be displayed for the fish.
     * @param common The common name of the species of fish.
     * @param scientific The scientific name of the species of fish.
     * @param speciesIndex FishTank will assign this number - serves as a global species identifier.
     * @param inTank The count of how many of that species of fish exist inside FishTank
     * @param metabolismIndex metabolismIndex is a rating from 1 to 100  describing the rate of digestion for this species.
     */
    public Species(FishTank tank, Clock clock, Image image, String common, String scientific, int speciesIndex, int inTank, int metabolismIndex){
        this.tank = tank;
        this.clock = clock;
        myImage = image;
        commonName = common;
        scientificName = scientific;
        this.speciesIndex = speciesIndex;
        this.inTank = inTank;
            for(int i=0; i<inTank; i++)
            {
                speciesFish.add(new Fish(this));
            }
        this.metabolismIndex = metabolismIndex;
        this.burnRate=.125*metabolismIndex;
    }
    
    /**
     * This method directly provides the answer to objective 2: How many times a day does a fish species feed?
     * ~How many times per day are fishes fed on average? Group by species.~
     * @return returns a double representing how many times per day the fish in this species feed per day (average value)
     */
    public double pollDailyConsumptionNumberAverage(){
        double sum = 0;
        for(int i = 0; i<speciesWideAverageFeedForDay.size(); i++){
            sum += speciesWideAverageFeedForDay.get(i);
        }
        return (sum/speciesWideAverageFeedForDay.size());
    }
    
    public double pollAverageMass(){
          double sum = 0;
        for(int i = 0; i<speciesFish.size(); i++){
            sum += speciesFish.get(i).pollMass();
        }
        return (sum/speciesFish.size());
    }
    
    public String getSpeciesCommonName(){
        return commonName;
    }
    
    public String getSpeciesScientificName(){
        return scientificName;
    }
    
    public int getCount(){
        return inTank;
    }
    
    public FishTank getTank(){
        return tank;
    }
    
    public int getMetabolismIndex(){
        return metabolismIndex;
    }
    
    public int getSpeciesIndex(){
        return speciesIndex;
    }
    
    public Image getImage(){
        return myImage;
    }
    
    public Clock getClock(){
        return clock;
    }
    
    public ArrayList<Fish> getAllFish(){
        return speciesFish;
    }
    
    public double getBurnRate(){
        return burnRate;
    }
    
    public void commitDataForDay(){
        double sum = 0;
        for(int i = 0; i<speciesFish.size(); i++){
            sum += speciesFish.get(i).pollDailyAverageConsumptionMass();
        }
        speciesWideAverageFeedForDay.add((sum/speciesFish.size()));
    }
}
