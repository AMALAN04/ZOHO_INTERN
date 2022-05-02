package eLearning;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int userChoice;
		int loginChoice;
		Scanner input = new Scanner(System.in);
		boolean loopFlag = true;
		while (loopFlag) {
			userChoice = new ExceptionClass().intException("Sign up - 1" + "\nSign in - 2" + "\nExit    - 3");
			switch (userChoice) {
			case 1:
				boolean loopFlag1 = true;
				outer:
				while (loopFlag1) {
					loginChoice = new ExceptionClass().intException("\nSign in  as Instructor- 1"
							+ "\nSign in  as Student   - 2" + "\nBack                   -3");
					switch (loginChoice) {
					case 1:
						User Instructor = new InstructorRegistration();
						Instructor.setDetails();
						break outer;
					case 2:
						User student = new StudentRegistration();
						student.setDetails();
						break outer;
					case 3:
						loopFlag1 = false;
						break ;
					default:
						System.out.println("Enter a valid Choice");
						break;
					}
				}
				break;
			case 2:
				System.out.println("Enter Your Id");
				String id = input.next();
				System.out.println("Enter Your Password");
				String Password = input.next();
				Login login = new LoginVerifier();
				String name = login.verifyLogin(id, Password);
				if (name != null) {
					if (id.startsWith("T")) {
						System.out.println("*** Welcome " + name+" ***");
						Functionality instructor = new InstructorFunctionalityList();
						instructor.showFunctionalities(id);

					} else {
						System.out.println("*** Welcome " + name+" ***");
						Functionality student = new StudentFunctionalityList();
						student.showFunctionalities(id);
					}
				} else {
					System.out.println("User Id and password mismatch");
				}
				break;
			case 3:
				loopFlag = false;
				System.out.println("Thank You...!");
				break;
			default:
				System.out.println("Enter a valid Choice");
				break;

			}

		}
	}

}
