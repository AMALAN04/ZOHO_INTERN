package backEnd;

import java.sql.*;

public class Verifier {
	private static Connection Com;
	private static ResultSet resultSet;

//Establish connec
	public static void connect() {// Connection Establisted
		try {
			Com = DriverManager.getConnection("jdbc:mysql://localhost:3306/educational", "root", "pass");
			Connection Com = DriverManager.getConnection("jdbc:mysql://localhost:3306/educational", "root", "pass");
			Statement statement = Com.createStatement();
			ResultSet resultSet1 = null;
			resultSet1 = statement.executeQuery("SHOW TABLES");
			while (!resultSet1.next()) {

				System.out.print("hello");
				String query1 = "CREATE TABLE instructor (" + "  id VARCHAR(10) NOT NULL,"
						+ "  Name VARCHAR(45) NOT NULL," + "  instructorEmail VARCHAR(45) NOT NULL,"
						+ "  contactNo VARCHAR(10) NULL," + "  DOB DATE NULL," + "  gender VARCHAR(6) NULL,"
						+ "  skillSet MEDIUMTEXT NULL," + "  noOfCourseOffered INT NULL DEFAULT 0,"
						+ "  instructorRating FLOAT NULL DEFAULT 0," + "  password VARCHAR(15) NOT NULL,"
						+ "  PRIMARY KEY (id))";
				statement.executeUpdate(query1);
				String query2 = "CREATE TABLE student (" + "  id VARCHAR(6) NOT NULL," + "  name VARCHAR(20) NOT NULL,"
						+ "  studentMail VARCHAR(45) NOT NULL," + "  contactNo VARCHAR(10) NULL," + "  DOB DATE NULL,"
						+ "  gender VARCHAR(6) NULL," + "  eQualification VARCHAR(45) NULL,"
						+ "  noOfCoursesOpted INT NULL DEFAULT 0," + "  password VARCHAR(15) NOT NULL,"
						+ "  PRIMARY KEY (id))";
				statement.executeUpdate(query2);
				String query3 = "CREATE TABLE coursecategory (" + "  categoryId INT NOT NULL AUTO_INCREMENT,"
						+ "  categoryName VARCHAR(45) NULL," + "  PRIMARY KEY (categoryId))";
				statement.executeUpdate(query3);
				String querys = "INSERT INTO  `coursecategory` (`categoryId`, `categoryName`) VALUES ('1', 'Physics') ,"
						+ "																				('2', 'Chemistry'),"
						+ "																			    ('3', 'Biology'),"
						+ "																			    ('4', 'Programming'),"
						+ "																				('5', 'Arts and Science'),"
						+ "																				('6', 'Marketing'),"
						+ "																				('7', 'Photography'),"
						+ "																				('8', 'General'),"
						+ "																				('9', 'Others') ";
				statement.executeUpdate(querys);

				String query4 = "CREATE TABLE course (" + "  courseId INT NOT NULL AUTO_INCREMENT,"
						+ "  categoryId INT NOT NULL," + "  instructorId VARCHAR(6) NOT NULL,"
						+ "  courseName VARCHAR(45) NOT NULL," + "  courseDescription MEDIUMTEXT NULL,"
						+ "  rating FLOAT NULL DEFAULT 0," + "  noOfStudents INT NULL DEFAULT 0,"
						+ "  noOfReviews INT NULL DEFAULT 0," + "  price INT NULL DEFAULT 0,"
						+ "  PRIMARY KEY (courseId)," + "  INDEX categoryId_idx (categoryId ASC) VISIBLE,"
						+ "  INDEX instructorId_idx (instructorId ASC) VISIBLE," + "  CONSTRAINT categoryId"
						+ "    FOREIGN KEY (categoryId)" + "    REFERENCES coursecategory (categoryId)"
						+ "    ON DELETE NO ACTION" + "    ON UPDATE NO ACTION," + "  CONSTRAINT `instructorId`"
						+ "    FOREIGN KEY (`instructorId`)" + "    REFERENCES `instructor` (`id`)"
						+ "    ON DELETE NO ACTION" + "    ON UPDATE NO ACTION)";
				statement.executeUpdate(query4);

				String query5 = " CREATE TABLE `student_and_course` (" + "  `review` MEDIUMTEXT NULL,"
						+ "  `favourite` TINYINT NULL DEFAULT 0," + "  `rating` INT NULL,"
						+ "  `studentId` VARCHAR(6) NOT NULL," + "  `courseId` INT NOT NULL,"
						+ "  PRIMARY KEY (`studentId`, `courseId`),"
						+ "  INDEX `courseId_idx` (`courseId` ASC) VISIBLE," + "  CONSTRAINT `studentId`"
						+ "    FOREIGN KEY (`studentId`)" + "    REFERENCES`student` (`id`)" + "    ON DELETE NO ACTION"
						+ "    ON UPDATE NO ACTION," + "  CONSTRAINT `courseId`" + "    FOREIGN KEY (`courseId`)"
						+ "    REFERENCES`course` (`courseId`)" + "    ON DELETE NO ACTION"
						+ "    ON UPDATE NO ACTION)";
				statement.executeUpdate(query5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int lastInsertedId(String tableName) {// Last Inserted Id
		String query;
		if (tableName.contains("course")) {
			query = "SELECT max(" + tableName + "Id) FROM " + tableName + "";
			try {
				Statement st = Com.createStatement();
				ResultSet rs = st.executeQuery(query);
				rs.next();
				return rs.getInt(1);
			} catch (Exception e) {
				return -1;
			}

		}
		query = "SELECT max(Id) FROM " + tableName + "";
		String lastId;
		int newId = -1;
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			lastId = rs.getString(1);
			if (lastId == null)
				return 0;
			newId = Integer.parseInt(lastId.replace(lastId.charAt(0), '0'));
		} catch (Exception e) {
			return 0;
		}
		return newId;
	}

	// ********************************************************************************************
	public static String verifyLoginDetails(String tableName, String id, String password) {// Verify Login Details
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

	public static boolean purchaseStatus(String sId, String cId) {// Purchase Status
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

	public static boolean checkReview(Review review) {// Check Review
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

	public static void disConnect() {// To Disconnect
		try {
			Com.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
