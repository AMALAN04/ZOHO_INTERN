package eLearning;
import java.util.Scanner;

public class InstructorCourseFunctionality {
	DataBaseAccessor access = new DataBaseAccessor();
	public void createCourse(String id) {
		Course course = new Course();
		boolean categoryLoop = true;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Course Name");
		course.courseName = input.nextLine();
		access.connect();
		for (String str : access.viewCourseCategory())
			System.out.println(str);

		while (categoryLoop) {
			course.categoryId = new ExceptionClass().intException("Choose CourseId");
			if (course.categoryId >= 1 && course.categoryId <= 9)
				categoryLoop = false;
			else {
				System.out.println("Choose a Valid Choice");
			}
		}
		course.price = new ExceptionClass().intException("Enter Price");
		System.out.println("Enter Course description");
		input.nextLine();
		course.description = input.nextLine();
		access.connect();
		boolean status = access.createCourse(id, course);
		if (status) {
			for (int i = 0; i < 66; i += 1) {
				if (i < 40)
					System.out.print(" ");
				else
					System.out.print("-");
			}
			System.out.printf("\n%-40s| %-24s|\n", " ", " Succcessfully Added");
			System.out.printf("%-40s|     %-20s|\n", " ", " Course Id : " + course.getcourseId());
			for (int i = 0; i < 66; i += 1) {
				if (i < 40)
					System.out.print(" ");
				else
					System.out.print("-");
			}
			System.out.println();
			access.connect();
			access.updateNoOfCourse(id);
		} else {
			System.out.println("Something Went Wrong");
			return;
		}
	}
	public void updateCourse() {
	}

}
