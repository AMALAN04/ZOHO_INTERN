package frontEnd;

import java.util.List;

import backEnd.CourseDetailsTemplate;
import backEnd.Displayers;
import backEnd.StringFormatter;

public class SOptedCourse implements SOptedCourseFunctionality {
	// display opted course list ordered by time of purchase
	public void viewOptedCourse(String sId) {
		boolean flagLoop = true;
		List<CourseDetailsTemplate> courses = Displayers.viewCourses(sId, "1");
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
			while (flagLoop) {
				int userChoice = new ExceptionClass().intException("Add Favourite Course  -1"
						+ "\nAdd Review            -2" + "\nBack                  -3\nEnter Your Choice : ", 1, 3);
				switch (userChoice) {
				case 1:
					SFavouriteCourseFunctionality favcourse = new SFavouriteCourse();
					favcourse.accessFavCourse(sId, 1);
					break;
				case 2:
					SAddReviewFunctionality addReview = new SAddReview();
					addReview.addReview(sId);
					break;
				case 3:
					flagLoop = false;
					break;
				}
			}
		} else {
			System.out.println("\n...No opted course... \n");
		}
	}
}
