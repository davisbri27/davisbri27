package hw02;

/**
 * Snippets of code for problem #2 on homework #2.
 */
public class Hw02No3 {

	/**
	 * Determine if the string s is a palendrome.
	 * 
	 * @param s the string
	 * @return true if s is a palendrome, false if it is not.
	 */
	public static boolean isPalendrome(String s) {
		if (s.length() == 0) {
			return true;
		}
		else if (s.length() == 1) {
			return false;
		}
		else if (s.charAt(0) != s.charAt(s.length()-1)) {
			return false;
		}
		else {
			return isPalendrome(s.substring(1, s.length()-2));
		}
	}
}
