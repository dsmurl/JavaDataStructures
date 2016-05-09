/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtables;

/**
 *
 * @author dsmurl
 */
public class HashTables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        
        
        HashTable hashTable1 = new HashTable(30);
        String[] elementsToAdd1 = { "1", "5", "16", "25", "26" };
        hashTable1.hashFunction1(elementsToAdd1);        
        hashTable1.displayTheHashTable();
        
        HashTable hashTable2 = new HashTable(30);
        String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };
        hashTable2.hashFunction2(elementsToAdd2);        
        hashTable2.displayTheHashTable();
        hashTable2.findIndexOfValue2("235");
        hashTable2.findIndexOfValue2("100");
    }
}
