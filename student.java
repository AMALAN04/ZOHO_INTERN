package Day1enCi;
import java.util.Scanner;
public class student 
{
	public static void main(String[] args)
	{
	    Scanner input =new Scanner(System.in);
	    float radius = input.nextFloat();
	    Circle c1= new Circle();
	    c1.circum_of( radius);
	    c1.area_of(radius);
	    c1.volume_of( radius);
	    
		//System.out.println("Hello World");
	}

}
