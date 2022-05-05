package frontEnd;

import java.util.List;
import java.util.Scanner;

import backEnd.CourseDetailsTemplate;
import backEnd.Displayers;
import backEnd.StringFormatter;
import backEnd.Update;

public class SFavouriteCourse implements SFavouriteCourseFunctionality {
	Scanner input = new Scanner(System.in);

	public void viewFavouriteCourseList(String sId) {
		List<CourseDetailsTemplate> courses = Displayers.viewCourses(sId, "2");
		if (!courses.isEmpty()) {
			System.out.println("Course ID " + " Course Name          " + "Instructor Id " + "  Instructor Name   "
					+ "Rating " + "Price");
			for (CourseDetailsTemplate course : courses) {

				System.out.println(StringFormatter.stringFormat(course.courseId + "", 10) + " "
						+ StringFormatter.stringFormat(course.courseName, 20) + " "
						+ StringFormatter.stringFormat(course.instructorId, 16) + " "
						+ StringFormatter.stringFormat(course.instructorName, 16) + " "
						+ StringFormatter.stringFormat(course.rating + "", 6) + " "
						+ StringFormatter.stringFormat(course.price + "", 5));
			}

			int userChoice = new ExceptionClass()
					.intException("Remove From Fav Course\nYes -1\nNo -2\nEnter Your Choice", 1, 2);
			if (userChoice == 1) {
				this.accessFavCourse(sId, 0);

			}

			else if (userChoice == 2) {

			}

		} else
			System.out.println("\n...No Favourite Course...\n");

	}

	public void accessFavCourse(String sId, int fav) {
		System.out.println("Enter Course Id");
		String courseId = input.next();
		boolean status = Update.favouriteCourse(sId, courseId, fav);
		if (status && fav == 1) {
			System.out.println("\nSuccessfully Added to Favourite List");
		} else if (status && fav == 0) {
			System.out.println("\nSuccessfully Removed from your Favourite List");
		} else {
			System.out.println("\nSomething Went Wrong");
		}

	}

}
