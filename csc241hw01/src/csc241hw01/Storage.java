package csc241hw01;

import java.util.*;

/**
 *
 * @author Brandon
 */
public class Storage {
    
    private ArrayList<String> str  = new ArrayList<>();
    
    public boolean addItem(String s){
        if(s != null){
           return str.add(s);
           // return true;
           // ArrayList's 'add' method returns a boolean!
        }
        return false;
    }
    
    public boolean removeItem(String s){
//      for(String a : str){ // When you are doing an enchanced for loop, 
                             // you cannot ADD or REMOVE from the collection
        for(int i = 0; i < str.size(); i++){
            if(str.get(i).equals(s)){
                str.remove(str.indexOf(str.get(i)));
               // return true;
               // ArrayList's 'remove' method returns a boolean!
            }
        }
        return false;
    }
    
    public String[] getItems(){
        String[] r = new String[str.size()];
        r = str.toArray(r); // Converts ArrayList into an Array!
        return r;
        
//        for(int i = 0; i < str.size(); i++)
//        {
//            if(str.get(i) != null){
//                r[i] = str.get(i);
//            }
//        }
//        return r;
    }
    
    public boolean isFull(){
        return false; // ArrayLists can't be "full"
    }
}


