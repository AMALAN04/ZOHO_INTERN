package Day1inpa;

public class Colour extends Box
{
	String colour;
    Colour(int h , int w, int l, String c)
    {
        super(h , w, l);// invoke parent
        this.colour=c;
    }
}
