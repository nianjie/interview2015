/**
 *
 */
package test;

/**
 * @author Jack Xu
 *
 */
public class Test2 {

	   class Node {
	       Node left, right;
	       int data;
	               Node(int newData) {
	           left = right = null;
	           data = newData;
	       }
	   }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

	/* Write your custom functions here */
	static int diameterOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int lh = height(root.left);
		int rh = height(root.right);

		int ld = diameterOfTree(root.left);
		int rd = diameterOfTree(root.right);

		return Math.max((lh + rh + 1), Math.max(ld, rd));
	}

	private static int height(Node base) {
		if (base == null) {
			return 0;
		}
		return 1 + Math.max(height(base.left), height(base.right));
	}
}
