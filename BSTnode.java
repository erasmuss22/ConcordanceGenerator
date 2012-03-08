/**
 * BSTnode implements a node for a binary search tree (BST).  Each BSTnode 
 * keeps track of a key and the value associated with that key.
 * 
 * DO NOT CHANGE THIS FILE
 * 
 * @author CS 367
 * @param <K> class representing the key, should implement the Comparable<K> 
 *            interface 
 * @param <V> class representing the value
 */
class BSTnode<K, V> {
    // Data members
    private K key;                      // the key for this node
    private V value;                    // the data value for this node
    private BSTnode<K, V> left, right;  // the left and right children
 
    /**
     * Constructs a BST node with the given key and value and whose left and 
     * right children are null.
     * @param key
     */
    public BSTnode(K key, V value) {
        this(key, value, null, null);
    }
    
    /**
     * Constructs a BST node with the given key, value, left child, and right 
     * child.
     * @param key the key value
     * @param leftChild the left child
     * @param rightChild the right child
     */
    public BSTnode(K key, V value, BSTnode<K, V> leftChild, 
                                   BSTnode<K, V> rightChild) {
        this.key = key;
        this.value = value;
        left = leftChild;
        right = rightChild;
    }
 
    /**
     * Returns the key for this BST node.
     * @return the key
     */
    public K getKey() { 
        return key; 
    }
    
    /**
     * Returns the value for this BST node
     * @return the value
     */
    public V getValue() {
        return value;
    }
    
    /**
     * Returns the left child for this BST node.
     * @return the left child
     */
    public BSTnode<K, V> getLeft() { 
        return left; 
    }
    
    /**
     * Returns the right child for this BST node.
     * @return the right child
     */
    public BSTnode<K, V> getRight() { 
        return right; 
    }
 
    /**
     * Changes the key for this node to the one given.
     * @param newK the new key  
     */
    public void setKey(K newK) { 
        key = newK; 
    }
    
    /**
     * Changes the value for this node to the one given.
     * @param newV the new value
     */
    public void setValue(V newV) {
        value = newV;
    }
    
    /**
     * Changes the left child for this node to the one given.
     * @param newL the new left child
     */
    public void setLeft(BSTnode<K, V> newL) { 
        left = newL; 
    }
    
    /**
     * Changes the right child for this node to the one given.
     * @param newR the new right child
     */
    public void setRight(BSTnode<K, V> newR) { 
        right = newR; 
    }
}
