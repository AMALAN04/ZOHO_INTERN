package eLearning;

import java.util.Scanner;

public class InstructorFunctionalityList implements Functionality {

	public void showFunctionalities(String id) {
		InstructorFunctionality functions = new InstructorAccount();
		boolean loopFlag = true;
		int userChoice;
		while (loopFlag) {
			Scanner input = new Scanner(System.in);
			userChoice = new ExceptionClass().intException("\nSet Cource     - 1" + "\nView Review    - 2" + 
			                                               "\nUpdate Profile - 3"+ "\nSign Out       - 4");
			switch (userChoice) {
			case 1:
				functions.setCourse(id);
				break;

			case 2:
				functions.viewReview(id);
				break;
			case 3:
				functions.updateProfile();
			case 4:
				System.out.println("Thank You...!");
				return;
			default :
				System.out.println("Choose a valid input");

			}
		}
	}
}