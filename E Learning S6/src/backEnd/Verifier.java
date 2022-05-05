
package backEnd;
import java.sql.*;
public class Verifier {
	static Connection Com = null;

	public static void connect() {
		try {
			Com = DriverManager.getConnection("jdbc:mysql://localhost:3306/eplatform", "root", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int lastInsertedId(String tableName) { // Return last inserted id
		String query;
		if (tableName.contains("course")) {
			query = "SELECT max(" + tableName + "Id) FROM " + tableName + "";
			try {
				Statement st = Com.createStatement();
				ResultSet rs = st.executeQuery(query);
				rs.next();
				return rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -1;
		}
		query = "SELECT max(Id) FROM " + tableName + "";
		String lastId;
		int newId = -1;
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			lastId = rs.getString(1);
			newId = Integer.parseInt(lastId.replace(lastId.charAt(0), '0'));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newId;
	}

	public static String verifyLoginDetails(String tableName, String id, String password) {//Verify user login
		String query = "SELECT password, Name FROM " + tableName + " WHERE id='" + id + "'";
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				if (rs.getString(1).equals(password)) {
					return rs.getString(2);
				}
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean purchaseStatus(String sId, String cId) { //Verify purchased status
		String query = "SELECT * FROM student_and_course WHERE studentId='" + sId + "' AND courseId ='" + cId + "'";
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public static boolean checkReview(Review review) {//Verify Whether student priorly added review or not
		String query = "SELECT * FROM student_and_course WHERE studentId='" + review.studentId + "' AND courseId = '"
				+ review.courseId + "' AND rating IS  NULL";
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
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
