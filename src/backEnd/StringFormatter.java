package backEnd;

public class StringFormatter {
	public static String stringFormat(String str, int len) {
		return String.format("%-" + len + "s", str);
	}
}
