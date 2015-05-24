/**
 * 
 */
package hackerrank;

/**
 * @author dev1
 *
 */
public class Test7 {

	public int getNumberOfPrimes(int N) {
		// http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
		boolean[] list = new boolean[N];
		for (int i = 2; i < list.length; i++) {
			if (!list[i]) {
				for (int j = 2; j < list.length; j++) {
					if (j * i > list.length - 1) {
						break;
					}
					list[j * i] = true;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < list.length; i++) {
			if (!list[i]) {
				count++;
			}
		}
		return count;
	}
}
