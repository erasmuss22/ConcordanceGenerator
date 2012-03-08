///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  ConcordanceGenerator.java
// File:             BSTSimpleMap.java
// Semester:         Spring 2011
//
// Author:           Erin Rasmussen	ejrasmussen2@wsic.edu
// CS Login:         rasmusse
// Lecturer's Name:  Beck Hasti
// Lab Section:      Lecture 2
//
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Iterator;
import java.util.List;
import java.util.*;

/**
 * The BSTSimple Map creates a simple map that stores pairs of unique keys and
 * values in order from smallest to largest. It also contains methods to 
 * calculate statistics about the map.
 * 
 * <p>Bugs: none known
 *
 * @author Erin Rasmussen
 */
public class BSTSimpleMap<K extends Comparable<K>, V> 
                                              implements SimpleMapADT<K, V> {
    private BSTnode<K, V> root;  // the root node
    private int numItems;        // the number of items in the simple map
    public BSTSimpleMapIterator<V> iter;			// the iterator for the class

    /**
     * Creates a new, empty BSTSimpleMap
     *
     */
    public BSTSimpleMap(){
    	numItems = 0;
    }
    
    public boolean delete(K key) {
    	int num = numItems;
    	root = delete(root, key);
    	if ((num - numItems) != 0){
    		return true;
    	}
    	return false;
    }
    
    /**
     * An auxillary method that deletes a node based on it's location using
     * the rules of Binary Search Trees
     *
     * @param n The root of a tree or subtree
     * @param key The key to be deleted
     * @return The node to replace the one being deleted, null if none exist
     */
    private BSTnode<K, V> delete(BSTnode<K, V> n, K key){
    	if (n == null){
    		return null;
    	}
    	if (n.getKey().equals(key)){
    		if (n.getLeft() == null && n.getRight() == null) {
    			numItems--;
    			return null;
    		}
    		if (n.getLeft() == null) {
    			numItems--;
    			return n.getRight();
    		}
    		if (n.getRight() == null) {
    			numItems--;
    			return n.getLeft();
    		}
    		else {
    			K smallVal = smallest(n.getRight());
    			n.setKey(smallVal);
    			n.setRight( delete(n.getRight(), smallVal) );
    			numItems--;
    			return n;
    		}
    	}
    	else if (key.compareTo(n.getKey()) < 0) {
    		n.setLeft( delete(n.getLeft(), key) );
    		return n;
    	}

    	else {
    		n.setRight( delete(n.getRight(), key) );
    		return n;
    	}
    }
    
    /**
     * Used by delete, returns the smallest value of the Simple Map
     *
     * @param n The root of the BSTSimpleMap or subtrees
     * @return K, the smallest key
     */
    private K smallest(BSTnode<K, V> n) {
    	if (n.getLeft() == null) {
    		return n.getKey();
    	} else {
    		return smallest(n.getLeft());
    	}
    }

    public void insert(K key, V value) throws DuplicateKeyException {
    	root = insert(root, key, value);        
    }
    
    /**
     * An auxillary method that places a unique key in it's correct place
     * based on its value. Throws a DuplicateKeyException if the key already
     * exists.
     *
     * @param n The root of the Simple Map or subtrees
     * @param key The key to be inserted
     * @param value The value of the key being inserted
     * @return value The value of the key being inserted
     */
    private BSTnode<K, V> insert(BSTnode<K, V> n, K key, V value) throws 
    DuplicateKeyException{
    	if (n == null) {
    		numItems++;
    		return new BSTnode<K, V>(key, value, null, null);
        }
    	if (n.getKey().compareTo(key) == 0){
    		throw new DuplicateKeyException();
    	}
    	if (key.compareTo(n.getKey()) < 0) {
            // add k to the left subtree
    		 n.setLeft( insert(n.getLeft(), key, value) );
    	     return n;
        }
    	else {
            // add k to the right subtree
            n.setRight( insert(n.getRight(), key, value) );
            return n;
        }
    	
    }
     
    public int totalPathLength() {
        return totalPathLength(root, 1);
    }
    
    private int totalPathLength(BSTnode<K, V> n, int depth){
    	if (n == null){
    		return 0;
    	}
    	int path = depth;
    	if (n.getLeft() == null && n.getRight() == null){
    		return path;
    	}
    	if (n.getLeft() != null){
    		path = path + totalPathLength(n.getLeft(), depth + 1);
    	}
    	if (n.getRight() != null){
    		path = path + totalPathLength(n.getRight(), depth + 1);
    	}
    	return path;
    }
    
    public boolean isEmpty() {
    	return numItems == 0;
    }
    
    public Iterator<V> iterator() {
    	return new BSTSimpleMapIterator<V>(root);
    }
    
    public List<K> keyList() {
        List<K> keyList = new ArrayList<K>();
        BSTKeyIterator<K> itera = new BSTKeyIterator<K>(root);
        while (itera.hasNext()){
        	keyList.add(itera.next());
        }
        return keyList;
    }
    
    public V lookup(K key) {
        return lookup(root, key);
    }
    /**
     * An auxillary method that searches for a key in the Simple Map and
     * returns the value of the key if it is there.
     *
     * @param n The root of the Simple Map or subtree
     * @param key The key to search for in the Simple Map
     * @return The value of the key if it is in the Simple Map
     */
    private V lookup(BSTnode<K, V> n, K key){
    	if (n == null){
    		return null;
    	}
    	if (n.getKey().equals(key)){
    		return n.getValue();
    	}
    	 if (key.compareTo(n.getKey()) < 0) {
    	        return lookup(n.getLeft(), key);
    	    }
    	 else {
    	        return lookup(n.getRight(), key);
    	    }
    	
    }
    public int size() {
        return numItems;
    }
}
