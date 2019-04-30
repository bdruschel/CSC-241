/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw05;

import java.io.File;
import java.io.IOException;
//import java.io.InputStream;
import java.util.ArrayList;
//import java.util.List;
 
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
import org.xml.sax.SAXException;


/**
 *
 * @author Brandon
 */

import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser = saxParserFactory.newSAXParser();
            Handler h = new Handler();

            System.out.println ("Enter the input file name:");
            String s = reader.nextLine();

                //System.out.println(new File(s).getAbsolutePath());
            saxParser.parse(new File(s).getAbsolutePath(),h);

            ArrayList<Holiday> hList = h.getHList();
            //print holiday information
            for(Holiday ho : hList)
                System.out.println(ho);
            } catch(ParserConfigurationException | SAXException | IOException e){

        }
        
        System.out.println();
    }

    
    
}
