/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

/**
 *
 * @author dsmurl
 */
public class BinaryTree {
    
    public class Node {      
        // Node parent;
        Node leftChild = null;
        Node rightChild = null;        
        
        int value;
        String name;
        
        public Node(String passedName, int passedValue) {
            this.name = passedName;
            this.value = passedValue;
        }
        
        @Override
        public String toString() {
            return "[ " + this.name + " : " + this.value + " ]";
        }
    }
    
    Node root;
        
    public void addNode(String passedName, int passedValue) {
        
        Node newNode = new Node(passedName, passedValue);
        
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node focusNode = root;
            
            Node parent;
            
            while (true) {
                
                parent = focusNode;
                
                if (passedValue < focusNode.value) {
                    focusNode = parent.leftChild;
                    
                    if ( parent.leftChild == null) {
                        parent.leftChild = newNode;
                        return;                        
                    }
                } else {
                    focusNode = parent.rightChild;
                    
                    if (parent.rightChild == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }               
            }
        }              
    }    
    
    
    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        
        Node focusNode = replacedNode.rightChild;
        
        while (focusNode != null) {
            replacementParent = replacement;            
            replacement = focusNode;            
            focusNode = focusNode.leftChild;
        }
        
        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        
        return replacement;
    } 
    
    
    public boolean deleteNode(int deleteValue) {
        Node focusNode = this.root;
        Node parent = this.root;
        
        boolean isFocusLeftChild = true;
                
        // find the node
        while (deleteValue != focusNode.value) {
            parent = focusNode;
            
            if (deleteValue < focusNode.value) {
                isFocusLeftChild = true;
                focusNode = focusNode.leftChild;            
            } else {                
                isFocusLeftChild = false;                
                focusNode = focusNode.rightChild;          
            }
            
            if ( focusNode == null ){
                // node not found
                System.out.println("Couldn't find node with value " + deleteValue + " to delete.");
                return false;
            }
        }
        
        // case of has no children
        if ((focusNode.leftChild == null ) && (focusNode.rightChild == null)) {
            if (focusNode == this.root) {
                this.root = null;
            } else if (isFocusLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;                
            }            
        }
        
        // if there is no right child
        else if (focusNode.rightChild == null) {
            if ( focusNode == this.root) {
                this.root = focusNode.leftChild;
            } else if (isFocusLeftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        }
        
        // if there is no left child
        else if (focusNode.leftChild == null) {
            if ( focusNode == root) {
                root = focusNode.rightChild;
            } else if (isFocusLeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.rightChild;
            }
        }
        
        // Both children are there
        else {
            Node replacement = this.getReplacementNode(focusNode);
            
            if (focusNode == root) {                
                root = replacement;
            } else if (isFocusLeftChild) {
                parent.leftChild = replacement;
            } else {
                parent.rightChild = replacement;
            }            
        
            replacement.leftChild = focusNode.leftChild;
        }
        
        System.out.println("Deleted node with value " + deleteValue + ".");    
        return true;        
    }


    public Node findNodeForValue(int findValue) {
        
        System.out.println("Looking for value: " + findValue);
        
        Node focusNode = this.root; 
        
        while (findValue != focusNode.value) {
        
            if (findValue < focusNode.value) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            
            if (focusNode == null) {
                System.out.println("Didn't find node.");
                return null;
            }
        }
        
        System.out.println("Found node: " + focusNode.toString());
        
        return focusNode;
    }
    
        
    
    
    public void inOrderTreeTraversal( ) {
        System.out.println("In Order Tree Traversal");
        inOrderTreeTraversal(this.root);
        System.out.println();
    }
    
    public void inOrderTreeTraversal( Node focusNode ) {
        
        if ( focusNode == null ) return;
        
        inOrderTreeTraversal(focusNode.leftChild);
        System.out.println(focusNode.toString());
        inOrderTreeTraversal(focusNode.rightChild);
    }    
    
    
    
    
    public void reverseOrderTreeTraversal( ) {
        System.out.println("Reverse Tree Traversal");
        reverseOrderTreeTraversal(this.root);
        System.out.println();
    }
    
    public void reverseOrderTreeTraversal( Node focusNode ) {
        
        if ( focusNode == null ) return;
        
        reverseOrderTreeTraversal(focusNode.rightChild);
        System.out.println(focusNode.toString());
        reverseOrderTreeTraversal(focusNode.leftChild);
    }    
    
    
    
    
    public void preorderTreeTraversal( ) {
        System.out.println("Pre Tree Traversal");
        preorderTreeTraversal(this.root);
        System.out.println();
    }
    
    public void preorderTreeTraversal( Node focusNode ) {
        
        if ( focusNode == null ) return;
        
        System.out.println(focusNode.toString());
        preorderTreeTraversal(focusNode.rightChild);
        preorderTreeTraversal(focusNode.leftChild);
    }    
    
    
    
    
    public void postorderTreeTraversal( ) {
        System.out.println("Post Tree Traversal");
        postorderTreeTraversal(this.root);
        System.out.println();
    }
    
    public void postorderTreeTraversal( Node focusNode ) {
        
        if ( focusNode == null ) return;
        
        postorderTreeTraversal(focusNode.rightChild);
        postorderTreeTraversal(focusNode.leftChild);
        System.out.println(focusNode.toString());

    }    
    
    
}
