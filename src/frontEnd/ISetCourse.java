package frontEnd;

import java.util.Scanner;

import backEnd.Course;
import backEnd.Displayers;
import backEnd.Insert;
import backEnd.Update;
import backEnd.Verifier;

public class ISetCourse implements ISetCourseFunctionality {
	Verifier access = new Verifier();
	Scanner input = new Scanner(System.in);

	public void setCourse(String id) {
		Course course = new Course();
		System.out.print("\nEnter Course Name : ");
		course.courseName = input.nextLine();
		for (String str : Displayers.viewCourseCategory())
			System.out.println(str);
		course.categoryId = new ExceptionClass().intException("Choose CourseId : ", 1, 9);
		course.price = new ExceptionClass().intException("Enter Price : ", 0, Integer.MAX_VALUE);
		System.out.print("\nEnter Course description : ");
		course.description = input.nextLine();
		boolean status = Insert.createCourse(id, course);
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
			Update.updateNoOfCourse(id);
		} else {
			System.out.println("\nSomething Went Wrong");
			return;

		}
	}

}
