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

/**
 *
 * @author spenc
 */
public class CheepCheep extends Species{
    
    public CheepCheep(FishTank tank, Image image, String common, String scientific, int speciesIndex, int inTank, int metabolismIndex, double dailyAvgFeedCount, ArrayList<Time> feedTimes) {
        super(tank, image, common, scientific, speciesIndex, inTank, metabolismIndex, dailyAvgFeedCount, feedTimes);
    }
    
}
