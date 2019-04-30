/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

// import java.lang.Object;

import java.time.LocalDate;


/**
 *
 * @author Brandon
 */
public abstract class HotelStay {
    
    LocalDate arriveDate;
    LocalDate departDate;
    
    public HotelStay(LocalDate a, LocalDate d){
        arriveDate = a;
        departDate = d;
    }
    
    public abstract double getPrice();
    
}
