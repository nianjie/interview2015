package hackerrank;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test9Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvert() {
		Test9 target = new Test9();
		assertEquals("oops!", "a0", target.convert(7));
	}

	@Test
	public void testConvert2() {
		Test9 target = new Test9();
		assertEquals("oops!", "atlassian", target.convert(7792875));
	}

}
