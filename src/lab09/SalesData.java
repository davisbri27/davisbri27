package lab09;

import java.util.*;

import lab09.CS232LinkedBinaryTree.BTNode;

/**
* The Acme Corporation needs to do a better job of tracking the performance of
* their sales force. They have sales people all over the world selling anvils
* and TNT to coyotes. Each time a sales person makes a sale they add the sales
* information into the company's computer system. Unfortunately, they do not
* all do the entry immediately, so the sales data often arrives out of order.
* Sometimes there are mistakes and entire days worth of sales data must be
* removed. There will be at most one sales record on any given day.
* 
* The managers at ACME Corporation would like to take advantage of all of this
* data by making queries against it. Some of the things they would like to ask
* include: How much was the most recent sale? What was the total of the last k
* sales? How much in total sales was made on the k days starting at a given
* date? How much in total sales were made between two dates? The specific
* operations that must be supported are:
* 
* A: add a sales record. D: delete the sales record for a given date. S: get
* the amount of the most recent sale. K: get the total amount of the k most
* recent sales. G: get the total amount of sales in the k days starting on a
* given date. R: get the total amount of all sales within a range of dates.
* 
* @author Briona Davis, Andy Guo
*
*/
public class SalesData {
	private CS232LinkedAVLTree<Calendar, Double> tree;

	public SalesData() {
		tree = new CS232LinkedAVLTree<Calendar, Double>();

	}

	/**
	 * readFile method reads in the input with a scanner. Different letters
	 * indicate different objectives. A: add a sales record. D: delete the sales
	 * record for a given date. S: get the amount of the most recent sale. K:
	 * get the total amount of the k most recent sales. G: get the total amount
	 * of sales in the k days starting on a given date. R: get the total amount
	 * of all sales within a range of dates.
	 * 
	 * 
	 */
	public void readFile() {
		Scanner scr = new Scanner(System.in);

		while (scr.hasNext()) {
			String firstLine = scr.nextLine();
			String[] separateLine = firstLine.split(" ");
			char letters = firstLine.charAt(0);

			if (letters == 'A') {
				// add to tree
				Calendar date = getDate(separateLine[1]);
				double sales = Double.parseDouble(separateLine[2]);
				tree.add(date, sales);

			} else if (letters == 'D') {
				// remove from tree
				Calendar date = getDate(separateLine[1]);
				tree.remove(date);

			} else if (letters == 'S') {
				// get the amount of the most recent sale
				BTNode<Calendar, Double> most = getMostRecent(tree.root);
				if (most == null) {
					System.out.println("$0.00");
				} else {
					System.out.println("$" + String.format("%.2f", most.value));
				}

			} else if (letters == 'K') {
				// get the total amount of the k most recent sales
				int k = Integer.parseInt(separateLine[1]);
				double total = getTotalMostRecent(tree.root, k);
				String roundedSales = String.format("%.2f", total);
				System.out.println("$" + roundedSales);

			} else if (letters == 'G') {
				// get the total amount of sales in the k days starting on a
				// given date
				Calendar date = getDate(separateLine[1]);
				int k = Integer.parseInt(separateLine[2]);
				double sales = getAtStartingDate(date, k);
				String roundedSales = String.format("%.2f", sales);
				System.out.println("$" + roundedSales);

			} else if (letters == 'R') {
				// get the total amount of all sales within a range of dates
				Calendar startDate = getDate(separateLine[1]);
				Calendar endDate = getDate(separateLine[2]);
				double sales = getSalesInRange(startDate, endDate);
				String roundedSales = String.format("%.2f", sales);
				System.out.println("$" + roundedSales);
			}

		}
		scr.close();
	}

	/**
	 * getSalesInRange takes in a startDate and an endDate to determine the
	 * total sales within the range of these dates.
	 * 
	 * @param startDate
	 *            of the range
	 * @param endDate
	 *            of the range
	 * @return sales the total sales
	 */
	private double getSalesInRange(Calendar startDate, Calendar endDate) {
		if(startDate.compareTo(endDate)>0){
			GregorianCalendar temp= (GregorianCalendar) startDate;
			endDate=startDate;
			startDate=temp;
		}
		BTNode<Calendar, Double>curDate= tree.getNodeWithKey(tree.root, startDate);
		if(curDate==null){
			tree.add(startDate, new Double(0));
			curDate=tree.getNodeWithKey(tree.root, startDate);
			
			
		}
		
		double total= new Double(0);
		while(curDate != null && curDate.key.compareTo(endDate)<=0){
			total+= curDate.value;
			curDate= successor(curDate, tree.root);
			
		}
		return total;
	}

	/**
	 * getAtStartingDate get the total amount of sales in the k days starting on
	 * a given date recent sales.
	 * 
	 * @param date
	 *            the starting date
	 * @param k
	 *            days
	 * @return sales total sales
	 */
	public double getAtStartingDate(Calendar date, int k) {
		Calendar startDate = (Calendar) date.clone(); // start date
		date.add(Calendar.DAY_OF_MONTH, k);
		Calendar endDate = date; // end date

		double sales = 0.00;
		while (startDate.compareTo(endDate) < 0) {

			if (tree.getNodeWithKey(tree.root, startDate) != null) {
				sales += tree.getNodeWithKey(tree.root, startDate).value;
			}
			startDate.add(Calendar.DAY_OF_MONTH, 1);

		}
		return sales;

	}

	/**
	 * successor takes in a node and the root to determine the successor of the
	 * node with in-order traversal.
	 * 
	 * @param node
	 * @param root
	 * @return successor of the node
	 */
	public BTNode<Calendar, Double> successor(BTNode<Calendar, Double> node, BTNode<Calendar, Double> root) {
		// check if is it is the largest element in the tree by using
		// getMostRecent method
		if (getMostRecent(root).equals(node)) {
			
			return null;
		} else if (node.isLeaf() || node.right == null) { // if the node is a
			// leaf
			while (node.parent.key.compareTo(node.key) < 0) {
				node = node.parent;
			}
			return node.parent;
		} else {// if the node is not a leaf
			node = node.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;

		}
	}

	/**
	 * predecessor takes in a node and the root to determine the predecessor of
	 * the node with in-order traversal.
	 * 
	 * @param node
	 * @param root
	 * @return predecessor of the node
	 */
	public BTNode<Calendar, Double> predecessor(BTNode<Calendar, Double> node, BTNode<Calendar, Double> root) {
		// if smallest of the tree, return null
		if (findSmallest(root).equals(node)) {
			return null;
		} else if (node.isLeaf() || node.left == null) {
			while (node.parent.key.compareTo(node.key) > 0) {
				node = node.parent;
			}
			return node.parent;
		} else {
			node = node.left;
			while (node.right != null) {
				node = node.right;

			}
			return node;
		}
	}

	/**
	 * getTotalMostRecent, taking in a node and an integer k, gets the total
	 * amount of the k most recent sales.
	 * 
	 * @param node
	 * @param k
	 * @return total sales
	 */
	private double getTotalMostRecent(BTNode<Calendar, Double> node, int k) {
		int i = 0;
		double total = 0;
		if (getMostRecent(tree.root) != null) {
			BTNode<Calendar, Double> last = getMostRecent(tree.root);

			while (i < k) {
				total += last.value;
				last = predecessor(last, tree.root);
				i++;
			}
		}

		return total;
	}

	/**
	 * findSmallest finds the node with the smallest key in the tree
	 * 
	 * @param node
	 * @return node the smallest
	 */
	private BTNode<Calendar, Double> findSmallest(BTNode<Calendar, Double> node) {
		if (tree.size == 0) {
			return null;
		} else if (tree.size == 1) {
			return tree.root;
		} else {
			if (node.left == null) {
				return node;
			}
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}
	}

	/**
	 * getMostRecent finds the largest node in the tree. In this particular case
	 * with the key being the date, the method returns the node with the most
	 * recent date
	 * 
	 * @param node
	 * @return node with the most recent date
	 */
	private BTNode<Calendar, Double> getMostRecent(BTNode<Calendar, Double> node) {
		if (tree.size == 0) {
			return null;
		} else if (tree.size == 1) {
			return tree.root;
		} else {
			if (node.right == null) {
				return node;
			}
			while (node.right != null) {
				node = node.right;
			}
			return node;
		}
	}

	/**
	 * getDate gets the date
	 * 
	 * @param str
	 * @return cal the date in calendar
	 */
	public GregorianCalendar getDate(String str) {
		String[] date = str.split("/");
		int month = Integer.parseInt(date[0]);
		int day = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);

		GregorianCalendar cal = new GregorianCalendar(year, month, day);

		return cal;

	}

	public static void main(String[] args) {
		SalesData sd = new SalesData();
		sd.readFile();

	}
}