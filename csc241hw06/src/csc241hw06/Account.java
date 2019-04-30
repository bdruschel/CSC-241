/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.util.ArrayList;

/**
 *
 * @author Brandon
 */
public abstract class Account {
    
    private String accountNumber;
    public double balance;
    private Customer cust;
    
    public ArrayList<Address> add = new ArrayList<Address>();
    
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
    
    public void setBalance(double b){
        balance = b;
    }
    
    public abstract void updateBalance();
    
}
