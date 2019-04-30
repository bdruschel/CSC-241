package csc241hw09;

/**
 *
 * @author Brandon
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap h = new HashMap();
        Scanner i = new Scanner(System.in); //user input
        
        System.out.println("Enter the file name:");
        String file = i.nextLine();
                
        Scanner t = new Scanner(new File(file).getAbsoluteFile()); //file to be read

        while(t.hasNextLine()){
            Scanner l = new Scanner(t.nextLine());
            String num = l.next(); //number read in the line
            String r = l.nextLine().trim(); //the phrase immediately after the number
            //System.out.println(r);
            h.put(num,r); //store num and r strings as <key> and <value> in the map
        }
        
        System.out.println("Enter a key value:");
        String k = i.nextLine();
        
        if(h.containsKey(k)){
            System.out.println("Value: " + h.get(k));
        }
        else{
            System.out.println("No value found");
        }
        
        //Well, that was easy!
    }
    
}
