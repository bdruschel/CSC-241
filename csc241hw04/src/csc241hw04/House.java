/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw04;

/**
 *
 * @author Brandon
 */
public class House extends Address {
    
    public House(String s, int n, String z, String t) {
        super(s, n, z, t);
    }

    @Override
    public String getType() {
        return "house";
    }
    
}
