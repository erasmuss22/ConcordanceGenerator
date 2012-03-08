///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            ConcordanceGenerator
// Files:            ConcordanceGenerator.java, BSTSimpleMap.java, Entry.java
//					 SimpleMapADT.java, BSTKeyIterator.java, BSTnode.java
//					 DuplicateKeyException.java, BSTSimpleMapIterator.java
//					 BSTKeyIterator.java
// Semester:         Spring 2011
//
// Author:           Erin Rasmussen	ejrasmussen2@wisc.edu
// CS Login:         rasmusse
// Lecturer's Name:  Beck Hasti
// Lab Section:      Lecture 2

//                   STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
// Credits:          Some code taken from readings
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;
import java.io.*;

public class ConcordanceGenerator {
    /**
     * The main method generates a concordance as described in the program 
     * write-up.  You will need to add to the code given here.
     * 
     * @param args the command-line arguments that determine how input and 
     * output is done:
     * <ul>
     *   <li>if there is one command-line argument, then it is treated as the
     *   name of the file from which to get input and output is sent to the
     *   console</li>
     *   <li>if there are two command-line arguments, then the first is the name
     *   of the file from which to get the input and the second is the name of 
     *   the file to which to sent the output</li>
     * </ul>
     * @throws FileNotFoundException 
     * @throws DuplicateKeyException 
     */
    public static void main(String[] args) throws FileNotFoundException, 
    DuplicateKeyException {
        Scanner in = null;         // for input
        PrintStream out = null;    // for output
        SimpleMapADT<String, Entry> concord = new BSTSimpleMap<String, Entry>();  
                                   // the concordance
        File infile;
        // Set up where to send input and output

        switch (args.length) {
        //One argument results in outputting to system
        case 1:
        	try{
        		infile = new File(args[0]);
        		in = new Scanner(infile);
        	} catch (FileNotFoundException e){
         		System.out.println("Bad file!" + e.getMessage());
        	}
        	break;
        //Two arguments results in creating a file of output with the 2nd arg as
        //the name of the file
        case 2: 
        	try {
        		infile = new File(args[0]);
        		in = new Scanner(infile);
        		out = new PrintStream(new File(args[1]));
        	} catch (FileNotFoundException e){
        		System.out.println("Bad file!" + e.getMessage());
        	}
        	break;


        default:
            System.err.println("Invalid command-line arguments");
            System.exit(0);
        }

        // Process the input file line by line
        int count = 1;
        while (in.hasNext()) {
            String line = in.nextLine();
            List<String> words = parseLine(line);
            for (String word : words){
                try {
                	concord.insert(word.toLowerCase(), new Entry(word));
                	concord.lookup(word.toLowerCase()).getLines().add(count);
                }
                catch (DuplicateKeyException e){
                	concord.lookup(word.toLowerCase()).getLines().add(count);
                }
            }
            count++;
        }// end while
        in.close();
        // Print out the concordance
        Iterator<Entry> iter = concord.iterator();
        if (args.length == 1){
        	while (iter.hasNext())
        		System.out.println(iter.next().toString());
        	int keys = concord.size();
        	int pathLength = concord.totalPathLength();
        	System.out.print("# keys: " + keys + "  total path length: " + pathLength); 
        	double avg = pathLength;
        	System.out.println("  avg path length: " + ((keys  == 0)? 0 :avg/keys));
        }
        else {
        	while (iter.hasNext())
        		out.println(iter.next().toString());	
        	int keys = concord.size();
        	int pathLength = concord.totalPathLength();
        	out.print("# keys: " + keys + "  total path length: " + pathLength);  
        	double avg = pathLength;
        	out.println("  avg path length: " + ((keys  == 0)? 0 :avg/keys));
        	out.close();
        }
    } 
    
    /**
     * Parses the given line into an array of words.
     * DO NOT CHANGE THIS METHOD.
     */
    private static List<String> parseLine(String line) {
        String[] tokens = line.split("[ ]+");
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < tokens.length; i++) {  // for each word
            
            // find index of first digit/letter
              boolean done = false; 
              int first = 0;
            String word = tokens[i];
            while (first < word.length() && !done) {
                if (Character.isDigit(word.charAt(first)) ||
                    Character.isLetter(word.charAt(first)))
                    done = true;
                else first++;
            }
            
            // find index of last digit/letter
            int last = word.length()-1;
            done = false;
            while (last > first && !done) {
                if (Character.isDigit(word.charAt(last)) ||
                        Character.isLetter(word.charAt(last)))
                        done = true;
                    else last--;
            }
            
            // trim from beginning and end of string so that is starts and
            // ends with a letter or digit
            word = word.substring(first, last+1);
  
            // make sure there is at least one letter in the word
            done = false;
            first = 0;
            while (first < word.length() && !done)
                if (Character.isLetter(word.charAt(first)))
                    done = true;
                else first++;           
            if (done)
                words.add(word);
        }
        
        return words;
    }
}
