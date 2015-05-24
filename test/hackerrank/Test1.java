/**
 * 
 */
package hackerrank;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author dev1
 *
 */
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			String candi = sc.next();
			whatDataTypeFit(candi);
		}
	}

	private static void whatDataTypeFit(String candi) {
		try {
			long data = Long.valueOf(candi);
			System.out.println(String.format("%s can be fitted in:", candi));
			if (data >= Byte.MIN_VALUE && data <= Byte.MAX_VALUE) {
				System.out.println("* byte");
			}
			if (data >= Short.MIN_VALUE && data <= Short.MAX_VALUE) {
				System.out.println("* short");
			}
			if (data >= Integer.MIN_VALUE && data <= Integer.MAX_VALUE) {
				System.out.println("* int");
			}
			System.out.println("* long");

		} catch (Exception e) {
			System.out.println(String.format("%s can't be fitted anywhere.",
					candi));
		}
	}

}
