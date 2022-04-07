package Day1inpa;

public class Cost extends Colour
{
	 int price;
	    Cost(int h , int w, int l, String c, int p)
	    {
	        super(h , w, l, c);// invoke parent
	        this.price = p;
	    }

}
