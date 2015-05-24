package hackerrank;

public class Test9 {

	public String convert(long input) {
		StringBuilder base7 = new StringBuilder();
		do {
			base7.append(convertit(input / 7));
			input = input - 6;
		} while (input > -1);
		return base7.toString();
	}

	private String convertit(long l) {
		if (l == 6) {
			return "n";
		}
		if (l == 5) {
			return "i";
		}
		if (l == 4) {
			return "s";
		}
		if (l == 3) {
			return "l";
		}
		if (l == 2) {
			return "t";
		}
		if (l == 1) {
			return "a";
		}
		if (l == 0) {
			return "0";
		}
		return "";
	}

}
