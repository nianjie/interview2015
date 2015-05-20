package findcommonancestor;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FindCommonAncestorTest {

	//     E---F
	//    /    |
	// A-B-C-D-G
	String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
	String[][] parents ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindCommmonAncestor1() {
		FindCommonAncestor target = new MyFindCommonAncestor();
		assertEquals("not correct!", "B", target.findCommmonAncestor(commits, parents, "D", "F"));
	}
	
	@Test
	public void testFindCommmonAncestor11() {
		FindCommonAncestor target = new MyFindCommonAncestor();
		assertEquals("not correct!", "B", target.findCommmonAncestor(commits, parents, "G", "E"));
	}
	
	@Test
	public void testFindCommmonAncestor12() {
		FindCommonAncestor target = new MyFindCommonAncestor();
		assertEquals("not correct!", "C", target.findCommmonAncestor(commits, parents, "G", "D"));
	}

	@Test
	public void testFindCommmonAncestor13() {
		//     E-F------L
		//    / H-I--J /
		//   / /     |/
		// A-B-C-D-G-K
		String[] commits = {"L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
		String[][] parents ={{"F"},{"G", "J", "L"}, {"I"}, {"H"}, {"C"}, {"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
		FindCommonAncestor target = new MyFindCommonAncestor();
		assertEquals("not correct!", "B", target.findCommmonAncestor(commits, parents, "D", "F"));
	}
	
	@Test
	public void testFindCommmonAncestor14() {
		//     E-F------L
		//    / H-I--J /
		//   / /     |/
		// A-B-C-D-G-K
		//   |
		//   M
		String[] commits = {"M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
		String[][] parents ={{"B"}, {"F"},{"G", "J", "L"}, {"I"}, {"H"}, {"C"}, {"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
		FindCommonAncestor target = new MyFindCommonAncestor();
		assertEquals("not correct!", "B", target.findCommmonAncestor(commits, parents, "K", "M"));
	}
	
	@Test
	public void testFindCommmonAncestor2() {
		FindCommonAncestor target = new YourFindCommonAncestor();
		assertEquals("not correct!", "B", target.findCommmonAncestor(commits, parents, "D", "F"));
	}

	@Test
	public void testFindCommmonAncestor21() {
		FindCommonAncestor target = new YourFindCommonAncestor();
		assertEquals("not correct!", "F", target.findCommmonAncestor(commits, parents, "G", "F"));
	}

	@Test
	public void testFindCommmonAncestor3() {
		//     E-F------L
		//    / H-I--J /
		//   / /     |/
		// A-B-C-D-G-K
		String[] commits = {"L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
		String[][] parents ={{"F"},{"G", "J", "L"}, {"I"}, {"H"}, {"C"}, {"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
		FindCommonAncestor target = new YourFindCommonAncestor();
		assertEquals("not correct!", "B", target.findCommmonAncestor(commits, parents, "D", "F"));
	}


	@Test
	public void testFindCommmonAncestor4() {
		//     E-F------L
		//    / H-I--J /
		//   / /     |/
		// A-B-C-D-G-K
		//   |
		//   M
		String[] commits = {"M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
		String[][] parents ={{"B"}, {"F"},{"G", "J", "L"}, {"I"}, {"H"}, {"C"}, {"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
		FindCommonAncestor target = new YourFindCommonAncestor();
		assertEquals("not correct!", "B", target.findCommmonAncestor(commits, parents, "K", "M"));
	}
	
	@Test
	public void testFindCommmonAncestor5() {
		FindCommonAncestor target = new YourFindCommonAncestor();
		assertEquals("not correct!", "D", target.findCommmonAncestor(commits, parents, "G", "D"));
	}
}
