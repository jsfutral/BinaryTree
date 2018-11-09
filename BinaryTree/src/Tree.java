/**
 * Defines the Tree class
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
	public Node search (int i) {
		Node n = new Node(i);
		return search(n);
	}
	
	// finds a Node with a given value in the tree
	public Node search (Node n) {
		// start at root of tree
		Node current = root;
		
		// traverse through tree to find value
		while (current != null) {
			if (n.data > current.data) 
				current = current.right;
			else if (n.data < current.data) 
				current = current.left;
			else if (n.data == current.data)
				return current;
		}
		
		// value is not found in tree
		return null;
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
	
	// remove a value from the tree given an integer
	public boolean remove(int i) {
		Node n = search(i);
		if (n == null)
			return false;
		else
			return remove(n);
	}
	
	// remove a node from a tree
	public boolean remove (Node n) {
		
		// tree is empty
		if (root == null) {
			return false;
		}
		
		// Node has no children
		if (n.left == null && n.right == null) {
			// case for removing root 
			if (n.data == root.data) {
				root = null;
				return true;
			}
			
			// Unassigns pointer from parent node
			Node parent = findParent(n.data);
			if (n.data < parent.data) 
				parent.left = null;
			else if (n.data > parent.data)
				parent.right = null;
			return true;
		}
		// Node only has right child
		else if (n.left == null) {
			// case for removing root
			if (n.data == root.data) {
				root = root.right;
				return true;
			}
			
			// find parent and reassign right child to leaf that is being removed
			Node parent = findParent(n.data);
			if (n.data < parent.data) 
				parent.left = n.right;
			else if (n.data > parent.data)
				parent.right = n.right;
			return true;
			
		}
		// Node only has left child
		else if (n.right == null) {
			// case for removing root
			if (n.data == root.data) {
				root = root.left;
				return true;
			}
			
			// find parent and reassign right child to leaf that is being removed
			Node parent = findParent(n.data);
			if (n.data < parent.data) 
				parent.left = n.left;
			else if (n.data > parent.data)
				parent.right = n.left;
			return true;
		}
		// Node has two children
		else {
			// the right child of n is its own successor
			if (n.right.left == null) {
				n.data = n.right.data; // change value of n to successor
				n.right = n.right.right; // remove successor from the tree
				return true;
			}
			
			// Find the successor and its parent
			Node successor = n.successor();
			Node sParent = findParent(successor.data);
			
			n.data = successor.data; // replace data with that of successor
			sParent.left = successor.right; // remove Node from tree by bridging pointers
			return true;
		}	
	}
	
	// helper method for remove to find the parent of a Node
	public Node findParent (int i) {
		Node current = root; 
		Node parent = null; // keeps track of previous node, to be stored as parent
		
		// traverse through tree to find value and update parent
		while (current != null) {
			if (i > current.data) {
				parent = current;
				current = current.right;
			}
			else if (i < current.data) {
				parent = current;
				current = current.left;
			}
			// data is found
			else if (i == current.data)
				return parent;

		}
		// value is not in tree
		return null;
	}
	
	public void inOrder() {
		inOrder(root);
		System.out.print('\n');
	}
	// prints out all elements in increasing order
	private void inOrder ( Node n ) {
		if (n.left != null)
			inOrder( n.left );
		System.out.print("" + n.data +  ' ');
		if (n.right != null)
			inOrder( n.right );
	}	
	
}
