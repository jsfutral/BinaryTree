
public class Test {

	public static void main(String[] args) {
		Tree tree = new Tree();
		
		// creates a 3 layer full binary tree
		tree.insert(4);
		tree.insert(2);
		tree.insert(5);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(7);
		
		tree.inOrder();
		
		// remove root to test remove function
		tree.remove(4);
		tree.inOrder();
		
		tree.remove(5);
		tree.inOrder();
	}

}
