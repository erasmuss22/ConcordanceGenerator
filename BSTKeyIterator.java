///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  ConcordanceGenerator.java
// File:             BSTKeyIterator.java
// Semester:         Spring 2011
//
// Author:           Erin Rasmussen	ejrasmussen2@wsic.edu
// CS Login:         rasmusse
// Lecturer's Name:  Beck Hasti
// Lab Section:      Lecture 2
//
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
/**
 * BSTKeyIterator implements an iterator for a binary search tree (BST)
 * implementation of a SimpleMap.  The iterator iterates over the tree in order
 * of the keys (from smallest to largest) and returns the key
 * @param <K>
 */
public class BSTKeyIterator<K> implements Iterator<K> {
		private BSTnode<K, ?> current;
		private BSTnode<K, ?> tmp;
		private Stack<BSTnode<K, ?>> nodes;
		
	    public BSTKeyIterator(BSTnode<K, ?> root) {
			nodes = new Stack<BSTnode<K, ?>>();
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

		public K next() {
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			K data;
			current = nodes.pop();
			data = current.getKey();
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
	        // DO NOT CHANGE: you do not need to implement this method
	        throw new UnsupportedOperationException();
	    }
	

}
