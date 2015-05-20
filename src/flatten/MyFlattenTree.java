/**
 *
 */
package flatten;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack Xu
 *
 * @param <T>
 */
public class MyFlattenTree<T> implements FlattenTree<T> {

	/**
	 * called by left-type {@linkplain Either}
	 */
	private final Function<T, T> leftF = new Function<T, T>() {
		@Override
		public T apply(T p) {
			return p;
		}
	};

	/**
	 * called by right-type {@linkplain Either}
	 */
	private final Function<Triple<Tree<T>>, T> rightF = new Function<Triple<Tree<T>>, T>() {
		@Override
		public T apply(Triple<Tree<T>> p) {
			// traverse the left
			if (p.left() != null) {
				flattenInOrder(p.left());
			}
			// traverse the middle
			if (p.middle() != null) {
				flattenInOrder(p.middle());
			}
			// traverse the right
			if (p.right() != null) {
				flattenInOrder(p.right());
			}
			return null;
		}
	};

	/**
	 * Storing leaf value
	 */
	private List<T> leaves = new ArrayList<T>();

	@Override
	public List<T> flattenInOrder(Tree<T> tree) {
		if (tree == null) {
			 throw new IllegalArgumentException();
		}

		if (tree.get().isLeft()) {
			// it must be a leaf
			leaves.add(tree.get().ifLeft(leftF));
			return leaves;
		} else {
			// it must be a node of branch
			tree.get().ifRight(rightF);
		}
		return leaves;
	}

}
