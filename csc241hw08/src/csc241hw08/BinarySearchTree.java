package csc241hw08;

/**
 *
 * @author Brandon
 */
public class BinarySearchTree {
    
    Node root;
    
    public BinarySearchTree(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void insert(String s){
        if(this.isEmpty()){
            root = new Node(s);
        }
        else{
            root.insert(s);
        }
    }
    
    public boolean contains(String n){
        if(this.isEmpty()){
            return false;
        }
        else{
            return root.contains(n);
        }
    }
    
    public void printInOrder(){
        if(this.isEmpty()){
            System.out.println("The tree has no nodes.");
        }
        else{
            System.out.println("In-order:");
            root.printInOrder();
            System.out.println("");
        }
    }
    
    public void printPreOrder(){
        if(this.isEmpty()){
            System.out.println("The tree has no nodes.");
        }
        else{
            System.out.println("Pre-order:");
            root.printPreOrder();
            System.out.println("");
        }
    }
    
    public void printPostOrder(){
        if(this.isEmpty()){
            System.out.println("The tree has no nodes.");
        }
        else{
            System.out.println("Post-order:");
            root.printPostOrder();
            System.out.println("");
        }
    }
    
}
