package Day1Inheritancepack;

public class Sports implements Track, Field
{
	public void track_events(int x , int y)
	   {
	      System.out.println(x + " meter "+y+" meter"); 
	   }
	   public void field_events(String x , String y)
	   {
	       System.out.println(x + "  "+y );
	   }
}

