package frontEnd;

import java.util.Scanner;

public class StudentFunctionalityList implements Functionality { //Display accessable functionality
	public void showFunctionalities(String id) {
		boolean loopFlag = true;
		int userChoice;
		while (loopFlag) {
			System.out.println("View Course List           - 1");
			System.out.println("View Opted Coursess        - 2");
			System.out.println("View Favorite Course List  - 3");
			System.out.println("View Profile               - 4");
			System.out.println("Sign Out                   - 5");

			Scanner input = new Scanner(System.in);
			userChoice = new ExceptionClass().intException("Enter your choice : ", 1, 5);
			switch (userChoice) {
			case 1:
				SCourseListFunctionality function1 = new SCourseList();
				function1.viewCourseList(id);
				break;
			case 2:
				SOptedCourseFunctionality function2 = new SOptedCourse();
				function2.viewOptedCourse(id);
				break;
			case 3:
				SFavouriteCourseFunctionality function3 = new SFavouriteCourse();
				function3.viewFavouriteCourseList(id);
				break;
			case 4:
				ViewProfileFunctionality function4 = new SViewProfile();
				function4.viewProfile(id);
				break;
			case 5:
				return;
			default:
				System.out.println("Enter a valid choice");

			}
		}
	}
}
