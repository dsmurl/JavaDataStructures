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
public class BinaryTrees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode("Sam", 0);
        binaryTree.addNode("Carl", 10);
        binaryTree.addNode("Jake", 20);
        binaryTree.addNode("Matt", -10);
        binaryTree.addNode("James", -30);
        binaryTree.addNode("Jeff", 40);
        binaryTree.addNode("Will", -450);
        binaryTree.addNode("Dan", 60);
        
        binaryTree.inOrderTreeTraversal();        
        binaryTree.reverseOrderTreeTraversal();
        binaryTree.preorderTreeTraversal();
        binaryTree.postorderTreeTraversal();
        
        binaryTree.findNodeForValue(0);
        binaryTree.findNodeForValue(5);
    }    
}
