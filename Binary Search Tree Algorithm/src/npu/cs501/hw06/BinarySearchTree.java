package npu.cs501.hw06;

public class BinarySearchTree {
	Node root; // A data member that points to the root node of the tree

	// A constructor that takes an int[] array as argument and build the BST
	// from the array
	public BinarySearchTree(int[] array) {
		for (int i = 0; i < array.length; i++) {
			Node node = new Node(array[i]);
			insert(this, node);
			if (i == 0)
				this.root = node;
		}
	}

	// An iterativeSearch method that can be used to search for a node with the
	// given key value
	public Node iterativeSearch(Node x, int key) {

		while (x != null && key != x.key) {
			if (key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		return x;
	}

	// A insert method to insert a node into the tree
	public void insert(BinarySearchTree T, Node z) {
		Node y = null;
		Node x = T.root;
		if (z == null)
			return;
		while (x != null) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		z.parent = y;
		if (y == null)
			T.root = z;
		else if (z.key < y.key)
			y.left = z;
		else
			y.right = z;

	}

	// A successor method that finds the successor for a given node
	public Node successor(Node x) {

		if (x.right != null)
			return minimum(x.right);
		Node y = x.parent;
		while (y != null && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;

	}

	// A minimum method that finds the minimum value in any of the subtrees,
	// given a node x (not just from the root and not just the minimum of the
	// entire input array)
	public Node minimum(Node x) {
		while (x.left != null)
			x = x.left;
		return x;

	}

	// An inorderTreeWalk method that can be used to display the results from
	// the in-order treewalk, starting from any given node
	public void inorderTreeWalk(Node x) {
		if (x != null) {
			inorderTreeWalk(x.left);
			System.out.print(x.key + " ");
			inorderTreeWalk(x.right);

		}
	}

	// the main method inside of the binary search tree class to test your codes
	public static void main(String[] args) {

		// Use the input array A = {10, 15, 12, 7, 8, 5, 6, 9, 20, 18, 22}
		int[] A = { 10, 15, 12, 7, 8, 5, 6, 9, 20, 18, 22 };

		// Build the binary search tree for this input
		BinarySearchTree tree = new BinarySearchTree(A);

		// Do the inorderTreeWalk to display the results (this should show the
		// sorted list)
		System.out.print(" Inorder tree walk: ");
		tree.inorderTreeWalk(tree.root);

		// Use the minimum method to find the minimum, starting from the node
		// with key = 10
		System.out.print("\n Minimum from node.key = 10 is ");
		Node x = tree.iterativeSearch(tree.root, 10);
		Node minNode = tree.minimum(x);
		System.out.print(minNode.key);

		// Find the successor to the root node, and display the result on the
		// screen
		System.out.print("\n Successor to the root node is ");
		Node successorNode = tree.successor(tree.root);
		if (successorNode != null)
			System.out.print(successorNode.key);
		else
			System.out.print(" not Found");

		// Find the successor to node with key = 9, and display the result on
		// the screen
		System.out.print("\n Successor to node.key = 9 is ");
		x = tree.iterativeSearch(tree.root, 9);
		successorNode = tree.successor(x);
		if (successorNode != null)
			System.out.print(successorNode.key);
		else
			System.out.print(" not Found");

	}

}
