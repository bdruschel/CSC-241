package csc241hw02;

import java.util.ArrayList;

/**
 *
 * @author Brandon
 */
public class Account {
    
    private String accountNumber;
    private double balance;
    private Customer cust;
    
    private ArrayList<Address> add = new ArrayList<Address>();
    
    public Account(String an, Customer c){
        accountNumber = an;
        cust = c;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
    public Customer getCustomer(){
        return cust;
    }
    
    public double getCurrentBalance(){
        return balance;
    }
    
    public Address[] getAddresses(){
        Address[] a = new Address[add.size()];
//        for(int i = 0; i < add.size(); i++){
//            a[i] = add.get(i);
//        }
        add.toArray(a); 
        return a;
    }
    
    public boolean addAddress(Address a){
        return add.add(a);
    }
    
    public boolean removeAddress(Address a){
        for(Address ad : add){
            if(ad.equals(a)){
                return add.remove(ad);
            }
        }
        return false;
    }
    
    
}
