package D2ArrayListpa;

public class CustomArray<T> 
{
	private static int default_size =4;
    int size=0;
    Object [] Arraylist = new Object[default_size];
    public void add(T x)
    {
        if(isfull())
        {
            resize();
        }
        Arraylist[size++]=x;
        //System.out.println("y");
    }
    private boolean isfull()
    {
        return size== Arraylist.length;
    }
    private void resize()
    {
        
        Object [] temp =new Object[Arraylist.length *2];
        for(int i=0;i<Arraylist.length;i++)
        {
            temp[i]=Arraylist[i];
        }
        Arraylist = temp;
        
    }
    

}
