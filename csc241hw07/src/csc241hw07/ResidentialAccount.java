/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07;

/**
 *
 * @author Brandon
 */
public class ResidentialAccount extends Account implements Constants {

    public ResidentialAccount(String an, Customer c) {
        super(an, c);
    }

    @Override
    public void updateBalance(){
        double inc = 0;
            for(Address a : add){
                if(a.getType().equals("house") || a.getType().equals("apartment")){
                    for(Meter b : a.getMeters()){
                        for(MeterReading mr : b.getReadings()){
                            //System.out.println("getReading(): " + mr.getReading());
                            inc += mr.getReading() * residentialUnitRate; 
                        }
                    }
                }
            }
        balance = inc;
    }
    
    
    
}
