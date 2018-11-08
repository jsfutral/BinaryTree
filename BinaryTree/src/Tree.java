/**
 * 
 */


public class Tree {
	Node root;
	
	// default constructor
	public Tree () {
		root = null;
	}
	
	// constructor for a tree given a Node to use as root
	public Tree( Node n) {
		root = n;
	}
	
	// allows user to search for an integer in the tree
	public boolean search (int i) {
		Node n = new Node(i);
		return search(n);
	}
	
	// finds a Node with a given value in the tree
	public boolean search (Node n) {
		// start at root of tree
		Node current = root;
		
		// traverse through tree to find value
		while (current != null) {
			if (n.data > current.data) 
				current = current.right;
			else if (n.data < current.data) 
				current = current.left;
			else if (n.data == current.data)
				return true;
		}
		
		// value is not found in tree
		return false;
	}
	
	// allows user to insert into the tree with an integer instead of Node
	public Node insert (int i) {
		Node n = new Node(i);
		return insert(n);
	}
	
	// inserts a new Node into the tree
	public Node insert (Node n) {
		// case for insertion into empty tree
		if (root == null) { 
			root = n;
			return root;
		}
		
		Node current = root;
		
		// traverse until empty leaf is found
		while (current != null) {
			
			if (n.data > current.data) {
				// if right leaf is empty, store node there
				if (current.right == null) {
					current.right = n;
					return current.right;
				}
				
				current = current.right;				
			}
			
			else if (n.data < current.data) {
				// if left leaf is empty, store node there
				if (current.left == null) {
					current.left = n;
					return current.left;
				}
				current = current.left;
			}
			
			// data is already in tree
			else if (n.data == current.data)
				return current;
		}
		
		return null;
	}
	
	public boolean remove (Node n) {
		
		return false;
	}
}
