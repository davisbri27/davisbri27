package lab01;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A (buggy) class that analyzes words. Designed for use in a debugging
 * laboratory in a computer science course.
 * 
 * Adapted from: http://www.horstmann.com/bigj/help/debugger/tutorial.html
 */
public class WordAnalyzer {

	private String word;

	/**
	 * Constructs an analyzer for a given word.
	 * 
	 * @param aWord
	 *            the word to be analyzed
	 */
	public WordAnalyzer(String aWord) {
		word = aWord;
		if (word == null) {
			throw new IllegalArgumentException("Hey! The string cannot be null!");
		}
	}

	/**
	 * Gets the first repeated character. A character is <i>repeated</i> if it
	 * occurs at least twice in adjacent positions. For example, 'l' is repeated
	 * in "hollow", but 'o' is not.
	 * 
	 * @return the first repeated character, or nothing (\0 the null character)
	 *         if none found
	 */
	public char firstRepeatedCharacter() {
		for (int i = 0; i < word.length() -1; i++) {
			//System.out.println("i = " + i);
			char ch = word.charAt(i);
			//System.out.println(" ch = " + ch);
			char nextCh = word.charAt(i + 1);
			//System.out.println(" nextCh = " + nextCh);
			if (ch == nextCh) {
				return ch;
			}
		}
		return '\0';
	}

	/**
	 * Gets the first multiply occurring character. A character is
	 * <i>multiple</i> if it occurs at least twice in the word, not necessarily
	 * in adjacent positions. For example, both 'o' and 'l' are multiple in
	 * "hollow", but 'h' is not.
	 * 
	 * @return the first repeated character, or 0 if none found
	 */
	public char firstMultipleCharacter() {
		Logger.getLogger("fMP").setLevel(Level.OFF);
		Logger.getLogger("fMP").info("Entering firstMultipleCharacter method");
		
		for (int i = 0; i < word.length() - 1; i++) {
			Logger.getLogger("fMP").info("i = " + i);
			char ch = word.charAt(i);
			Logger.getLogger("fMP").info("Looking for ch = " + ch);
			int nextLoc = findCharacter(ch, i+1);
			Logger.getLogger("fMP").info("Found next " + ch + " at nextLoc = " + nextLoc);
			if (nextLoc >= 0) {
				Logger.getLogger("fMP").info("Multiple found - Exiting firstMultipleCharacter");
				return ch;
			}
		}
		Logger.getLogger("fMP").info("No multiple - Exiting firstMultipleCharacter");
		return 0;
	}
	/**
	 * Finds if a character is present in the given string, starting from the indicated position, and 
	 * returns the position at which the character is found in the string; otherwise if the character 
	 * is not found, returns -1.
	 * For example, find(f, 3), when acting on string 'falafel', should return 4.
	 * 
	 * @param c the character being search for
	 * @param pos the position at which we begin searching in the string
	 * @return the position at which the character was found, or -1 if not found.
	 */
	private int findCharacter(char c, int pos) {
		assert pos >= 0 : "pos must be >= 0 but was " + pos; 
		assert pos < word.length() : "pos must be < word length (" + word.length() + ")," 
				+ " but was " + pos;
		for (int i = pos; i < word.length(); i++) {
			if (word.charAt(i) == c) { 
				//character at i is equal to character 'c'
				return i; //return position of this character
			}
		}
		return -1; //no match found
	}

	/**
	 * Counts the number of groups of repeated characters. For example,
	 * "mississippi!!!" has four such groups: ss, ss, pp and !!!.
	 * 
	 * @return the number of groups of repeated characters.
	 */
	public int countRepeatedCharacters() {
		/*
		 * Go through the word comparing the character at each position to the
		 * next. If a repetition is found, determine if it is at the start of a
		 * group (e.g. the first bb in "abbbcd"). If it is then add 1 to the
		 * number of groups.
		 */
		int numGroups = 0; // the number of groups seen so far.
		for (int chPos = 0; chPos < word.length() -1; chPos++) {
			if (word.charAt(chPos) == word.charAt(chPos + 1)) {
				// found a repetition
				if (chPos-1==-1 || word.charAt(chPos - 1) != word.charAt(chPos)) {
					// it's at the start of a group
					numGroups++;
				}
			}
		}
		return numGroups;
	}

	/**
	 * Create an instance of WordAnalyzer and invoke some methods on it.
	 * 
	 * @param args
	 *            none.
	 */
	public static void main(String[] args) {
		WordAnalyzer wa1 = new WordAnalyzer("bbaabbcccccbbbddeff");
		int r = wa1.countRepeatedCharacters();
		System.out.println(r);
	}
}
