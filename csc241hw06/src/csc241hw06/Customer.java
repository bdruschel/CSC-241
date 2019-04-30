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
public class Customer {
    
    private String last;
    private String first;
    private Address add;
    
    private ArrayList<Account> acc = new ArrayList<Account>();
    
    public Customer(String l, String f, Address a){
        last = l;
        first = f;
        add = a;
    }
    
    public String getLastName(){
        return last;
    }
    
    public String getFirstName(){
        return first;
    }
    
    public Address getMailingAddress(){
        return add;
    }
    
    public Account[] getAccounts(){
        Account[] a = new Account[acc.size()];
//        for(int i = 0; i < acc.size(); i++){
//            a[i] = acc.get(i);
//        }
        acc.toArray(a); 
        return a;
    }
        
    public boolean addAccount(Account a){
        return acc.add(a);
    }
    
    public boolean removeAccount(Account a){
        for(Account ac : acc){
            if(ac.equals(a)){
                return acc.remove(ac);
            }
        }
        return false;
    }
    
    public Address getAddress(){
        return add;
    }
}
