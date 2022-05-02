package eLearning;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentAccount extends StudentCourseFunctionality implements StudentFunctionality {
	Scanner input = new Scanner(System.in);
	public void viewCourseList(String id) {
		DataBaseAccessor access = new DataBaseAccessor();
		access.connect();
		int count = 0;
		ResultSet rs = access.viewCourses("-1", "0");
		try {
			System.out.println("Course ID " + "Course Name          " + " Instructor Id " + "  Instructor Name   "
					+ "Rating " + "Price");
			while (rs.next()) {
				System.out.println(StringFormatter.stringFormat(rs.getInt(1) + "", 10) + " "
						+ StringFormatter.stringFormat(rs.getString(2), 20) + " "
						+ StringFormatter.stringFormat(rs.getString(3), 16) + " "
						+ StringFormatter.stringFormat(rs.getString(4), 16) + " "
						+ StringFormatter.stringFormat(rs.getFloat(5) + "", 6) + " "
						+ StringFormatter.stringFormat(rs.getInt(6) + "", 5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int userChoice =  new ExceptionClass().intException("View entire course details\nYes -1\nNo -2");
		if (userChoice == 1) {
			super.viewDetails(id);

		}
	}

	public void viewOptedCourse(String sId) {
		DataBaseAccessor access = new DataBaseAccessor();
		access.connect();
		int count = 0;
		boolean flagLoop = true;
		boolean noOptedCourses    = true;
		ResultSet rs = access.viewCourses(sId, "1");
		try {
			while (rs.next()) {
				if (count == 0) {
					System.out.println("Course ID  " + "Course Name          " + "Instructor_Id    " + "Rating " + "Price");
					noOptedCourses = false;
				}
				System.out.println(StringFormatter.stringFormat(rs.getInt(1) + "", 10) + " "
						+ StringFormatter.stringFormat(rs.getString(2), 20) + " "
						+ StringFormatter.stringFormat(rs.getString(3), 16) + " "
						+ StringFormatter.stringFormat(rs.getFloat(4) + "", 6) + " "
						+ StringFormatter.stringFormat(rs.getInt(5) + "", 5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(noOptedCourses) {
			System.out.println("\n...No opted course... \n");
		}
		while (flagLoop) {
			System.out.println("Add Favourite Course -1");
			System.out.println("Add Review            -2");
			System.out.println("Back                  -3");
			int userChoice =  new ExceptionClass().intException("Enter your choice");
			switch (userChoice) {
			case 1:
				super.accessFavCourse(sId, 1);
				break;
			case 2:
				super.addReview(sId);
                break;
			case 3:
				flagLoop = false;
				break;
			default:
				System.out.println("Enter a Valid Choice");
				
			}

		}
	}

	public void viewFavouriteCourseList(String sId) {
		DataBaseAccessor access = new DataBaseAccessor();
		access.connect();
		boolean result = false;
		int count = 0;
		ResultSet rs = access.viewCourses(sId, "2");
		try {
			while (rs.next()) {
				if (count == 0) {
					System.out.println(
							"Course ID  " + "Course Name          " + "Instructor_Id    " + "Rating " + "Price");
					result = true;
				}
				System.out.println(StringFormatter.stringFormat(rs.getInt(1) + "", 10) + " "
						+ StringFormatter.stringFormat(rs.getString(2), 20) + " "
						+ StringFormatter.stringFormat(rs.getString(3), 16) + " "
						+ StringFormatter.stringFormat(rs.getFloat(4) + "", 6) + " "
						+ StringFormatter.stringFormat(rs.getInt(5) + "", 5));
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(!result)System.out.println("\n...No Favourite Course...\n");
		if (result) {
			int userChoice = new ExceptionClass().intException("Remove From Fav Course..\nYes -1\nNo -2");
			if (userChoice == 1) {
				super.accessFavCourse(sId, 0);

			}

			else if(userChoice == 2){

			}
			else {
				System.out.println("Enter a Valid Choice");
			}
		} else {
			System.out.println("Your Favourite List is empty");
		}
	}

}
