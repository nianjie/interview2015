package hackerrank;

import static org.junit.Assert.*;
import hackerrank.Test8.LinkedListNode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test8Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind1() {
		LinkedListNode main = Test8.create(new int[]{1,2,3,4,5});
		LinkedListNode sub = Test8.create(new int[]{4,5});

		Test8 target = new Test8();
		int actual = target.find(main, sub);
		assertEquals("Oops!", 3, actual);
	}

	@Test
	public void testFind2() {
		LinkedListNode main = Test8.create(new int[]{1,2,3,4,5});
		LinkedListNode sub = Test8.create(new int[]{1,2});

		Test8 target = new Test8();
		int actual = target.find(main, sub);
		assertEquals("Oops!", 0, actual);
	}

	@Test
	public void testFind3() {
		LinkedListNode main = Test8.create(new int[]{1,2,3,4,5});
		LinkedListNode sub = Test8.create(new int[]{5});

		Test8 target = new Test8();
		int actual = target.find(main, sub);
		assertEquals("Oops!", 4, actual);
	}

	@Test
	public void testFind4() {
		LinkedListNode main = Test8.create(new int[]{1,2,3,4,5});
		LinkedListNode sub = Test8.create(new int[]{2,2});

		Test8 target = new Test8();
		int actual = target.find(main, sub);
		assertEquals("Oops!", -1, actual);
	}

	@Test
	public void testFind5() {
		LinkedListNode main = Test8.create(new int[]{1,2,3,3,4,5});
		LinkedListNode sub = Test8.create(new int[]{3,4,5});

		Test8 target = new Test8();
		int actual = target.find(main, sub);
		assertEquals("Oops!", 3, actual);
	}

	@Test
	public void testCreate1() {
		LinkedListNode actual = Test8.create(new int[]{1,2,3,4,5});
		assertEquals("Oops", "1", actual.val);
		actual = actual.next;
		assertEquals("Oops", "2", actual.val);
		actual = actual.next;
		assertEquals("Oops", "3", actual.val);
		actual = actual.next;
		assertEquals("Oops", "4", actual.val);
		actual = actual.next;
		assertEquals("Oops", "5", actual.val);
		actual = actual.next;
		assertNull(actual);
	}
}
