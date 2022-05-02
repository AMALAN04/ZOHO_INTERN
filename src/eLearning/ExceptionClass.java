package eLearning;

import java.util.Scanner;

public class ExceptionClass {
	int intException(String s) {
		boolean process = true;
		int userChoice = 0;
		do {
			System.out.println(s);
			try {
				Scanner input = new Scanner(System.in);
				userChoice = input.nextInt();
				process = false;
			} catch (Exception e) {
				System.out.println("Enter a valid Input");
				process = true;
			}
		} while (process);
		return userChoice;
	}

	String phoneNoException(String s) {
		boolean process = true;
		String phoneNo = "";
		do {
			System.out.println(s);
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

	String emailException(String s) {
		boolean process = true;
		String email = "";
		do {
			System.out.println(s);
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
}
