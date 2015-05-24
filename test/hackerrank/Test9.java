package hackerrank;

public class Test9 {

	private static final String[] BASE7= {
		"0", // 0
		"a", // 1
		"t", // 2
		"l", // 3
		"s", // 4
		"i", // 5
		"n"  // 6
		};

	public String convert(long input) {
		if (input<7) {
			return BASE7[(int) input];
		}
		return convert(input/7) + convert(input%7);
	}

}
