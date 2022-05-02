package eLearning;

public class StringFormatter {
	public static String stringFormat(String str,int x)
	{
		return String.format("%-"+x+"s",str);
	}
}
