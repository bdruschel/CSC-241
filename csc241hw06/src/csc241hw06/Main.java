/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
import org.xml.sax.SAXException;

import java.util.Scanner;

/**
 *
 * @author Brandon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static DecimalFormat df2 = new DecimalFormat(".##");
    
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in); //Reads user input
    
        
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser = saxParserFactory.newSAXParser();
            Handler h = new Handler();

            System.out.println ("Enter the input file name:");
            String s = reader.nextLine();

            System.out.println("Enter the account number:");
            String an = reader.nextLine();

                //System.out.println(new File(s).getAbsolutePath());
            saxParser.parse(new File(s).getAbsolutePath(),h);

            ArrayList<Account> aList = h.getaList();
            //print Account information
            int check = 0;
            for(Account a : aList){
                if(a.getAccountNumber().equals(an)){
                    System.out.println("Balance: $" + df2.format(a.getCurrentBalance()));
                    check++;
                }
            }
            if(check == 0){
                System.out.println("Account number " + an + " not found.");
            }
        } catch(ParserConfigurationException | SAXException | IOException e){
            
        }
        
    }
    
    
}
