import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Vlad
 *
 */
public class NodeList {
	
	public class Node {
		public Node next;
		public String value;
		
		public Node(String s) {
			this.value = s;
		}
	}
	
	public Node head;
	public Node reversed;
	
	public NodeList(String[] values) {
		head = new Node(values[0]);
		Node curNode = head;
		for (int i = 1; i < values.length; i++) {
			curNode.next = new Node(values[i]);
			curNode = curNode.next;
		}
		curNode.next = null;
	}
	
	public void reverse (Node head, Node reversed) {
		ArrayList<Node> arlist = new ArrayList<Node>();
		Node temp = head;
		while (temp != null) {
			arlist.add(temp);
			temp = temp.next;
		}
//		int top = arlist.size()-1;
//		reversed = arlist.get(top);
//		for (int i = top-1; i>=0; i--) {
//			reversed.next = arlist.get(i);
//			reversed = reversed.next;
//		}
	}
	
	public void reverse(Node head) {
		Node temp = head;
		reversed = new Node(temp.value);
		Node prev = reversed;
		reversed.next = null;
		while (temp.next != null) {
			temp = temp.next;
			reversed = new Node(temp.value);
			reversed.next = prev;
			prev = reversed;
		}
	}
	
	public void print (String s, Node node) {
		System.out.println ("\n" + s);
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String vals[] = {"one", "two", "three"};
		NodeList nl = new NodeList(vals);
		nl.print("Original list", nl.head);
		nl.reverse(nl.head);
		nl.print("Reversed list", nl.reversed);
	}

}
