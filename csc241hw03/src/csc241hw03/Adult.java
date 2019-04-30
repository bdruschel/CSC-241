/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

/**
 *
 * @author Brandon
 */
public class Adult extends Guest {
    
    public Adult(String l, String f){
        super(l,f);
    }
    
    // VacationPackage.getPrice() requires a check for whether or not the guest is an adult or child
    @Override
    public boolean isChild(){ 
        return false;
    }
}
