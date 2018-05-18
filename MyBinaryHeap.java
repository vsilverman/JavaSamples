
	/**
	 * The BinaryHeap is a -generic- implementation of the PriorityQueue interface.  
	 * This is a binary min-heap implementation of the priority queue ADT.
	 * 
	 * In min-heap trees the value of each node is greater than or equal
	 * to the value of its parent, with the minimum-value element at the root
	 * Below is an example of a min-heap binary tree
	 * 
	 *               1
 	 *       3               7
	 *    5      15      9      20
	 *  10 12  18  17  11 50   30  
	 *  
	 *  This program keeps the tree structure and
	 *  its data inside array. In case the size of
	 *  the tree (array) is constant and equals N
	 *  it is easy to keep inside this tree the N 
	 *  largest numbers of all supplied.
	 *  Method replaceMinValue() implements this task.
	 *  In the current implementation N = 10 .  
	 *  
	 */
import java.util.Random;
import java.util.Arrays;
//import java.util.PriorityQueue;

/**
 * @author Vlad
 *
 */

//public class MyBinaryHeap<T extends Comparable<T>> implements PriorityQueue<T> {
public class MyBinaryHeap<Integer extends Comparable<Integer>> {

	private static final int DEFAULT_CAPACITY = 10;
	private static final int[] DEFAULT_DATA = {1, 3, 7, 5, 15, 9, 20, 10, 12};
	private Integer[] data;
	private int size;
	    
		/**
	     * Constructs a new BinaryHeap.
	     */
	    @SuppressWarnings("unchecked")
		public MyBinaryHeap () {
	        // Java doesn't allow construction of arrays of placeholder data types 
	        data = (Integer[])new Comparable[DEFAULT_CAPACITY];  
	        size = 0;
	    }
	    
	    
		/**
		 * @return the data
		 */
		public Integer[] getData() {
			return data;
		}


		/**
		 * @param data the data to set
		 */
		public void setData(Integer[] data) {
			this.data = data;
		}


	    /**
		 * @return the size
		 */
		public int getSize() {
			return size;
		}


		/**
		 * @param size the size to set
		 */
		public void setSize(int size) {
			this.size = size;
		}


		/**
	     * Adds a value to the min-heap.
	     */
	    public void add(Integer value) {
	        // grow array if needed
	        if (size >= data.length - 1) {
	            data = this.resize();
	        }        
	        
	        // place element into heap at bottom
	        size++;
	        int index = size;
	        data[index] = value;
	        
	        bubbleUp();
	    }
	    
	    
		/**
	     * Replaces min value with new value.
	     */
	    public void replaceMinValue(Integer value) {
	    	// if new value is greater then min
    		// remove min value and add new one
	    	if (value.compareTo(peek()) > 0) {
		    	remove();
		    	add(value);
	    	}
	    }
	    
	    
	    /**
	     * Returns true if the heap has no elements; false otherwise.
	     */
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    
	    /**
	     * Returns (but does not remove) the minimum element in the heap.
	     */
	    public Integer peek() {
	        if (this.isEmpty()) {
	            throw new IllegalStateException();
	        }
	        
	        return data[1];
	    }

	    
	    /**
	     * Removes and returns the minimum element in the heap.
	     */
	    public Integer remove() {
	    	// return the value to be removed,
	    	// which is the root of the tree,
	    	// i.e. the min value of all elems
	    	Integer result = peek();
	    	
	    	// get rid of the last leaf/decrement
	    	data[1] = data[size];
	    	data[size] = null;
	    	size--;
	    	
	    	bubbleDown();
	    	
	    	return result;
	    }
	    
	    
	    /**
	     * Returns a String representation of BinaryHeap with values stored with 
	     * heap structure and order properties.
	     */
	    public String toString() {
	        return Arrays.toString(data);
	    }
	    

	    
	    /**
	     * Performs the "bubble down" operation to place the element that is at the 
	     * root of the heap in its correct place so that the heap maintains the 
	     * min-heap order property.
	     */
	    private void bubbleDown() {
	        int index = 1;
	        
	        // bubble down
	        while (hasLeftChild(index)) {
	            // which of my children is smaller?
	            int smallerChild = leftIndex(index);
	            
	            // bubble with the smaller child, if I have a smaller child
	            if (hasRightChild(index) && data[leftIndex(index)].compareTo(data[rightIndex(index)]) > 0) {
	                smallerChild = rightIndex(index);
	            } 
	            
	            if (data[index].compareTo(data[smallerChild]) > 0) {
	                swap(index, smallerChild);
	            } else {
	                // otherwise, get outta here!
	                break;
	            }
	            
	            // make sure to update loop counter/index of where last el is put
	            index = smallerChild;
	        }        
	    }
	    
	    
	    /**
	     * Performs the "bubble up" operation to place a newly inserted element 
	     * (i.e. the element that is at the size index) in its correct place so 
	     * that the heap maintains the min-heap order property.
	     */
	    private void bubbleUp() {
	        int index = this.size;
	        
	        while (hasParent(index) && (parent(index).compareTo(data[index]) > 0)) {
	            // parent/child are out of order; swap them
	            swap(index, parentIndex(index));
	            index = parentIndex(index);
	        }        
	    }
	    
	    
	    private boolean hasParent(int i) {
	        return i > 1;
	    }
	    
	    
	    private int leftIndex(int i) {
	        return i * 2;
	    }
	    
	    
	    private int rightIndex(int i) {
	        return i * 2 + 1;
	    }
	    
	    
	    private boolean hasLeftChild(int i) {
	        return leftIndex(i) <= size;
	    }
	    
	    
	    private boolean hasRightChild(int i) {
	        return rightIndex(i) <= size;
	    }
	    
	    
	    private Integer parent(int i) {
	        return data[parentIndex(i)];
	    }
	    
	    
	    private int parentIndex(int i) {
	        return i / 2;
	    }
	    
	    
	    private Integer[] resize() {
	        return Arrays.copyOf(data, data.length * 2);
	    }
	    
	    
	    private void swap(int index1, int index2) {
	        Integer tmp = data[index1];
	        data[index1] = data[index2];
	        data[index2] = tmp;        
	    }
	    
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			MyBinaryHeap mbh = new MyBinaryHeap();
			MyBinaryHeap mbhFixed = new MyBinaryHeap();
			for (int i : DEFAULT_DATA) {
				mbh.add(i);
				mbhFixed.add(i);
			}
			System.out.println(mbh.toString());
			
			int[] input = {6, 16, 11, 14, 2};
			for (int i : input) {
				System.out.println("Adding " + i);
				mbh.add(i);
				System.out.println("Large: " + mbh.toString());
				mbhFixed.replaceMinValue(i);
				System.out.println("Fixed: " + mbhFixed.toString());
			}
		}

}
