package frontEnd;

import backEnd.Displayers;
import backEnd.InstructorTemplate;

public class IViewProfile implements ViewProfileFunctionality {
	// To view profile details
	public void viewProfile(String id) {
		InstructorTemplate instructor = Displayers.iviewProfile(id, "instructor");
		if (instructor != null) {
			System.out.println("Id                   :" + instructor.id);
			System.out.println("Name                 :" + instructor.name);
			System.out.println("Email Id             :" + instructor.instructorEmail);
			System.out.println("Contact No           :" + instructor.instructorContactNo);
			System.out.println("DOB                  :" + instructor.dob);
			System.out.println("Gender               :" + instructor.gender);
			System.out.println("SkillSet             :" + instructor.skillSet);
			System.out.println("No Of Course Offered :" + instructor.noOfCoursesOffered);
			System.out.println("Rating               :" + instructor.rating);
		} else
			System.out.println("\nNo data available");
		int choice = new ExceptionClass().intException(
				"Do You Like To Update Your Profile" + "\nYes - 1" + "\nNo  - 2\nEnter Your Choice : ", 1, 2);
		if (choice == 1) {
			UpdateProfileFunctionality update = new IUpdateProfile();
			update.updateProfile(id);
		}

	}
}
