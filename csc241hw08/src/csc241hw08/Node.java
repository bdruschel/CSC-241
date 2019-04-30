package csc241hw08;

/**
 *
 * @author Brandon
 */
public class Node {
    
    String name; // the string value for the node. in this case, a name
    Node left, right; // left child + right child
    
    public Node(String n){
        name = n;
        left = right = null; // children are null by default (well, isn't that depressing...)
    }
    
    public void insert(String s) { // insert a new node within 
        if(s.compareTo(name) <= 0) { // left child
            if(left == null) { // does left child not exist yet?
               left = new Node(s);
            }
            else{
                left.insert(s);
            }
        }
        else{ //right child
            if(right == null){ // does right child not exist yet?
                right = new Node(s);
            }
            else{
                right.insert(s);
            }
        }
              
    }
    
    public boolean contains(String n){
        if(n.equals(name)){ //is name present within this node?
            return true;
        }
        else{
            if(n.compareTo(name) < 0){ //to the left?
                if(left == null){
                    return false; //left child does not contain anything
                }
                else{
                    //ask if left child has 'n'
                    return left.contains(n);
                }
            }
            else{ //to the right?
                if(right == null){
                    return false; //right child does not contain anything
                }
                else{
                    //ask if left child has 'n'
                    return right.contains(n);
                }
            }
        }
    }
    
    public void printInOrder(){
        if(left != null){
            left.printInOrder();
        }
        
        System.out.print("[" + name + "]");
        
        if(right != null){
            right.printInOrder();
        }
    }
    
    public void printPreOrder(){
        System.out.print("[" + name + "]");
        
        if(left != null){
            left.printPreOrder();
        }
        
        if(right != null){
            right.printPreOrder();
        }
    }
    
    public void printPostOrder(){
        if(left != null){
            left.printPostOrder();
        }
        
        if(right != null){
            right.printPostOrder();
        }
        
        System.out.print("[" + name + "]");
    }
}
