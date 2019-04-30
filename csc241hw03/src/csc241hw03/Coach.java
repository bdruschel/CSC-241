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
public class Coach extends AirTravel {
    
    public Coach(String a, LocalDate d, LocalDate r){
        super(a,d,r);        
    }
    
    @Override
    public double getPrice(){ // Tickets cost $300
        return 300;
    }
    
}
