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
public class VacationPackage {
   
    private LocalDate arrivalDate;
    private LocalDate departDate;
    
    private Guest gu;
    private HotelStay hs;
    private AirTravel at;
    
    public VacationPackage(LocalDate aD, LocalDate dD){
        arrivalDate = aD;
        departDate = dD;
    }
    
    public Guest getGuest(){
        return gu;
    }
    
    public void setGuest(Guest gue){
        gu = gue;
    }
    
    public HotelStay getHotelStay(){
        return hs;
    }
    
    public void setHotelStay(HotelStay h){
        hs = h;
    }
    
    public AirTravel getAirTravel(){
        return at;
    }
    
    public void setAirTravel(AirTravel a){
        at = a;
    }
    
    public int getLengthOfStay(){
        return arrivalDate.until(departDate).getDays();
    }
    
    public double getPrice(){ // $100/day for Adults, $25/day for Children
        double total = 0;
        
        if(getLengthOfStay() != 0){
            
            if(gu.isChild()){ //if guest is a child
                total += getLengthOfStay() * 25;
            }
            else{ // if guest is an adult
                total += getLengthOfStay() * 100;
            }

            total += at.getPrice();
            total += hs.getPrice();
        
        }
        
        return total;
    }
    
}
