package frontEnd;

import java.util.Scanner;

public class InstructorFunctionalityList implements Functionality {

	public void showFunctionalities(String id) {
		boolean loopFlag = true;
		int userChoice;
		while (loopFlag) {
			Scanner input = new Scanner(System.in);
			userChoice = new ExceptionClass().intException(
					"Set Cource     - 1" + "\nView Review    - 2" + "\nView Profile   - 3" + "\nSign Out       - 4"
							                                      + "\nEnter Your Choice : ", 1,4);
			switch (userChoice) {
			case 1:
				ISetCourseFunctionality function1 = new ISetCourse();
				function1.setCourse(id);
				break;

			case 2:
				IViewReview function2 = new IViewReview();
				function2.viewReview(id);
				break;
			case 3:
				ViewProfileFunctionality function3 = new IViewProfile();
				function3.viewProfile(id);
				break;
			case 4:
				System.out.println("Thank You...!");
				return;

			}
		}
	}
}