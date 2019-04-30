/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Brandon
 */
public class Handler extends DefaultHandler {
    
    private ArrayList<Account> aList = new ArrayList<Account>();    
    private Account acc;
    
    private String acctNumber;
    private String acctBalance;
    private String acctType;
    
    private Customer c;
    private String last;
    private String first;
    
    private Address add;
    private String street;
    private int number;
    private String zipCode;
    private String type;
    
    private String unit;
    
    private Meter met;
    private String ID;
    private String brand;
    public String meterType;
    public String location;
    
    private MeterReading mr;
    private LocalDateTime time;
    private double reading;
    private String flag;
    
    public ArrayList<Account> getaList() {
            return aList;
        }    
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if(qName.equalsIgnoreCase("customer")){
            //set customer variables
            last = attributes.getValue("lastName");
            first = attributes.getValue("firstName");
        }
        else if(qName.equalsIgnoreCase("account")){
            acctNumber = attributes.getValue("accountNumber");
            acctType = attributes.getValue("type");
        }
        else if(qName.equalsIgnoreCase("address")){
            //set address variables
            street = attributes.getValue("street");
            number = Integer.parseInt(attributes.getValue("number"));
            zipCode = attributes.getValue("zipCode");
            type = attributes.getValue("type");
            unit = attributes.getValue("unit");
        }
        else if(qName.equalsIgnoreCase("meter")){
            ID = attributes.getValue("id");
            brand = attributes.getValue("brand");
            meterType = attributes.getValue("type");
            location = attributes.getValue("location");
        }
        else if(qName.equalsIgnoreCase("meterReading")){
            // Five hours from GMT
            ZoneOffset z = ZoneOffset.ofHours(5);
            // get number of seconds
            long epoch = Long.parseLong(attributes.getValue("date"));
            time = LocalDateTime.ofEpochSecond(epoch,0,z);
            flag = attributes.getValue("flag");
            //Increment 'reading' by what is parsed in each meterReading until meter is finished parsing
            reading += Integer.parseInt(attributes.getValue("reading"));
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(qName.equalsIgnoreCase("address")){
            if(type.equals("apartment")){
                add = new Apartment(street,number,zipCode,type,unit);
                add.addMeter(met);
            }
            else if(type.equals("commercial")){
                add = new Commercial(street,number,zipCode,type);
                add.addMeter(met);
            }
        }
        
        else if(qName.equalsIgnoreCase("meter")){
            if(meterType.equals("polling")){
                met = new PollMeter(ID,brand,meterType);
            }
            else if(meterType.equals("push")){
                met = new PushMeter(ID,brand,meterType);
            }
            met.setLocation(add,location);
            //Add total reading that has been incremented, then reset the total reading to zero
            
        }
        
        else if(qName.equalsIgnoreCase("meterReading")){
            mr = new MeterReading(reading,time,flag,met);
        }
        
        else if(qName.equalsIgnoreCase("account")){
            c = new Customer(last,first,add);
            met.addReading(mr);
            reading = 0;
            
            if(acctType.equals("residential")){
                acc = new ResidentialAccount(acctNumber, c);
                acc.addAddress(add);
                acc.updateBalance();
                System.out.println("res balance: " + acc.getCurrentBalance());
                aList.add(acc);
            }
            else if(acctType.equals("commercial")){
                acc = new CommercialAccount(acctNumber, c);
                acc.addAddress(add);
                acc.updateBalance();
                System.out.println("com balance: " + acc.getCurrentBalance());
                aList.add(acc);
            }
        }
    }
}
