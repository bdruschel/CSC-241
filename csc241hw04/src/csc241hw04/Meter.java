/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw04;

import java.util.ArrayList;

/**
 *
 * @author Brandon
 */
public abstract class Meter {
    
    private String ID;
    private String brand;
    public String type;
    
    private Address add;
    private String location;
    
    private ArrayList<MeterReading> mr = new ArrayList<MeterReading>();
    
    public Meter(String i, String b, String t){
        ID = i;
        brand = b;
        type = t;
    }
    
    public String getID(){
        return ID;
    }
    
    public MeterReading[] getReadings(){
        MeterReading[] m = new MeterReading[mr.size()];
        mr.toArray(m); 
        return m;
//        for(int i = 0; i < mr.size(); i++){
//            m[i] = mr.get(i);
//        }
    }
    
    public MeterReading getCurrentReading(){
        if(mr.isEmpty()){
            return null;
        }
        return mr.get(mr.size()-1);
    }
    
    public void addReading(MeterReading m){
        mr.add(m);
    }
    
    public String getBrand(){
        return brand;
    }
    
    public abstract String getType();
    
    public String getLocation(){
        return location;
    }
    
    public Address getAddress(){
        return add;
    }
    
    public void setLocation(Address a, String n){
        add = a;
        location = n;
    }
}
