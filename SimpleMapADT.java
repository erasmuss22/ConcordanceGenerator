import java.util.Iterator;
import java.util.List;

/**
 * The SimpleMap ADT represents a simple Map ADT that stores (key, value) pairs
 * where the keys are unique.  Operations are provided to insert, lookup, and
 * delete information as well as to go through the values in order of the keys
 * associated with the values from smallest to largest (based on the ordering
 * given by compareTo).  Additionally, the SimpleMap ADT provides some methods
 * that give insight about the relative efficiency of a particular map: the
 * size (# of (key, value) pairs) and the total path length.  The total path
 * length is the sum of the lengths of the paths to each (key, value) pair.  
 * Thus, one measure of the average lookup time is (total path length)/size.
 * 
 * DO NOT CHANGE THIS FILE
 *  
 * @author CS 367
 * @param <K> class representing the key, should implement the Comparable<K> 
 *            interface 
 * @param <V> class representing the value
 */
public interface SimpleMapADT<K extends Comparable<K>, V> {
    
    /**
     * Inserts the given (key, value) pair into the Simple Map if the key is 
     * not already in the Simple Map.  If the key is already in the Simple Map, 
     * a DuplicateKeyException is thrown.
     * @param key the key to insert into the Simple Map
     * @param value the value associated with the key
     * @throws DuplicateException if the key is already in the Simple Map
     */
    void insert(K key, V value) throws DuplicateKeyException;
    
    /**
     * Deletes the (key, value) pair from the Simple Map that corresponds with 
     * the given key.  If the key is in the Simple Map, the (key, value) pair 
     * is deleted and true is returned.  If the key is not in the Simple Map, 
     * the Simple Map is unchanged and false is returned. 
     * @param key the key for the (key, value) pair to delete from the Simple 
     *        Map
     * @return true if the deletion is successful (i.e., the key was in the 
     * Simple Map and has been removed), false otherwise (i.e., the key was not
     * in the Simple Map)
     */
    boolean delete(K key);
    
    /**
     * Searches for the given key in the Simple Map and returns the value 
     * associated with it.  If the key is not in the Simple Map, null is 
     * returned.
     * @param key the key to search for
     * @return the value from the Simple Map corresponding to the key, if the
     * key is in the Simple Map; null if the key is not in the Simple Map
     */
    V lookup(K key);
    
    /**
     * Returns the number of (key, value) pairs in the Simple Map.
     * @return the number of (key, value) pairs in the Simple Map
     */
    int size();
    
    /**
     * Returns true if and only if the Simple Map is empty.
     * @return true if the Simple Map is empty, false otherwise
     */
    boolean isEmpty();
    
    /**
     * Returns an iterator over the Simple Map that iterates over the values in 
     * the Simple Map in order of the associated keys from smallest to largest.
     * @return an iterator over the values in the Simple Map in key order
     */
    Iterator<V> iterator();
   
    /**
     * Returns a list of the keys in the Simple Map in order from smallest to
     * largest
     * @return a list of the keys in the Simple Map in order
     */
    List<K> keyList();
    
    /**
     * Returns the total path length.  The total path length is the sum of the
     * lengths of the paths to each (key, value) pair.
     * @return the total path length
     */
    int totalPathLength();
}
