package Day1enCi;

public class Circle
{
    float area;
    float circumference;
    float volume;
    public void circum_of(float r)
    {
        this.circumference = (2*3.14f * r); 
        System.out.println("circumference "+this.circumference+ " cm");
    }
    public void area_of(float r)
    {
        this.area = (3.14f * r *r); 
        System.out.println("area "+this.area + " sq.cm");
    }
   
    public void volume_of(float r)
    {
        this.volume = ((4/3)*3.14f * r*r*r); 
        System.out.println("volume "+this.volume + " cu.cm");
    }

}
