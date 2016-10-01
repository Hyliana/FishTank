/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.fish;

public class Fish{
    int mySpeciesIndex;
    
    
    public Fish(Species mySpecies){
        mySpeciesIndex = mySpecies.getSpeciesIndex();
    }
    
    /**
     * This method directly provides the answer to objective 1:
     * How much was each individual fish fed per day on average?
     * @return 
     */
    public double pollConsumptionWeight()
    {
        
        return 0.0;
    }
}
