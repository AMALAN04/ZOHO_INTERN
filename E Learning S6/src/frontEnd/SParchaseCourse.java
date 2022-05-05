package frontEnd;

import java.util.Scanner;

import backEnd.Insert;
import backEnd.Login;
import backEnd.LoginVerifier;
import backEnd.Verifier;

public class SParchaseCourse {  //purchase course
	void purchaseCourse(String sId,String courseId)
	{
		Scanner input = new Scanner(System.in);
		boolean purchaseStatus = Verifier.purchaseStatus(sId, courseId);
		if(purchaseStatus)
		{
		boolean parchaseFlag = true;
		while(parchaseFlag) {
		int back =new ExceptionClass().intException("Continue Payment - 1" + "\nGo Back - 2\nEnter Your Choice : ", 1, 2);
		if(back==1) {
		System.out.print("\nEnter your password : ");
		String Password = input.nextLine();
		Login login = new LoginVerifier();
		String name = login.verifyLogin(sId, Password);
		if(name!=null) {
		boolean status =Insert.purchaseCourse(sId,courseId);
		if(status)
		 {
			 System.out.println("\nPurchased");
			 parchaseFlag = false;
		 }
		}
		else {
			System.out.println("\nPassword Missmatch");
		}
		}
		else return;
		}
		
	}
		else System.out.println("\nAlready you purchased");
	}
	
}
