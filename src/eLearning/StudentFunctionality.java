package eLearning;

import java.sql.ResultSet;

public interface StudentFunctionality {
	void viewCourseList(String id);
	void viewOptedCourse(String id);
	void viewFavouriteCourseList (String id);
}
