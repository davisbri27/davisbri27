package hw07;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JComboBox.KeySelectionManager;

public class HeapSort {

	public static void heapSort(Integer[] vals) {
		Decrease[] keys= new Decrease[vals.length];
		for(int i=0; i< keys.length; i++){
			keys[i]= new Decrease(vals[i]);
			
		}
			CS232ArrayHeap<Decrease, Integer> heap = new CS232ArrayHeap<Decrease, Integer>(keys, vals); 
			for(int i= vals.length-1; i>=0; i--){
				vals[i] = heap.remove(); 
			}
		
		}
		
		
	
	

	

	
	
	
	private static class Decrease implements Comparable<Decrease> {
	 private Integer val;
	 public Decrease(Integer val) {
	 this.val = val;
	 }
	 public int compareTo(Decrease v) {
	 return -this.val.compareTo(v.val);
	 } 


	/**
	 * Sort a list of integer values into decreasing order using the heap sort.
	 */
	public static void main(String[] args) {
		int size = 20;
		Random rnd = new Random();
		Integer[] list = new Integer[size];
		for (int i = 0; i < list.length; i++) {
			list[i] = rnd.nextInt(100);
		}

		System.out.println("Unsorted List: " + Arrays.toString(list));
		heapSort(list);
		System.out.println("  Sorted List: " + Arrays.toString(list));
	}
	}}
