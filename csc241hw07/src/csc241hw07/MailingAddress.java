/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07;

/**
 *
 * @author jearly
 */
public class MailingAddress extends Address{
    
    public MailingAddress(String s, int h, String z, String t) {
        super(s,h,z,t);
    }
    
    public String getType(){
        return "mailing";
    }
    
}
