/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07;

import java.time.LocalDateTime;

/**
 *
 * @author Brandon
 */
public class MeterReading {
    
    private LocalDateTime time;
    private Meter met;
    private double reading;
    
    private String flag;
    
    public MeterReading(double r, LocalDateTime t, String f, Meter m){
        time = t;
        met = m;
        flag = f;
        reading = r;
    } 
    
    public double getReading(){
        return reading;
    }
    
    public LocalDateTime getDateTime(){
//        LocalDateTime ldt = LocalDateTime.now();
//        return ldt;
        return time;
    }
    
    public String getFlag(){
         return flag;
    }
    
    public Meter getMeter(){
        return met;
    }
    
}
    