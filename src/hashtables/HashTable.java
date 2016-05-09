/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtables;
 
import java.util.Arrays;

/**
 *
 * @author dsmurl
 */
public class HashTable {
    
    String[] theArray;
    int arraySize;
    int itemsInArray = 0;
    
    HashTable(int size){
    
        this.arraySize = size;
        this.theArray = new String[this.arraySize];
        Arrays.fill(this.theArray, null);
    }
    
    public void hashFunction1(String[] stringsForArray) {
        for (String newElementVal : stringsForArray) {
            this.theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }        
    }
    
    
    
    public void hashFunction2(String[] stringsForArray) {
        for (String newElementVal : stringsForArray) {
            int index = Integer.parseInt(newElementVal)%(this.arraySize - 1);
            
            System.out.println("HF2(" + newElementVal + ") = " + index);
            
            while (null != this.theArray[index]) {
                ++index;
                index %= arraySize;
                
                System.out.println("Collision: trying " + index + " instead.");
            }

            this.theArray[index] = newElementVal;
        }        
    }
    
    public int findIndexOfValue2(String value) {
        int index = Integer.parseInt(value) % (this.arraySize - 1);
        
        while (this.theArray[index] != null) {
            if (this.theArray[index] == value) {
                System.out.println("HF(" + index +") = " + value);
                return index;
            }
            
            index = (++index) % (this.arraySize - 1);
        }
        
        return index;
    }
    
    
    
    
    
    public void displayTheHashTable() {
        int increment = 0;
        
        int batches = this.arraySize / 10;

        for (int m = 0; m < batches; m++) {
            increment += 10;

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                if (theArray[n] == null)
                    System.out.print("|      ");
                else
                    System.out.print(String.format("| %3s " + " ", theArray[n]));

            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();
        }
            System.out.println();
            System.out.println();
            System.out.println();
    }
}
