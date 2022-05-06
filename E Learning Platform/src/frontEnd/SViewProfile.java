package frontEnd;

import backEnd.Displayers;
import backEnd.StudentTemplate;

public class SViewProfile implements ViewProfileFunctionality {
	// View student profile
	public void viewProfile(String id) {
		StudentTemplate student = Displayers.sviewProfile(id, "student");
		if (student != null) {
			System.out.println("Id                        :" + student.id);
			System.out.println("Name                      :" + student.name);
			System.out.println("Email Id                  :" + student.emailId);
			System.out.println("Contact No                :" + student.contactNo);
			System.out.println("DOB                       :" + student.dob);
			System.out.println("Gender                    :" + student.gender);
			System.out.println("Educational Qualification :" + student.eQualification);
			System.out.println("No Of Course Opted        :" + student.noOfCoursesOpted);
		} else
			System.out.println("No data available");
		int choice = new ExceptionClass().intException(
				"Do You Like To Update Your Profile" + "\nYes - 1" + "\nNo  - 2\nEnter Your Choice", 1, 2);
		if (choice == 1) {
			UpdateProfileFunctionality update = new SUpdateProfile();
			update.updateProfile(id);
		}

	}
}
