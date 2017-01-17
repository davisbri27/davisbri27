package hw07;

/**
 * A sortable DoublyLinkedList.  The fields and the DLLNode class in the
 * CS232DoublyLinkedList class are protected fields and can be accessed
 * directly in this class.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version April 7, 2016
 */
public class CS232SortableLinkedList<E extends Comparable<E>> extends
		CS232DoublyLinkedList<E> {

	/**
	 * Implementation of insertion sort for the LinkedList. The elements of the
	 * list will be sorted according to the order imposed by their compareTo
	 * method.
	 */
	public void insertionSortList() {
		// Intentionally not implemented - see homework assignment.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Sort the linked list using an in-place, stable merge sort.
	 */
	public void mergeSortList() {
		// Intentionally not implemented - see homework assignment.
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
