/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank;

public class FeedStock {
    double stockRemaining[] = new double[6];
    public FeedStock(){
        for(int s = 0; s<stockRemaining.length; s++){
            stockRemaining[s] = 1500.00; //The initial mass of food available in each food stock is set to 1500 grams.
        }
    }
    
    /**
     * This method should be called from an individual Fish class.
     * Each fish has a metabolism index which determines how much feed they will need per visit.
     * @param reqestedMass the mass to subtract from stockRemaining[speciesIndex]
     */
    public void feed(double reqestedMass, int speciesIndex){
        stockRemaining[speciesIndex]-=reqestedMass;
        
        // Does the stock need refilled?
        
        if(stockRemaining[speciesIndex] <= 0)
        {
            stockRemaining[speciesIndex] = stockRemaining[speciesIndex] + 1500;
        }
    }
}
