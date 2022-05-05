package backEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Displayers {
	static Connection Com = null;

	public static void connect() {
		try {
			Com = DriverManager.getConnection("jdbc:mysql://localhost:3306/eplatform", "root", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<String> viewCourseCategory() {
		List<String> categoryList = new ArrayList<>();
		String query = "SELECT * FROM coursecategory";
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			categoryList
					.add(StringFormatter.stringFormat("Id", 3) + " " + StringFormatter.stringFormat("Course Name", 20));
			while (rs.next()) {
				categoryList.add(StringFormatter.stringFormat(rs.getInt(1) + "", 3) + " "
						+ StringFormatter.stringFormat(rs.getString(2), 20));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryList;

	}

	public static List<CourseDetailsTemplate> viewCourses(String id, String choice) {
		String query;
		if (choice.equals("0")) {
			query = "SELECT courseId,courseName,instructorId,I.Name,rating,price"
					+ " FROM course C JOIN instructor I on c.instructorId = I.id";
		} else if (choice.equals("1")) {
			query = "SELECT C.courseId,courseName,I.Id,I.Name,C.rating,price" + " FROM student_and_course SC"
					+ " JOIN course C on SC.courseId = C.courseid"
					+ " JOIN instructor I on I.Id = C.instructorId WHERE SC.studentId = '" + id + "'";
		} else
			query = "SELECT C.courseId,courseName,I.Id,I.Name,C.rating,price" + " FROM student_and_course SC"
					+ " JOIN course C on SC.courseId = C.courseid"
					+ " JOIN instructor I on I.Id = C.instructorId WHERE SC.studentId = '" + id + "'AND SC.favourite= '"
					+ 1 + "'";
		try {
			List<CourseDetailsTemplate> courses = new ArrayList<>();
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				CourseDetailsTemplate course = new CourseDetailsTemplate();
				course.courseId = rs.getInt(1);
				course.courseName = rs.getString(2);
				course.instructorId = rs.getString(3);
				course.instructorName = rs.getString(4);
				course.rating = rs.getInt(5);
				course.price = rs.getInt(6);
				courses.add(course);
			}
			return courses;
		} catch (Exception e) {
			return null;
		}
	}

	public static InstructorTemplate iviewProfile(String id, String tableName) {
		InstructorTemplate instructorDetails = new InstructorTemplate();
		String query = "SELECT * FROM " + tableName + " WHERE id = '" + id + "'";
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				instructorDetails.id = rs.getString(1);
				instructorDetails.name = rs.getString(2);
				instructorDetails.instructorEmail = rs.getString(3);
				instructorDetails.instructorContactNo = rs.getString(4);
				instructorDetails.dob = rs.getString(5);
				instructorDetails.gender = rs.getString(6);
				instructorDetails.skillSet = rs.getString(7);
				instructorDetails.noOfCoursesOffered = rs.getInt(8);
				instructorDetails.rating = rs.getFloat(9);

			}
			return instructorDetails;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}

	}

	public static StudentTemplate sviewProfile(String id, String tableName) {
		StudentTemplate studentDetails = new StudentTemplate();
		String query = "SELECT * FROM " + tableName + " WHERE id = '" + id + "'";
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				studentDetails.Id = rs.getString(1);
				studentDetails.name = rs.getString(2);
				studentDetails.emailId = rs.getString(3);
				studentDetails.contactNo = rs.getString(4);
				studentDetails.dob = rs.getString(5);
				studentDetails.gender = rs.getString(6);
				studentDetails.eQualification = rs.getString(7);
				studentDetails.noOfCoursesOpted = rs.getInt(8);
			}
			return studentDetails;
		} catch (SQLException e) {
			return null;
		}

	}

	public static CourseDetailsTemplate viewCourseDetails(String cId) {
		CourseDetailsTemplate details = new CourseDetailsTemplate();
		String query = " SELECT  C.courseId, C.courseName,CC.categoryId ,CC.categoryName,C.courseDescription,I.id,I.Name,C.noOfStudents,C.rating,C.price  "
				+ " FROM course C " + " JOIN  coursecategory CC ON C.categoryID = CC.categoryId "
				+ " JOIN  instructor I ON C.instructorId = 	I.id " + " WHERE C.courseId ='" + cId + "'";

		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			details.courseId = rs.getInt(1);
			details.courseName = rs.getString(2);
			details.categoryId = rs.getInt(3);
			details.categoryName = rs.getString(4);
			details.description = rs.getString(5);
			details.instructorId = rs.getString(6);
			details.instructorName = rs.getString(7);
			details.noOfStudents = rs.getInt(8);
			details.rating = rs.getFloat(9);
			details.price = rs.getInt(10);
			return details;
		} catch (SQLException e) {
			return null;
		}
	}

	public static List<Review> viewReview(String Id, int choice) {
		List<Review> review = new LinkedList<>();
		String query;
		if (choice == 0) {
			query = " SELECT  C.courseName,S.name, CS.rating, CS.review " + " FROM  student_and_course CS "
					+ " JOIN  student S ON S.id = CS.studentId " + " JOIN   course C ON CS.courseId =C.courseId "
					+ " WHERE C.courseId = '" + Id + "'AND CS.review IS NOT NULL ";
		} else {
			query = " SELECT C.courseName, S.name, CS.rating, CS.review " + " FROM  student_and_course CS "
					+ " JOIN  student S ON S.id = CS.studentId " + " JOIN   course C ON CS.courseId =C.courseId "
					+ " WHERE C.instructorId ='" + Id + "' AND CS.review IS NOT NULL ORDER BY C.courseName";
		}

		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			Review review1 = new Review();
			while (rs.next()) {
				review1.courseName = rs.getString(1);
				review1.Sname = rs.getString(2);
				review1.rating = rs.getInt(3);
				review1.comments = rs.getString(4);
				review.add(review1);
			}
			return review;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void disConnect() {
		try {
			Com.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
