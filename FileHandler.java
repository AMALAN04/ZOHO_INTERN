package Day3FileHandlingPa;
//import java.util.*;
import java.io.*;

public class FileHandler 
{
	
	public static void main(String[] args) 
	{
		try 
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writing = new BufferedWriter(new FileWriter ("data1.txt"));
			String s = input.readLine();
			writing.write(s);
			writing.write("\nI'm from mettur");
			writing.close();
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
		try 
		{
			BufferedReader Reading = new BufferedReader(new FileReader ("data1.txt"));
			String line;
			while((line=Reading.readLine())!= null)
					{
				      System.out.print(line+"\n");
					}
			Reading.close();
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
	}

}
