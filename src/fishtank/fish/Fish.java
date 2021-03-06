/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.fish;

import fishtank.classes.Time;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Fish{
    Species mySpecies;
    int curSec = -1;
    double burnt = 0;
    int diceRoll;
    double consumption = 0;
    double mass, massFlux;
    double timesFedToday = 0;
    ArrayList<Double> timesFedOnDay = new ArrayList<>();
    ArrayList<Double> consumptionMassOnDay = new ArrayList<>();
    Time lastFed;

    public Fish(Species mySpecies){
        this.mySpecies = mySpecies;
        
        lastFed = new Time(mySpecies.getTank(), 0,0,0);
        
        massFlux = Math.random() * ((3)*(mySpecies.getMetabolismIndex()*(0.1)));
        diceRoll = (int)(Math.random()*(11));
        
        if(diceRoll%2 == 0)
            mass = mySpecies.getMassConstant()*mySpecies.getBurnRate()-massFlux;
            
        else
           mass = mySpecies.getMassConstant()*mySpecies.getBurnRate()+massFlux;
    }
    
    public double getMass(){
        return mass;
    }
    
    public void tick(){
        int getSec = mySpecies.getClock().getSecond();
        if(curSec < getSec)
        {
            curSec = getSec;
            
            burnt += (mySpecies.getBurnRate()/(60*60));
            if(burnt >= mySpecies.MASS_CONSTANT)
            {
                diceRoll = (int)(Math.random()*(11));
                double req = mass/(mySpecies.MASS_CONSTANT);
                
                if(diceRoll%2 == 0)
                    req += massFlux/10;
                else
                    req -= massFlux/10;

                burnt=0;
                mySpecies.getTank().getFeedStock().feed(req, mySpecies.getSpeciesIndex());
                consumption+=req;
                timesFedToday++;
                //System.out.println("a species["+mySpecies.getSpeciesIndex()+"] consumed "+req+"g just now!");
                lastFed = mySpecies.getTank().getTime();
            }
        }
    }
    
    public String getReadableTimeLastFed(){
        return lastFed.getTimestamp();
    }
    
    public void commitDailyData(){
        consumptionMassOnDay.add(consumption);
        timesFedOnDay.add(timesFedToday);
        timesFedToday = 0;
        consumption=0;
    }
    
    public ArrayList<Double> getFeedCountArray(){
        return timesFedOnDay;
    }
    
    public int getFeedArrayLength(){
        return timesFedOnDay.size();
    }
    
    /**
     * This method directly provides the answer to objective 1: How much does each fish eat individually?
     * @return 
     */
    public double pollDailyAverageConsumptionMass()
    {
        double sum = 0;
        for(int i = 0; i<consumptionMassOnDay.size(); i++)
        {
            sum += consumptionMassOnDay.get(i);
        }
        return (sum/consumptionMassOnDay.size()); //THE PROBLEM
    }
}
