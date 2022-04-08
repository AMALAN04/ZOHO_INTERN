package day3customexception;
import java.util.*;
import java.io.*;
public class Voter
{
public static void main(String []arg) throws Exception
{
	Scanner input = new Scanner(System.in);
	int age = input.nextInt();
	try {
	if (age<=18)
	{
		throw new UnderAgeException("Under age Exception");
	}
	}
	catch(Exception e)
	{
	System.out.println(e.getMessage());
	}
	
}
}
