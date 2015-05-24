/**
 *
 */
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jack Xu
 *
 */
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < number; i++) {
			list.add(sc.nextInt());
		}
		Integer[] ints = list.toArray(new Integer[]{});
		int diff = 0;
		for (int i = 0; i < ints.length-1; i++) {
			if (ints[i+1] - ints[i] == diff) {
				break;
			} else {
				diff = ints[i+1] - ints[i];
			}
		}
		for (int i = 0; i < ints.length; i++) {
			if (ints[i+1] != ints[i] + diff) {
				System.out.println(ints[i] + diff);
				break;
			}
		}
	}

}
