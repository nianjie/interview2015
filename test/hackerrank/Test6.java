/**
 * 
 */
package hackerrank;

import java.util.Scanner;

/**
 * @author dev1
 *
 */
public class Test6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int round = sc.nextInt();
		while (round-- > 0) {
			System.out.println(possibleWin(sc.nextInt(), sc.nextInt(),
					sc.next()) ? "YES" : "NO");
		}
		sc.close();
	}

	private static boolean possibleWin(int size, int jump, String next) {
		String[] board = next.split(" ");
		for (int i = 0; i < size; i++) {

		}
		return false;
	}

}
