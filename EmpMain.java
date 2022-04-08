package Day3Associationpa;

public class EmpMain 
{
	public static void main(String [] arg)
	{
		Employe e = new Employe(1,500, "Mettur");
		e.n = new Name("Amalan", "Charles", "C");
		System.out.println("Id : "+e.id);
		System.out.println("Salary : "+e.salary);
		System.out.println("Place : " +e.place);
		System.out.println("First Name :" + e.n.first_name);
		System.out.println("Middle Name : " +e.n.middle_name);
		System.out.println("Last Name : " +e.n.last_name);
		
		
		
		
	}

}
