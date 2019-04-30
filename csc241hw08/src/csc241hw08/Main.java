package csc241hw08;

import java.util.Scanner;

/**
 *
 * @author Brandon
 */
public class Main {
   
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); //Read user input
       
        BinarySearchTree bst = new BinarySearchTree();
        
        System.out.println("Welcome to Binary Tree Sorter");
        
        for(;;){
            System.out.println("Enter a command (i, c, in, pre, post, or q):");
            String input = in.nextLine();

            if (input.contains(" ")) {
                String command = input.substring(0, input.lastIndexOf(" "));
                String name = input.substring(input.indexOf(" ") + 1);

                if (command.equals("i")) {
                    bst.insert(name);
                }
                if (command.equals("c")) { //contains
                    if (bst.contains(name)) {
                        System.out.println(name + " is contained in the tree.");
                    } else {
                        System.out.println(name + " is not in the tree.");
                    }
                }
            }
     
            else if(input.equals("q")){ //quit
                System.out.println("Closing Binary Tree Sorter");
                break;
            }
                        
            else if(input.equals("in")){
                bst.printInOrder();
            }
            
            else if(input.equals("pre")){
                bst.printPreOrder();
            }
            
            else if(input.equals("post")){
                bst.printPostOrder();
            }
            
            else{
                System.out.println("Invalid command -- " + input);
            }
        }
    }
    
}
