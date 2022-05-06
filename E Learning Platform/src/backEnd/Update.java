package backEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	static Connection Com = null;

	public static void connect() {
		try {
			Com = DriverManager.getConnection("jdbc:mysql://localhost:3306/educational", "root", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update profile details for both student and instructor
	public static boolean updateProfile(String tableName, String column, String value, String id) {
		String query;
		if (column.equals("age")) {
			int ageValue = Integer.parseInt(value);
			query = "UPDATE " + tableName + " SET " + column + " ='" + ageValue + "'WHERE id ='" + id + "'";
		} else
			query = "UPDATE " + tableName + " SET " + column + " ='" + value + "'WHERE id ='" + id + "'";
		try {
			Statement st = Com.createStatement();
			int rs = st.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}

	}

// Update no of course offered in instructor table 
	public static void updateNoOfCourse(String id) {
		String query = "UPDATE instructor SET noOfCourseOffered= noOfCourseOffered+1 WHERE id ='" + id + "'";
		try {
			Statement st = Com.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//Modify favourite course list
	public static boolean favouriteCourse(String sId, String cId, int fav) {
		String query = "UPDATE student_and_course SET favourite= '" + fav + "' WHERE studentId ='" + sId
				+ "'AND courseId='" + cId + "'";
		try {
			Statement st = Com.createStatement();
			int rs = st.executeUpdate(query);
			if (rs > 0) {
				return true;
			} else
				return false;
		} catch (Exception e) {

			return false;
		}
	}

//Update student reviews and rating in student_and_course table
	public static boolean addReview(Review review) {
		String query = "UPDATE `eplatform`.`student_and_course` SET `review` = '" + review.comments + "',`rating` = '"
				+ review.rating + "' WHERE (`studentId` = '" + review.studentId + "') and (`courseId` = '"
				+ review.courseId + "')";

		String query1 = "UPDATE course SET rating=  (((rating *noOfReviews)+'" + review.rating + "')/(noOfReviews+1))"
				+ " WHERE courseId ='" + review.courseId + "'";
		boolean status = Verifier.checkReview(review);
		String subQuery = "SELECT instructorId FROM course WHERE courseId ='" + review.courseId + "'";

		float subQueryResult = 0;
		try {
			Statement st = Com.createStatement();
			int rs = st.executeUpdate(query);
			st.executeUpdate(query1);
			if (status) {
				String query2 = "UPDATE course SET noOfReviews=  noOfReviews+1 WHERE courseId ='" + review.courseId
						+ "'";
				st.executeUpdate(query2);
			}

			ResultSet rs1 = st.executeQuery(subQuery);
			rs1.next();
			String instructorId = rs1.getString(1);
			String subQuery1 = "SELECT rating FROM course WHERE instructorId ='" + instructorId + "'";
			rs1 = st.executeQuery(subQuery1);
			while (rs1.next()) {
				subQueryResult = subQueryResult + rs1.getFloat(1);
			}
			String query4 = "UPDATE instructor SET instructorRating=('" + subQueryResult
					+ "'/noOfcourseOffered )WHERE id ='" + instructorId + "'";
			st.executeUpdate(query4);

			if (rs > 0) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
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
