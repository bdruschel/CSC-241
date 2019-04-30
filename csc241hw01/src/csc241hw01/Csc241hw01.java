package csc241hw01;

import java.util.*;

/**
 *
 * @author Brandon
 */
public class Csc241hw01 {
    
    public static void main(String[] args) {

        Storage s = new Storage(); // Object to be tested
        
        // testing addItem function
        s.addItem("You're mom LOL xD");
        s.addItem("yo DADDY");
        s.addItem("MY MOM!!");
        s.addItem(null); //this should NOT result in getItems returning this
        
        //s.removeItem("MY MOM!!"); // tests removeItem function
        System.out.println(s.removeItem("MY MOM!!")); // should return true upon 
                                                      // successful removal
        
        // this enhanced for loop ouputs everything in the Storage's ArrayList
        System.out.println(Arrays.toString(s.getItems()));
        
    }
    
}
