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
		DLLNode<E> cur = head.next; 
		
		while(cur.next!=null){
				DLLNode<E> temp=cur;
				while(temp.prev !=head && temp.element.compareTo( temp.prev.element) < 0){
					E tempE= temp.element;
					temp.element= temp.prev.element;
					temp.prev.element= tempE;
						//System.out.println("here");
						temp=temp.prev;
				}
				cur=cur.next;
			

		}
	}







	/**
	 * Sort the linked list using an in-place, stable merge sort.
	 */
	public void mergeSortList() {
		// Intentionally not implemented - see homework assignment.
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
