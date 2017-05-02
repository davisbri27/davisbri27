package lab10;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Several Dickinson computer science graduates have created a new anti-social
 * media app "GetOutOfMyFaceBook" (GOOMFBook), that they think will make them
 * rich. GOOMFBook is kind of like facebook, except that you cannot have any
 * friends or make any posts. Despite this strange choice of features, interest
 * in GOOMFBook is booming and registration rates are off the charts. The
 * GOOMFBook membership is growing so fast that the registration system cannot
 * keep up. They have called on you to help speed up the registration system.
 * 
 * The system works on the following principle. Each time a new user wants to
 * register, he/she sends a request to the system with a desired username. Such
 * a request contains the character 'A' followed by a space followed by the
 * desired username, followed by another space followed by the user's real name.
 * For example:
 * 
 * A benrush Benjamin Rush If the username is not in use, it is inserted into
 * the system, and the user gets the response OK, confirming the successful
 * registration. If the username is already in use, the system makes up a new
 * username, sends it to the user as a prompt and also inserts the prompt into
 * the system. The new username is formed by the following rule. Numbers,
 * starting with 1, are appended one after another to the desired username
 * (name1, name2, ...), among these numbers the least i is found so that namei
 * is not in use.
 * 
 * The registration system can also be queried for the real name corresponding
 * to a username. Sending the message 'I' followed by a space, followed by a
 * username will return the user's real name if there is such a user or the
 * string "AVAILABLE" if there is no such user.
 * 
 * Finally, though the GOOMFBook creators can't imagine why anyone would want
 * to, it has been suggested that users be able to also delete their accounts.
 * This is done by sending a delete message to the system. Delete messages
 * include a 'D' followed by the username to delete. For example:
 * 
 * D benrush1773
 * 
 * @author Briona Davis, Andy Guo
 *
 */

public class RegistrationSystem {
	private HashMap<String, String> hashmap;

	/**
	 * Constructor for a new Registration System using a hashmap. 
	 **/
	public RegistrationSystem() {
		hashmap = new HashMap<String, String>();
	}

	/**
	 * register uses a scanner to determine whether to add, delete, or find the user based on the system input.
	 * If read "A", then add the username
	 * If read "D", then delete the username
	 * If read "I", then find the username and return the real name.
	 **/
	private void register() {
		Scanner scr = new Scanner(System.in);

		while (scr.hasNextLine()) {
			String line = scr.nextLine();
			String[] splitLine = line.split(" ");
			String letter = splitLine[0];
			String username = splitLine[1]; // key

			if (letter.equals("A")) {
				String actualName = line.substring(3 + username.length(), line.length()); // value
				if (hashmap.containsKey(username)) {
					// username is in use make up new username
					String newName = newName(username);
					hashmap.put(newName, actualName);
					System.out.println(newName);
				} else {
					// username not in use
					hashmap.put(username, actualName);
					System.out.println("OK");

				}
			} else if (letter.equals("I")) {
				if (hashmap.containsKey(username)) {
					System.out.println(hashmap.get(username));
				} else {

					System.out.println("AVAILABLE");
				}

			} else if (letter.equals("D")) {
				if (hashmap.containsKey(username)) {
					hashmap.remove(username);
				}
			}

		}
		scr.close();

	}
	/**
	 * helper method to construct a new username
	 * If username already exists, add 1 to the end. 
	 *
	 **/
	private String newName(String name) {
		int i = 1;
		String uname = name;
		while (hashmap.containsKey(uname)) {
			uname = name + i;
			;
			i++;
		}
		return uname;

	}
	
	
	public static void main(String[] args) {
		RegistrationSystem rs = new RegistrationSystem();
		rs.register();

	}

}
