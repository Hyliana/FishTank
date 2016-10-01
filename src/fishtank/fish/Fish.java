/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.fish;

import fishtank.classes.Time;

public class Fish{
    Species mySpecies;
    int curSec = -1;
    int burnt = 0;
    int diceRoll;
    double consumption = 0;
    double mass, massFlux;
    Time lastFed;

    public Fish(Species mySpecies){
        this.mySpecies = mySpecies;
        
        massFlux = Math.random() * ((3)*(mySpecies.getMetabolismIndex()*(0.1)));
        diceRoll = (int)(Math.random()*(11));
        
        if(diceRoll%2 == 0)
            mass = 15*mySpecies.getBurnRate()-massFlux;
        else
            mass = 15*mySpecies.getBurnRate()+massFlux;
    }
    
    public double pollMass(){
        return mass;
    }
    
    public void tick(){
        int getSec = mySpecies.getClock().getSecond();
        if(curSec < getSec)
        {
            curSec = getSec;
            burnt+=mySpecies.getBurnRate()/(60*60);
            if(burnt >= mySpecies.getBurnRate())
            {
                diceRoll = (int)(Math.random()*(11));
                double req = (1/105)*mass;
                
                if(diceRoll%2 == 0)
                    req += massFlux;
                else
                    req -= massFlux;

                burnt=0;
                mySpecies.getTank().getFeedStock().feed(req, mySpecies.getSpeciesIndex());
                consumption+=req;
                lastFed = mySpecies.getTank().getTime();
            }
        }
    }
    
    public String getReadableTimeLastFed(){
        return lastFed.getTimestamp();
    }
    
    public double pollConsumptionWeight()
    {
        
        return 0.0;
    }
}
