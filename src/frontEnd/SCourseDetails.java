package frontEnd;

import backEnd.CourseDetailsTemplate;
import backEnd.Displayers;

public class SCourseDetails implements SCourseDetailsFunctionality {
	public boolean viewCourseDetails(String sid, String courseId) {

		boolean coursePresent = false;

		CourseDetailsTemplate details = Displayers.viewCourseDetails(courseId);
		if (details != null) {
			coursePresent = true;
			System.out.println("Course Id       :" + details.courseId);
			System.out.println("Course Name     :" + details.courseName);
			System.out.println("Category Id     :" + details.categoryId);
			System.out.println("Category Name   :" + details.categoryName);
			System.out.println("Description     :" + details.description);
			System.out.println("Instructor ID   :" + details.instructorId);
			System.out.println("Instructor Name :" + details.instructorName);
			System.out.println("No Of Students  :" + details.noOfStudents);
			System.out.println("Rating          :" + details.rating);
			System.out.println("Price           :" + details.price + "\n");
		}
		if (coursePresent) {
			return true;
		}
		return false;
	}

}
