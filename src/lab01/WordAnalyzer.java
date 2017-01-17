package lab01;

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
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			char nextCh = word.charAt(i + 1);

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
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int nextLoc = find(ch, i);
			if (nextLoc >= 0) {
				return ch;
			}
		}
		return 0;
	}

	private int find(char c, int pos) {
		for (int i = pos; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				return i;
			}
		}
		return -1;
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
		for (int chPos = 1; chPos < word.length() - 1; chPos++) {
			if (word.charAt(chPos) == word.charAt(chPos + 1)) {
				// found a repetition
				if (word.charAt(chPos - 1) != word.charAt(chPos)) {
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
		WordAnalyzer wa1 = new WordAnalyzer("Programmer");
		System.out.println(wa1.firstRepeatedCharacter());
	}
}
