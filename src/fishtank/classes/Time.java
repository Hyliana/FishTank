/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishtank.classes;

public class Time {
    int hour = 0;
    int minute = 0;
    int second = 0;
    
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public String getTimeString(){
        return "("+hour+":"+minute+":"+second+")";
    }
}
