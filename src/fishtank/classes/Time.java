/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.classes;

import fishtank.FishTank;
import java.text.DecimalFormat;

public class Time {
    int hour = 0;
    int minute = 0;
    int second = 0;
    FishTank tank;
    DecimalFormat f = new DecimalFormat("##");
    
    public Time(FishTank tank, int hour, int minute, int second){
        this.tank = tank;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public Time(FishTank tank, Time t){
        this.tank = tank;
        this.hour = t.hour;
        this.minute = t.minute;
        this.second = t.second;
    }
    
    public String getTimestamp(){
        return f.format(hour)+":"+f.format(minute)+":"+f.format(second);
    }
    
    public Time getTime(){
        return new Time(tank, hour, second, minute);
    }
    
    public Time getFalseTime(){
        return new Time(null ,0,0,0);
    }

    public void tick() {
        if(second<60)
        {
            second++;
        }
        else
        {
            second=0;
            if(minute<60)
            {
                minute++;
            }
            else
            {
                minute=0;
                if(hour<24)
                {
                    hour++;
                }
                else
                {
                    hour=0;
                    for(int curSpecies = 0; curSpecies<tank.getSpeciesCount(); curSpecies++){
                        for(int curFish = 0; curFish<tank.getSpecies(curSpecies).getAllFish().size(); curFish++)
                        {
                            tank.getSpecies(curSpecies).getAllFish().get(curFish).commitDailyData();
                            tank.getSpecies(curSpecies).commitDataForDay();
                        }
                    }
                }
            }
        }
    }
}
