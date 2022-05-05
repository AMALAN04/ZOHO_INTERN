/*******************************************************************************************************
Application Name: "Educate"
 Whether you want to learn or to share what you know, you’ve come to the right place.
 As a global destination for online learning, we connect people through knowledge.
----------------------------
Student Functionality:
View Course List
View Course Details
Purchase This Course
View the review
Add rating
View Opted Courses.
Add to your favourite course
Include a review
View My Favorite Course List 
Removed from the course list
Check Out My Profile
Update My Profile
Password Reset
----------------------------
Instructor Functionality:
Create new course
View Reviews
View Rating
View My Profile
Update My Profile
Reset Password



********************************************************************************************************/
package frontEnd;

import java.util.Scanner;

import backEnd.DatabaseAccessor;
import backEnd.Login;
import backEnd.LoginVerifier;

public class Main {
	public static void main(String[] args) {
		DatabaseAccessor.connectToDatabase(); // Connect to database
		int userChoice;
		int loginChoice;
		Scanner input = new Scanner(System.in);
		boolean loopFlag = true;
		while (loopFlag) {
			userChoice = new ExceptionClass()
					.intException("Sign up - 1" + "\nSign in - 2" + "\nExit    - 3\nEnter Your Choice : ", 1, 3);
			switch (userChoice) {
			case 1:
				boolean loopFlag1 = true;
				outer: while (loopFlag1) {
					loginChoice = new ExceptionClass().intException("\nSign in  as Instructor- 1"
							+ "\nSign in  as Student   - 2" + "\nBack                   -3\nEnter Your Choice :", 1, 3);
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
						break;
					}
				}
				break;
			case 2:
				System.out.print("\nEnter Your Id : ");
				String id = input.next();
				System.out.print("\nEnter Your Password : ");
				String Password = input.next();
				Login login = new LoginVerifier();
				String name = login.verifyLogin(id, Password);
				if (name != null) {
					System.out.println("\n*** Welcome " + name + " ***");
					if (id.startsWith("T")) {
						Functionality instructor = new InstructorFunctionalityList();
						instructor.showFunctionalities(id);

					} else {
						Functionality student = new StudentFunctionalityList();
						student.showFunctionalities(id);
					}
				} else {
					System.out.println("\nUser Id and password mismatch");
				}
				break;
			case 3:
				loopFlag = false;
				System.out.println("\nThank You...!");
				break;
			default:
				System.out.println("\nEnter a valid Choice");
				break;

			}

		}
		DatabaseAccessor.disconnectFromDatabase();//Disconnect from database
	}

}
