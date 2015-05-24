/**
 * 
 */
package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author dev1
 *
 */
public class Test5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String parentheses = sc.next();
			System.out.println(balanced(parentheses));
		}
		sc.close();
	}

	private static boolean balanced(String parentheses) {
		Deque<String> stack = new ArrayDeque<String>();
		for (int i = 0; i < parentheses.length(); i++) {
			String j = parentheses.substring(i, i + 1);
			if (j.matches("\\[|\\(|\\{")) {
				stack.push(j);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					if (")".equals(j) && stack.peek().equals("(")) {
						stack.pop();
					}
					if ("]".equals(j) && stack.peek().equals("[")) {
						stack.pop();
					}
					if ("}".equals(j) && stack.peek().equals("{")) {
						stack.pop();
					}
				}
			}
		}
		return stack.isEmpty();
	}

}
