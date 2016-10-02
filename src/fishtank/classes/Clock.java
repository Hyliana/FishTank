/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.classes;

import fishtank.FishTank;

public class Clock {
    //long initialMS = System.currentTimeMillis();
    long milliseconds = 0;
    int seconds = 0;
    FishTank controller;
    
    public Clock(FishTank controller){
       this.controller = controller; 
    }
    
    public int getSecond(){
        return seconds;
    }
    
    public void tick(){
        if(controller.canTick)
        {
            seconds++;
            
            //I didn't program in a timer, since I figured you wouldn't wait for midnight to
            //check to see if it updated continually. If you got this far into my code,
            //awesome! Sorry there's not an implementation of swing.Timer, but I really
            //didn't want to implement it for a proof of concept application.
            //
            //  Spencer
        }
        
    }
}
