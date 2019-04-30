/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw02;

import java.util.ArrayList;

/**
 *
 * @author Brandon
 */
public class Address {
    
    private String street;
    private int number;
    private String zipCode;
    private String type;
    private Account acc;
    
    private ArrayList<Meter> met = new ArrayList<Meter>();
    
    
    public Address(String s, int n, String z, String t){
        street = s;
        number = n;
        zipCode = z;
        type = t;
    }
    
    public String getStreet(){
        return street;
    }
    
    public int getNumber(){
        return number;
    }
    
    public String getZipCode(){
        return zipCode;
    } 
    
    public String getType(){
        return type;
    }
    
    public Meter[] getMeters(){
        Meter[] m = new Meter[met.size()];
//        for(int i = 0; i < met.size(); i++){
//            m[i] = met.get(i);
//        }
        met.toArray(m); 
        return m;
    }
    
    public boolean addMeter(Meter m){
        return met.add(m);
    }
    
    public boolean removeMeter(String id){
        for(Meter a : met){
            if(a.getID().equals(id)){
                return met.remove(a);
            }
        }
        return false;
    }
    
    public Account getAccount(){
        return acc;
    }
    
    public void setAccount(Account a){
        acc = a;
    }
    
    
}
