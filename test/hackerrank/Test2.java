/**
 * 
 */
package hackerrank;

import java.util.Scanner;

/**
 * @author dev1
 *
 */
public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			int accum = a;
			for (int j = 0; j < n; j++) {
				accum = (int) (accum + Math.pow(2, j) * b);
				System.out.print(accum);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
