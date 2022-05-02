package eLearning;

import java.util.Scanner;

public class StudentFunctionalityList implements Functionality{
	public void showFunctionalities(String id) {
	    StudentFunctionality functions = new StudentAccount();
		boolean loopFlag = true;
		int userChoice;
		while (loopFlag) {
			System.out.println("View Course List           - 1");
			System.out.println("View Opted Coursess        - 2");
			System.out.println("View Favorite Course List  - 3");
			System.out.println("Back                       - 4");
			
			Scanner input = new Scanner(System.in);
			userChoice =  new ExceptionClass().intException("Enter your choice");

			switch (userChoice) {
			case 1:
				 functions.viewCourseList(id);
				 break;
			case 2:
				functions.viewOptedCourse(id);
				break;
			case 3:
				functions.viewFavouriteCourseList(id);
			case 4:
				return;
			default :
				System.out.println("Enter a valid choice");
				
			}

		}

	}

}
