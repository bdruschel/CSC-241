package csc241hw07;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Brandon
 */
public class Main {
    
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); //Read user input
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try{
            SAXParser saxParser = saxParserFactory.newSAXParser();
            Handler h = new Handler();
            List<Customer> cList = h.getCustList();
            System.out.println("Welcome to the Energy Management System");
            for(;;){
                System.out.println("Enter a command:");
                String c = in.nextLine(); //user input
                String command;
                //i can't think of any other way of interpreting what an invalid command is, so here you go
                if(!c.equals("quit") && !c.equals("report balance") && !c.contains("load ") && !c.equals("clear") && !c.contains("show ") && !c.contains("check ")){
                    System.out.println("Invalid command: " + c);
                }
                if(c.equals("quit")){
                    System.out.println("Program ending");
                    break; //break out of the endless loop -- freedom!
                }
                else if(c.contains(" ") && !c.equals("report balance")){
                    command = c.substring(0,c.indexOf(" ")); //title of command, i.e. "load"
                }
                else{
                    command = c;
                }
                    switch(command){
                        case "load": //"load <file name>" -- load a file
                            String fName = c.substring(c.lastIndexOf(" ") + 1, c.length()); //file name requested by input
                            String fPath = new File(fName).getAbsolutePath(); //path of file being looked for
                            File f = new File(fPath);
                            //check if the file requested actually exists
                            if (f.exists() && !f.isDirectory()) {
                                saxParser.parse(new File(fName).getAbsolutePath(), h);
                                
                                  cList = h.getCustList(); // Customer list generated

                                System.out.println("Load successful: " + fName);
                                break;
                            } 
                            else { //input file must be invalid if it DNE
                                System.out.println("Invalid input file - " + fName);
                                break;
                            }
                        
                        case "clear": //"clear" -- clear the entire array of accounts
                            cList.clear();
                            break;
                            
                        case "show": //"show <entity> <entity search term>" -- show values associated with the named entry
                            String entity = c.substring(c.indexOf(" ") + 1, c.indexOf(" ", c.indexOf(" ")+1));
                            String searchTerm = c.substring(c.indexOf(" ", c.indexOf(" ")+1) + 1, c.length());
                            //System.out.println("searchTerm: " + searchTerm);
                            //System.out.println("entity: " + entity);
                            int j = 0;
                            
                            if(entity.equals("customer")){ //show customer attributes
                                for (Customer cus : cList) { 
                                    if(cus.getLastName().equals(searchTerm)){ j++;
                                        System.out.println("Last name: " + cus.getLastName());
                                        System.out.println("First name: " + cus.getFirstName());
                                        System.out.println("Accounts:");
                                        for (Account acc : cus.getAccounts()) {
                                            System.out.println("  " + acc.getAccountNumber());
                                        }
                                    }
                                }
                            }
                            
                            if(entity.equals("account")){ //show account attributes
                                for(Customer cus : cList){ 
                                    for(Account a : cus.getAccounts()){
                                        if(a.getAccountNumber().equals(searchTerm)){ j++;
                                            System.out.println("Account number: " + a.getAccountNumber());
                                            System.out.println("Balance: $" + df2.format(a.getCurrentBalance()));
                                            System.out.println("Addresses:");
                                            for (Address add : a.getAddresses()) {
                                                System.out.println("  " + add.toString());
                                            }
                                        }
                                    }
                                }
                            }
                            
                            if (entity.equals("address")) {
                                for(Customer cus : cList){ 
                                    for (Account a : cus.getAccounts()) {
                                        for (Address add : a.getAddresses()) {
                                            if (searchTerm.equals(add.toString())) { j++; //System.out.println("test garbage");
                                                    System.out.println("Number: " + add.getNumber());
                                                    System.out.println("Street: " + add.getStreet());
                                                    System.out.println("Zip: " + add.getZipCode());
                                                    System.out.println("Type: " + add.getType());
                                                    if(add.getType().equals("apartment")){
                                                        System.out.println("Unit: " + (((Apartment)add).getUnit()));
                                                    }
                                                    System.out.println("Meters:");
                                                    for (Meter met : add.getMeters()) {
                                                        System.out.println("  " + met.getID());
                                                    }
                                            }
                                        }
                                    }
                                }
                            }
                            
                            if (entity.equals("meter")){
                                for(Customer cus : cList){ 
                                    for (Account a : cus.getAccounts()) {
                                        for (Address add : a.getAddresses()) {
                                            for (Meter met : add.getMeters()) {
                                                if(searchTerm.equals(met.getID())){ j++;
                                                    System.out.println("ID: " + met.getID());
                                                    System.out.println("Brand: " + met.getBrand());
                                                    System.out.println("Location: " + met.getLocation());
                                                    System.out.println("Type: " + met.getType());
                                                    System.out.println("Meters Readings:");
                                                    for(MeterReading mr : met.getReadings()){
                                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss");
                                                        String t = mr.getDateTime().format(formatter);
                                                        System.out.println("  " + t);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(j == 0){
                                System.out.println("No records found");
                            }
                            j = 0;
                            break;
                            
                        case "check":
                            String entity2 = c.substring(c.indexOf(" ") + 1, c.length());
                            //System.out.println("Entity2: " + entity2);
                            int k = 0;
                            
                             if(entity2.equals("customer")){
                                 for(Customer cus : cList){
                                     if(cus.getAccounts().length == 0){ k++;
                                         System.out.println(cus.toString());
                                     }
                                 }
                             }
                            
                            if(entity2.equals("account")){
                                for(Customer cus : cList){
                                    for(Account a : cus.getAccounts()){
                                        if(a.getAddresses().length == 0){ k++;
                                            System.out.println(a.getAccountNumber());
                                        }
                                    }
                                }
                            }
                            
                            if(entity2.equals("address")) {
                                for(Customer cus : cList){
                                    for (Account a : cus.getAccounts()) {
                                        for (Address add : a.getAddresses()) {
                                            if(add.getMeters().length == 0){ k++;
                                                System.out.println(add.toString());
                                            }
                                        }
                                    }
                                }
                            }
                            if(entity2.equals("meter")) {
                                for(Customer cus : cList){
                                    for (Account a : cus.getAccounts()) {
                                       for (Address add : a.getAddresses()) {
                                           for (Meter met : add.getMeters()) {
                                               if(met.getReadings().length == 0){ k++;
                                                   System.out.println(met.getID());
                                               }
                                               else{
                                                   for(MeterReading mr : met.getReadings()){
                                                       if(!mr.getFlag().equals(met.getType())){ k++;
                                                           System.out.println(met.getID());
                                                           break;
                                                       }
                                                   }
                                               }
                                           }
                                       }
                                    }
                                }
                            }
                            if(k == 0){
                                System.out.println("No records found");
                            }
                            k = 0;
                            break;
                            
                        case "report balance":
                            int l = 0;
                            for(Customer cus : cList){
                                for(Account a : cus.getAccounts()){
                                    l++;
                                    System.out.println("Account: " + a.getAccountNumber());
                                    System.out.println("  Customer: " + a.getCustomer().toString());
                                    System.out.println("  Balance: $" + df2.format(a.getCurrentBalance()));
                                }
                            }
                            if(l == 0){
                                System.out.println("No records found");
                            }
                            l = 0;
                            break;
                    }
            }
        }
        catch(ParserConfigurationException | SAXException | IOException e){
        }
    }
}