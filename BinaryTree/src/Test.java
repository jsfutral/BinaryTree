
public class Test {

	public static void main(String[] args) {
		Tree tree = new Tree();

		
		tree.insert(1);
		tree.insert(3);
		tree.insert(2);
		tree.insert(5);
		tree.insert(4);

		
		System.out.println(tree.search(1));
		System.out.println(tree.search(2));
		System.out.println(tree.search(3));
		System.out.println(tree.search(4));
		System.out.println(tree.search(5));
	}

}
