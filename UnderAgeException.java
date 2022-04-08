package day3customexception;
import java.io.*;
public class UnderAgeException extends Exception
{
	public UnderAgeException (String s)
	{
		super(s);
	}
}
