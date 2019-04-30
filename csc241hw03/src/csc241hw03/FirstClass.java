/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

import java.time.LocalDate;

/**
 *
 * @author Brandon
 */
public class FirstClass extends AirTravel {
    
    public FirstClass(String a, LocalDate d, LocalDate r){
        super(a,d,r);        
    }
    
    @Override
    public double getPrice(){ // Tickets cost $1000
        return 1000;
    }
    
}
