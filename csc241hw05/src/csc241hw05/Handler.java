/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw05;

import java.util.ArrayList;
 
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Brandon
 */
public class Handler extends DefaultHandler {
    
    //List to hold Holiday objects
    private ArrayList<Holiday> hList = new ArrayList<Holiday>();
    //Object to represent parsed holidays
    private Holiday h;
    
    //Variables which will be set according to what is parsed
    private String month;
    private int day;
    private String name;
    
    boolean federal = false;
    boolean oswego = false;
    
    //Getter Method for Holiday list
    public ArrayList<Holiday> getHList() {
        return hList;
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if(qName.equalsIgnoreCase("month")){
            month = attributes.getValue("name");
//            System.out.println("MONTH: " + month); //debug
        }
        else if(qName.equalsIgnoreCase("holiday")){
            day = Integer.parseInt(attributes.getValue("day")); //getValue() alone doesn't work when reading integers - parseInt() overcomes this
//            System.out.println("DAY: " + day); //debug
            name = attributes.getValue("name");
//            System.out.println("NAME: " + name); //debug
        }
        else if(qName.equalsIgnoreCase("federal")){
            if(attributes.getValue("value").equals("yes")){
                federal = true;
            }
            else{
                federal = false;
            }
//            System.out.println("FEDERAL: " + federal); //debug
        }
        else if(qName.equalsIgnoreCase("oswego")){
            if(attributes.getValue("value").equals("yes")){
                oswego = true;
            }
            else{
                oswego = false;
            }
//            System.out.println("OSWEGO: " + oswego); //debug
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if (qName.equalsIgnoreCase("holiday")){  //Condition to add Holiday object to list
            h = new Holiday(month,day,name);
            h.setFederal(federal);
            h.setOswego(oswego);
            //System.out.println(h);
            
            hList.add(h);
            // These booleans should always be false 'by default' when parsing through a new Holiday
            federal = false;
            oswego = false;
        }
    }
    
// DefaultHandler's characters() method has no use here
        
}
