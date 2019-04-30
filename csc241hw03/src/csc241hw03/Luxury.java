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
public class Luxury extends HotelStay {
    
    public Luxury(LocalDate a, LocalDate d){
        super(a,d);
    }
    
    @Override
    public double getPrice(){ // $500/night
        return arriveDate.until(departDate).getDays() * 500;
    }
    
}
