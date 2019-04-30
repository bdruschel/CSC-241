/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw04;

/**
 *
 * @author Brandon
 */
public class PushMeter extends Meter{
    
    int interval;

    public PushMeter(String i, String b, String t) {
        super(i, b, t);
    }

    @Override
    public String getType() {
        return "push";
    }
    
    public int getInterval(){
        return interval;
    }
    
    public void setInterval(int s){
        interval = s;
    }
    
}
