package sorting.simpleSorting;

import sorting.SortingImpl;
import sorting.Util;

/**
 * A heap sort demonstration algorithm
 */

public class Heapsort<T extends Comparable<T>> extends SortingImpl<T> {

	/**
	   * Make the sub-array starting at position i into a a heap,
	   * assuming that it's left and right children are already 
	   * heaps.
	   */
	
	protected boolean stopRequested = false;
	private int parent;
	
	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {
		// Make the input into a heap
	    for (int i = rightIndex; i >= leftIndex; i--){
	      reheap (array, rightIndex, i);
	    }
	    
	    // Sort the heap
	    for (int i = rightIndex; i > leftIndex; i--) {
	    	Util.swap(array, i, 0);
	      reheap (array, i, 0);
	    }
	}

	protected void reheap(T[] array, int leftIndex, int rightIndex) {
		boolean done = false;
	    T key = array[leftIndex];
	    int parent = leftIndex;
	    int child = 2*(leftIndex+1)-1;
	    while ((child < rightIndex) && (!done)) {
	        if (child < rightIndex - 1) {
	            if (array[child].compareTo(array[child + 1]) < 0) {
	              child += 1;
	            }
	          }
	        
	          if (key.compareTo(array[child]) >= 0) {
	            done = true;
	          }
	          
	          else {
	            array[parent] = array[child];
	            parent = child;
	            child = 2*(parent+1)-1;
	          }
	        }
	    
	        array[parent] = key;
	}
}
