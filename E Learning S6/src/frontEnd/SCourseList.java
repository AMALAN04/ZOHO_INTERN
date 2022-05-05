package frontEnd;

import java.util.List;
import java.util.Scanner;

import backEnd.CourseDetailsTemplate;
import backEnd.Displayers;
import backEnd.Review;
import backEnd.StringFormatter;

public class SCourseList implements SCourseListFunctionality {
	Scanner input = new Scanner(System.in);

	public void viewCourseList(String id) {
		String courseId = "";                             // To view course list
		boolean status = false;
		List<CourseDetailsTemplate> courses = Displayers.viewCourses("-1", "0");
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
					.intException("View entire course details\nYes -1\nNo -2\nEnter Your Choice : ", 1, 2);
			if (userChoice == 1) {
				courseId = new ExceptionClass().intException("Enter Course Id : ", 1, Integer.MAX_VALUE) + "";
				SCourseDetailsFunctionality viewCourse = new SCourseDetails();
				status = viewCourse.viewCourseDetails(id, courseId);
			}
			if (status) {
				boolean loopFlag = true;
				while (loopFlag) {
					int choice = new ExceptionClass().intException("View Reviews      - 1" + "\nPurchase Course   - 2"
							+ "\nBack              - 3\nEnter Your Choice : ", 1, 3);
					switch (choice) {
					case 1:
						List<Review> reviews = Displayers.viewReview(courseId, 0);
						try {
							if (reviews.get(0).comments == null)
								System.out.println("No reviews as yet\n");
							for (Review review : reviews) {
								System.out.println("Student Name : " + review.Sname);
								System.out.println("Review       : " + review.comments);

							}
						} catch (Exception e) {
							System.out.println("\n...No reviews as yet...\n");
						}

						break;
					case 2:
						SParchaseCourse parchaseCourse = new SParchaseCourse();
						parchaseCourse.purchaseCourse(id, courseId);
						break;
					case 3:
						loopFlag = false;
						break;
					default:
						System.out.println("\nEnter a Valid option");

					}

				}

			}
		}

		else {
			System.out.println("\n...No course available... \n");
		}

	}
}
