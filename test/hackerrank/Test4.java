/**
 * 
 */
package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author dev1
 *
 */
public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());
		System.out.println(a.add(b).toString());
		System.out.println(a.multiply(b).toString());
		sc.close();
	}

}
