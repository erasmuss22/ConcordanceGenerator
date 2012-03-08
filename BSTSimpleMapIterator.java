///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  ConcordanceGenerator.java
// File:             BSTSimpleMapIterator.java
// Semester:         Spring 2011
//
// Author:           Erin Rasmussen	ejrasmussen2@wsic.edu
// CS Login:         rasmusse
// Lecturer's Name:  Beck Hasti
// Lab Section:      Lecture 2
//
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.*;

/**
 * BSTSimpleMapIterator implements an iterator for a binary search tree (BST)
 * implementation of a SimpleMap.  The iterator iterates over the tree in order
 * of the keys (from smallest to largest) and returns the value associated with
 * each key.
 * @param <K>
 */
public class BSTSimpleMapIterator<V> implements Iterator<V> {
	private BSTnode<?, V> current;
	private BSTnode<?, V> tmp;
	private Stack<BSTnode<?, V>> nodes;
	
    public BSTSimpleMapIterator(BSTnode<?, V> root) {
		nodes = new Stack<BSTnode<?, V>>();
    	current = root;
    	nodes.push(current);
		while(current.getLeft() != null){
			current = current.getLeft();
			nodes.push(current);
		}
	}

	public boolean hasNext() {
        return !nodes.isEmpty();
    }

	public V next() {
		if (!hasNext()){
			throw new NoSuchElementException();
		}
		V data;
		current = nodes.pop();
		data = current.getValue();
		if (current.getRight() != null){
			tmp = current.getRight();
			nodes.push(tmp);
			while (tmp.getLeft() != null){
				tmp = tmp.getLeft();
				nodes.push(tmp);
			}
		}
		
		return data;

	}

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
