package Day1inpa;

public class Shape 
{
	public static void main(String[] args)
	{
	    Cost pro1 = new Cost(2 , 5, 6, "blue", 50);// child ref child obj
		System.out.println(pro1.height);
		Box pro2 = new Cost(4 , 6, 1, "red", 100);// parent ref child obj
		System.out.println(pro2.length);
		
	}

}
