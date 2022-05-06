package backEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import frontEnd.InstructorRegistration;
import frontEnd.StudentRegistration;

public class Insert {
	static Connection Com = null;

	public static void connect() {
		try {
			Com = DriverManager.getConnection("jdbc:mysql://localhost:3306/educational", "root", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Push instructor details to database
	public static boolean addInstructor(InstructorRegistration instructor) {
		try {
			String query = "INSERT INTO instructor VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = Com.prepareStatement(query);
			st.setString(1, instructor.getId());
			st.setString(2, instructor.name);
			st.setString(3, instructor.instructorEmail);
			st.setString(4, instructor.instructorContactNo);
			st.setString(5, instructor.dob);
			st.setString(6, instructor.gender);
			st.setString(7, instructor.skillSet);
			st.setInt(8, instructor.getNoOfCoursesOffered());
			st.setFloat(9, instructor.getRating());
			st.setString(10, instructor.getPassword());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// Push student details to database
	public static boolean addStudent(StudentRegistration instructor) {
		try {
			String query = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = Com.prepareStatement(query);
			st.setString(1, instructor.getId());
			st.setString(2, instructor.name);
			st.setString(3, instructor.emailId);
			st.setString(4, instructor.contactNo);
			st.setString(5, instructor.dob);
			st.setString(6, instructor.gender);
			st.setString(7, instructor.eQualification);
			st.setInt(8, instructor.getNoOfCoursesOpted());
			st.setString(9, instructor.getPassword());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// Push course details to database
	public static Boolean createCourse(String id, Course course) {
		try {
			String query = "INSERT INTO course VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = Com.prepareStatement(query);
			st.setInt(1, course.getcourseId());
			st.setInt(2, course.categoryId);
			st.setString(3, id);
			st.setString(4, course.courseName);
			st.setString(5, course.description);
			st.setFloat(6, course.getrating());
			st.setInt(7, 0);
			st.setInt(8, 0);
			st.setInt(9, course.price);
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	// Push purchased course details to student_and_course table
	public static boolean purchaseCourse(String sId, String cId) {
		String query = "UPDATE student SET noOfCoursesOpted=  noOfCoursesOpted+1 WHERE id ='" + sId + "'";
		String query1 = "INSERT INTO student_and_course VALUES (DEFAULT,DEFAULT,DEFAULT,'" + sId + "'," + cId + ")";
		String query2 = "UPDATE course SET noOfStudents=  noOfStudents+1 WHERE courseId ='" + cId + "'";
		try {
			Statement st = Com.createStatement();
			st.executeUpdate(query);
			st.executeUpdate(query1);
			st.executeUpdate(query2);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public static void disConnect() {
		try {
			Com.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
