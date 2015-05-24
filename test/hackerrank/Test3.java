/**
 * 
 */
package hackerrank;

import java.util.Scanner;

/**
 * @author dev1
 *
 */
public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int length = sc.nextInt();
		int i = 0;
		String minStr = null;
		String maxStr = null;
		while (str.length() - i > length) {
			if (minStr == null) {
				minStr = str.substring(i, i + length);
			}
			if (maxStr == null) {
				maxStr = str.substring(i, i + length);
			}
			if (str.substring(i, i + length).compareTo(minStr) < 0) {
				minStr = str.substring(i, i + length);
			}
			if (str.substring(i, i + length).compareTo(maxStr) > 0) {
				maxStr = str.substring(i, i + length);
			}
			i++;
		}
		System.out.println(minStr);
		System.out.println(maxStr);
		sc.close();
	}

}
