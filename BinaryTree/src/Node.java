/**
 * 
 */

/**
 * @author Jonathan
 *
 */
public class Node {
	int data;
	Node left;
	Node right;
	
	// constructor for a Node object with given data o
	public Node (int i) {
		data = i;
		left = null;
		right = null;
	}
	
	// find the next largest Node given a Node n
	// only called from Tree when removing a Node with two children
	public Node successor() {
		Node current = this; // used to return successor Node
		
		// find smallest value of right subtree
		current = current.right;
		while (current.left != null) {
			current = current.left;
		}
		return current;
		
	}
	
}
