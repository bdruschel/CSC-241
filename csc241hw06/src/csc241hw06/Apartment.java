/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

/**
 *
 * @author Brandon
 */
public class Apartment extends Address {
    
    String unit;
    
    public Apartment(String s, int n, String z, String t, String u) {
        super(s, n, z, t);
        unit = u;
    }

    @Override
    public String getType() {
        return "apartment";
    }
    
    public void setUnit(String u){
        unit = u;
    }
    
    public String getUnit(){
        return unit;
    }
}
