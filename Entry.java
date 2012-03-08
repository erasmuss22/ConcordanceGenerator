///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  ConcordanceGenerator.java
// File:             Entry.java
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
 * An Entry consists of a word and a list of line numbers (integers). A word is
 * a non-empty sequence of characters whose letters are all lower-case. 
 * 
 * <p>Bugs: none known
 *
 * @author Erin Rasmussen
 */
public class Entry implements Comparable<Entry>{
	
	private String word;
	private List<Integer> lineNumber;
	private Entry entry;
	
	/**
	  * Creates a new Entry with a List of line numbers it appears in.
	  *
	  * @param word The word to be inserted into the Simple Map
	  */
	public Entry(String word){
		if (word == null){
			throw new IllegalArgumentException();
		}
		this.word = word.toLowerCase();
		lineNumber = new ArrayList<Integer>();
	}
	
	/**
	  * The compare to method that compares if an Entry is less than, equal,
	  * or greater than another entry which will assist in the insert method
	  * in BSTSimpleMap.
	  *
	  * @param other The Entry to be compared to
	  * @return An integer whose value tells of the comparison.
	  */
	@Override
	public int compareTo(Entry other) {
		if (other == null){
			throw new NullPointerException();
		}
		return word.compareTo(other.getWord());
	}
	
	/**
	  * Determines if two objects are equal to each other.
	  *
	  * @param other The other Object to compare to
	  * @return True if they are equal, false if not
	  */
	public boolean equals(Object other){
		if (other == null){
			throw new NullPointerException();
		}
		if (other instanceof Entry){
			Entry e = (Entry) other;
			if (entry.compareTo(e) == 0){
				return true;
			}
		}
		else {
			throw new ClassCastException();
		}
		return false;
	}
	
	/**
	  * Returns a list of line numbers each Entry appears in.
	  *
	  * @return A list of line numbers for each Entry
	  */
	public List<Integer> getLines(){
		return lineNumber;
	}
	
	/**
	  * Returns the word of each Entry
	  *
	  * @return The word associated with the Entry
	  */
	public String getWord(){
		return word;
	}
	
	/**
	  * An auxillary print method that formats the output of each Entry
	  *
	  * @return A String that represents all data of the Entry
	  */
	public String toString(){
		Iterator<Integer> iter = getLines().iterator();
		String word = getWord() + "(" + getLines().size() + "): ";
		while (iter.hasNext()){
			word += iter.next() + ", ";
		} 
		word = word.substring(0, word.length() - 2);
		return word;
	}
}
