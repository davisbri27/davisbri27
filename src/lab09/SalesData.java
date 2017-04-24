package lab09;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import lab09.CS232LinkedAVLTree.AVLNode;
import lab09.CS232LinkedBinaryTree.BTNode;

public class SalesData {
	private CS232LinkedAVLTree<Calendar, Double> tree;

	public SalesData() {
		tree = new CS232LinkedAVLTree<Calendar, Double>();

	}

	public void readFile() {
		Scanner scr = new Scanner(System.in);

		while (scr.hasNext()) {
			String firstLine = scr.nextLine();
			String[] separateLine = firstLine.split(" ");
			// String letter= separateLine[0];

			char letters = firstLine.charAt(0);
			// Calendar date= getDate(separateLine[1]);
			// double sales= Double.parseDouble(separateLine[2]);

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
				double most = getMostRecent(tree.root);
				System.out.println("$" + most);

			} else if (letters == 'K') {
				// get the total amount of the k most recent sales
				int k = Integer.parseInt(separateLine[1]);
				//System.out.println(k);

				double total = getTotalMostRecent(tree.root, k);
				System.out.println("$" + total);

			} else if (letters == 'G') {
				Calendar date = getDate(separateLine[1]);
				int k = Integer.parseInt(separateLine[2]);
				// get the total amount of sales in the k days starting on a
				// given date
				double sales = getAtStartingDate(date, k);
				System.out.println("$" + sales);
			} else if (letters == 'R') {
				// get the total amount of all sales within a range of dates
				Calendar startDate = getDate(separateLine[1]);
				Calendar endDate = getDate(separateLine[2]);
				double sales = getSalesInRange(startDate, endDate);
				System.out.println("$" + sales);
			}

		}

	}

	private double getSalesInRange(Calendar startDate, Calendar endDate) {
		double sales = 0;
		BTNode<Calendar, Double> curNode = tree.getNodeWithKey(tree.root, startDate);
		while (curNode.key.compareTo(endDate) == -1) { // while the date of the
														// current node is less
														// than the end date
			sales += curNode.value;
			curNode = successor(curNode, tree.root);

		}
		return sales;

	}

	public double getAtStartingDate(Calendar startDate, int k) {

		int i = 0;
		double sales = 0;
		BTNode<Calendar, Double> curNode = tree.getNodeWithKey(tree.root, startDate);
		while (i < k) {
			// find successor
			BTNode<Calendar, Double> successorNode = successor(curNode, tree.root);
			if (successorNode != null) {
				sales += successorNode.value;
				i++;
				curNode = successorNode;
			} else {
				i = k; // no successor, stop while loop
			}
		}

		return sales;

	}

	public BTNode<Calendar, Double> successor(BTNode<Calendar, Double> node, BTNode<Calendar, Double> root) {
		// check if is it is the largest element in the tree by using
		// getMax method
		if (getMax(root).equals(node)) {
			System.out.println("No successor");
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

	public BTNode<Calendar, Double> predecessor(BTNode<Calendar, Double> node, BTNode<Calendar, Double> root) {
		// if smallest of the tree, return null
		if (findSmallest(root).equals(node)) {
			System.out.println("No predecessor");
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

	private double getTotalMostRecent(BTNode<Calendar, Double> node, int k) {
		int i = 0;
		double total = 0;
		BTNode<Calendar, Double> last = getMax(tree.root);

		while (i < k) {
			total += last.value;
			last = predecessor(last, tree.root);
			i++;
		}

		return total;
	}

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

	private BTNode<Calendar, Double> getMax(BTNode<Calendar, Double> node) {
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

	private double getMostRecent(BTNode<Calendar, Double> node) {
		/*
		 * while(node.right!=null){ node=node.right; } return node.parent.value;
		 */

		/*
		 * while(!node.isLeaf()){ if(node.right!=null){ node=node.right; } }
		 * return node.value;
		 */

		while (!node.isLeaf()) {

			if (node.right != null) {
				node = node.right;
			} else if (node.left != null) {
				node = node.left;
			}

		}
		return node.value;
	}

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
