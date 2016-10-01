/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.classes;

import java.text.DecimalFormat;

public class Time {
    int hour = 0;
    int minute = 0;
    int second = 0;
    DecimalFormat f = new DecimalFormat("##");
    
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public String getTimestamp(){
        return f.format(hour)+":"+f.format(minute)+":"+f.format(second);
    }
    
    public static Time getFalseTime(){
        return new Time(0,0,0);
    }
}
