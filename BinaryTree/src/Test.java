
public class Test {

	public static void main(String[] args) {
		Tree tree = new Tree();

		
		tree.insert(1);
		tree.insert(3);
		tree.insert(2);
		tree.insert(5);
		tree.insert(4);

		
		System.out.println(tree.search(3).successor().data);
		System.out.println(tree.findParent(2).data);

		tree.inOrder(tree.root);
		System.out.println();
		tree.remove(4);
		tree.inOrder(tree.root);
		System.out.println();
		tree.remove(5);
		tree.remove(2);
		tree.inOrder(tree.root);
		System.out.println();

	}

}
