import java.util.ArrayList;
import java.util.Arrays;


public class MyBinTree {
  
	static class Node {
		Node left;
		Node right;
		
		int value;
		
		public Node (int value) {
			this.value = value;
		}
		
		public static void insert(Node node, int value) {
			  if (value < node.value) {
				  if (node.left != null) {
					  insert(node.left, value);
				  } 
				  else {
					  System.out.println("  Inserted " + value + 
							  " to left of node " + node.value);
					  node.left = new Node(value);
				  }
			  } 
			  else if (value > node.value) {
				  	if (node.right != null) {
				  		insert(node.right, value);
				  	} 
				  	else {
				  		System.out.println("  Inserted " + value + 
				  			" to right of node " + node.value);
				  		node.right = new Node(value);
				  	}
			  }
		  }
		
		 public static void printInOrder(Node node) {
			  if (node != null) {
				  printInOrder(node.left);
				  System.out.println("  Traversed " + node.value);
				  printInOrder(node.right);
			  }
		 }
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBinTree tree = new MyBinTree();
		Node rootnode;
		ArrayList<Integer> arrList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		for (Integer rootvalue: arrList) {
			rootnode = new Node(rootvalue.intValue());
			System.out.println("Building tree with rootvalue "
					+ rootnode.value);
			for (Integer i: arrList) {
				MyBinTree.Node.insert(rootnode, i.intValue());
			}
			System.out.println("\nTraversing tree in order");
			MyBinTree.Node.printInOrder(rootnode);
			System.out.println("=================================");
		}

	}

}
