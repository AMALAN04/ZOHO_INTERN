package frontEnd;

import java.util.Scanner;

public class ExceptionClass {
	int intException(String statement,int lower,int higher) {
		boolean process = true;
		int userChoice = 0;
		do {
			System.out.print("\n"+statement);
			try {
				Scanner input = new Scanner(System.in);
				userChoice = input.nextInt();
				if(userChoice>=lower && userChoice<=higher)
				process = false;
			} catch (Exception e) {
				System.out.println("\nEnter a valid Input");
				process = true;
			}
		} while (process);
		return userChoice;
	}

	String phoneNoException(String statement) {
		boolean process = true;
		String phoneNo = "";
		do {
			System.out.print("\n"+statement);
			try {
				Scanner input = new Scanner(System.in);
				phoneNo = input.next();
				if (phoneNo.matches("[0-9]+") && phoneNo.length() == 10)
					process = false;
				else
					System.out.println("Enter a valid 10 Digit Phone No");
			} catch (Exception e) {
				process = true;
			}
		} while (process);
		return phoneNo;
	}

	public String emailException(String statement) {
		boolean process = true;
		String email = "";
		do {
			System.out.print("\n"+statement);
			try {
				Scanner input = new Scanner(System.in);
				email = input.next();
				if (email.contains("@"))
					process = false;
				else
					System.out.println("Enter a valid email ID");
			} catch (Exception e) {
				process = true;
			}
		} while (process);
		return email;
	}
	
	public String dobException(String statement) {
		boolean process = true;
		String dob1 = "";
		do {
			System.out.print("\n"+statement);
			try {
				Scanner input = new Scanner(System.in);
				dob1 = input.next();
				String[] dob =dob1.split("-");
				int month =Integer.parseInt( dob[1]);
				int date = Integer.parseInt( dob[2]);
				System.out.println(month +" "+ date);
				if (((month >=1 && month <=12)&& (date>=1&& date<=28)))
					process = false;
				else
					System.out.println("Enter A Valid DOB");
			} catch (Exception e) {
				process = true;
			}
		} while (process);
		return dob1;
	}
}
