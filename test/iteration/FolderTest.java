/**
 *
 */
package iteration;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author JMAS-0782
 *
 */
public class FolderTest {

	List<Integer> array1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	Function2<Integer, Integer, Integer> add;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		add = new Function2<Integer,Integer,Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}

		};
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		MyFolder<Integer, Integer> target = new MyFolder<Integer, Integer>();
		assertEquals("not correct!", target.fold(Integer.valueOf(0), new LinkedList<Integer>(array1), add), Integer.valueOf(55));
	}

	@Test
	public void test2() {
		YourFolder<Integer, Integer> target = new YourFolder<Integer, Integer>();
		assertEquals("not correct!", target.fold(Integer.valueOf(0), new LinkedList<Integer>(array1), add), Integer.valueOf(55));
	}

	@Test
	public void test3() {
		MyFolder<Integer, Integer> target = new MyFolder<Integer, Integer>();
		assertEquals("not correct!", target.fold(Integer.valueOf(88), new LinkedList<Integer>(), add), Integer.valueOf(88));
	}

	@Test
	public void test4() {
		YourFolder<Integer, Integer> target = new YourFolder<Integer, Integer>();
		assertEquals("not correct!", target.fold(Integer.valueOf(88), new LinkedList<Integer>(), add), Integer.valueOf(88));
	}

	@Test
	public void test5() {
		MyFolder<Integer, Integer> target = new MyFolder<Integer, Integer>();
		LinkedList<Integer> q = new LinkedList<Integer>(array1);
		assertEquals("not correct!", target.fold(Integer.valueOf(0), q, add), Integer.valueOf(55));
		assertTrue(q.isEmpty());
	}

	@Test
	public void test6() {
		YourFolder<Integer, Integer> target = new YourFolder<Integer, Integer>();
		LinkedList<Integer> q = new LinkedList<Integer>(array1);
		assertEquals("not correct!", target.fold(Integer.valueOf(0), q, add), Integer.valueOf(55));
		assertTrue(q.isEmpty());
	}
}
