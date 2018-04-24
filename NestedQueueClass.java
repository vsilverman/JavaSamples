//
// This program shows how to:
// - use JUnit to test the nested class, which resolves the following task:
// ----------------------------------
// implement a fixed-capacity queue that uses a fixed-sized array for storage. 
// The queue should have one method to add a new element and another that both 
// removes an element and returns it.
// ----------------------------------

import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;

public class NestedQueueClass {
	
	public static MyQueue MYQ = new MyQueue();
    
    public static class MyQueue {
        
        public static int SIZE=3;
        public static int[] q = new int[SIZE];
        public static int current = -1;

        public boolean add(int a) {
            boolean res = false;
            if (current < SIZE-1) {
                current++;
                q[current] = a;                
                res=true;
                System.out.println ("element " + a + " is added to the queue");
            }
            else
                System.out.println ("queue is full");
            return res;            
        }
        
        public int del() throws NoSuchElementException {
            int de = 0;
            if (current == -1) {
                 throw new java.util.NoSuchElementException("Queue is empty - nothing to delete");
            }
            else 
                 de = q[current];   
                 q[current] = 0;
            	 current--;
                 System.out.println ("deleted element: " + de);
            return de;
        }
    
    } // end of MyQueue
    
    
    @Test
    public void addFirstElem() {
    	NestedQueueClass.MyQueue.current = -1;
        MYQ.add(10);
        assertTrue("adding first element failed", NestedQueueClass.MyQueue.current == 0);
    }
    
    @Test
    public void addLastElem() {
    	NestedQueueClass.MyQueue.current = NestedQueueClass.MyQueue.SIZE-2;
        MYQ.add(30);
        assertTrue("adding last element failed", NestedQueueClass.MyQueue.current == NestedQueueClass.MyQueue.SIZE-1);
    }
    
    @Test
    public void addToFullQueue() {
    	NestedQueueClass.MyQueue.current = NestedQueueClass.MyQueue.SIZE-1;
        MYQ.add(40);
        assertTrue("testing addition to full queue failed", NestedQueueClass.MyQueue.current == NestedQueueClass.MyQueue.SIZE-1);
    }
    
    @Test
    public void delLastElem() {
    	NestedQueueClass.MyQueue.current = NestedQueueClass.MyQueue.SIZE-1;
        int de = MYQ.del();
        assertTrue("deleting last element failed", NestedQueueClass.MyQueue.current == NestedQueueClass.MyQueue.SIZE-2);
    }
    
    @Test
    public void delFirstElem() {
    	NestedQueueClass.MyQueue.current = 0;
        int de = MYQ.del();
        assertTrue("deleting last element failed", NestedQueueClass.MyQueue.current == -1);
    }

    @Test
    public void delFromEmptyQueue() {
    	NestedQueueClass.MyQueue.current = -1;
    	try {
        	int de = MYQ.del();
    	}
    	catch (NoSuchElementException nsee) {
    		System.out.println("For continuous testing catching exception thrown while deleting empty queue");
    	}
        assertTrue("testiong deletion from empty queue failed", NestedQueueClass.MyQueue.current == -1);
    }

	/**
	 * @param args
	 */
    public static void main(String[] args) {
        int delElem;
        for (int i=10; i<=40; i+=10) {
        	MYQ.add(i); 
        }
        for (int j=0; j<4; j++) {
        	try {
            	delElem = MYQ.del();
        	}
        	catch (NoSuchElementException nsee) {
        		nsee.printStackTrace();
        		System.out.println("\nCatching exception for continuous testing");
        	}
        }
    }

}    
    
    
    
    
