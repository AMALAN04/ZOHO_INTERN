package eLearning;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataBaseAccessor {
	Connection Com=null;
	public void connect()
	{
		try {
			 Com = DriverManager.getConnection("jdbc:mysql://localhost:3306/eplatform", "root", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int lastInsertedId(String tableName)
	{
		String query;
		if(tableName.contains("course")) {
		query = "SELECT max("+tableName+"Id) FROM "+tableName+"";
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
	    query = "SELECT max(Id) FROM "+tableName+"";
		String lastId;
		int newId=-1;
		try {
		Statement st = Com.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
	    lastId= rs.getString(1) ;
	    newId = Integer.parseInt(lastId.replace(lastId.charAt(0), '0'));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newId;	
	}
	
	//********************************************************************************************
	public String verifyLoginDetails (String tableName, String id,String password)
	{
		String query = "SELECT password, Name FROM "+tableName+" WHERE id='"+id+"'";
		try {
		Statement st = Com.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) { 
			if(rs.getString(1).equals(password)) {
			return rs.getString(2);
			}
			return null;
		}
		} catch (Exception e) {
			e.printStackTrace();
		} 
			return null;
	}
	//*********************************************************************************************
	public Boolean addInstructor(InstructorRegistration instructor)
	{
		try {
			String query = "INSERT INTO instructor VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = Com.prepareStatement(query);
			st.setString(1,instructor.getId());
			st.setString(2,instructor.name);
			st.setString(3,instructor.emailId);
			st.setString(4,instructor.contactNo);
			st.setInt(5,instructor.age);
			st.setString(6,instructor.gender);
			st.setString(7,instructor.skillSet);
			st.setInt(8,instructor.getNoOfCoursesOffered());
			st.setFloat(9,instructor.getRating());
			st.setString(10,instructor.getPassword());
			st.executeUpdate(); 
			return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	public Boolean addStudent (StudentRegistration instructor)
	{
		try {
			String query = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = Com.prepareStatement(query);
			st.setString(1,instructor.getId());
			st.setString(2,instructor.name);
			st.setString(3,instructor.emailId);
			st.setString(4,instructor.contactNo);
			st.setInt(5,instructor.age);
			st.setString(6,instructor.gender);
			st.setString(7,instructor.eQualification);
			st.setInt(8,instructor.getNoOfCoursesOpted());
			st.setString(9,instructor.getPassword());
			st.executeUpdate(); 
			return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	public Boolean createCourse(String id,Course course)
	{
		try {
			String query = "INSERT INTO course VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = Com.prepareStatement(query);
			st.setInt(1,course.getcourseId());
			st.setInt(2,course.categoryId);
			st.setString(3,id);
			st.setString(4,course.courseName);
			st.setString(5,course.description);
			st.setFloat(6,course.getrating());
			st.setInt(7,0);
			st.setInt(8,0);
			st.setInt(9,course.price);
			st.executeUpdate(); 
			return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	public void updateNoOfCourse(String id)
	{
		String query = "UPDATE instructor SET noOfCourseOffered= noOfCourseOffered+1 WHERE id ='"+id+"'";
		try {
		Statement st = Com.createStatement();
		st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<String> viewCourseCategory()
	{
		List<String> categoryList= new ArrayList<>();
		String query ="SELECT * FROM coursecategory";
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			categoryList.add(StringFormatter.stringFormat("Id",3)+" "+StringFormatter.stringFormat("Course Name",20));
			while (rs.next()) {
				categoryList.add(StringFormatter.stringFormat(rs.getInt(1)+"",3)+" " +StringFormatter.stringFormat(rs.getString(2),20));
				 
			}
			} catch (Exception e) {
				e.printStackTrace();
			} 
				return  categoryList;
		
	}
	public ResultSet viewCourses(String id,String choice)
	{
		String query;
		if(choice.equals("0")) {
		query ="SELECT courseId,courseName,instructorId,I.Name,rating,price"
				+ " FROM course C JOIN instructor I on c.instructorId = I.id";
		}
		else if(choice.equals("1"))
		query ="SELECT I.courseId,courseName,instructorId,I.rating,price"
				+ " FROM student_and_course SC JOIN course I on SC.courseId = I.courseid WHERE SC.studentId = '"+id+"'";
		else 
			query ="SELECT I.courseId,courseName,instructorId,I.rating,price"
					+ " FROM student_and_course SC JOIN course I on SC.courseId = I.courseid WHERE SC.studentId = '"+id+"'AND SC.favourite= '"+1+"'";
		
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			return rs;
			} catch (Exception e) {
				e.printStackTrace();
			} 
				return  null;
	}
	public boolean purchaseCourse(String sId, String cId)
	{
		String query = "UPDATE student SET noOfCoursesOpted=  noOfCoursesOpted+1 WHERE id ='"+sId+"'";
		String query1 = "INSERT INTO student_and_course VALUES (DEFAULT,DEFAULT,DEFAULT,'"+sId+"',"+cId+")";
		String query2 = "UPDATE course SET noOfStudents=  noOfStudents+1 WHERE courseId ='"+cId+"'";
		try {
		Statement st = Com.createStatement();
		st.executeUpdate(query);
		st.executeUpdate(query1);
		st.executeUpdate(query2);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean favouriteCourse(String sId, String cId, int fav ) {
		String query = "UPDATE student_and_course SET favourite= '"+fav+"' WHERE studentId ='"+sId+"'AND courseId='"+cId+"'";
		try {
			Statement st = Com.createStatement();
			int rs =st.executeUpdate(query);
			if (rs>0) {
			return true;
			}
			else return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	public boolean addReview(Review review)
	{
		String query = "UPDATE `eplatform`.`student_and_course` SET `review` = '"+review.comments+"',`rating` = '"+review.rating+
				"' WHERE (`studentId` = '"+review.studentId+"') and (`courseId` = '"+review.courseId+"')";
		
		String query1=   "UPDATE course SET rating=  (((rating *noOfReviews)+'"+review.rating+"')/(noOfReviews+1))"
				         + " WHERE courseId ='"+review.courseId+"'";
		String query2 = "UPDATE course SET noOfReviews=  noOfReviews+1 WHERE courseId ='"+review.courseId+"'";
		String subQuery = "SELECT instructorId FROM course WHERE courseId ='"+review.courseId+"'";
		
		
		float subQueryResult=0;
		try {
			Statement st = Com.createStatement();
			int rs =st.executeUpdate(query);
			this.connect();
			st.executeUpdate(query1);
			st.executeUpdate(query2);
			ResultSet rs1 = st.executeQuery(subQuery);
			rs1.next();
			String instructorId=rs1.getString(1);
			String subQuery1 = "SELECT rating FROM course WHERE instructorId ='"+instructorId+"'";
			rs1 = st.executeQuery(subQuery1);
			while (rs1.next())
			{
			  subQueryResult=subQueryResult+ rs1.getFloat(1);
			}
			String query4= "UPDATE instructor SET instructorRating=('"+subQueryResult+"'/noOfcourseOffered )WHERE id ='"+instructorId+"'"; 
			st.executeUpdate(query4);
 
			if (rs>0) {
			return true;
			}
			else return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		
	}
	public CourseDetailsTemplate viewCourseDetails(String cId)
	{
		CourseDetailsTemplate details = new CourseDetailsTemplate();
		String query =" SELECT  C.courseId, C.courseName,CC.categoryId ,CC.categoryName,C.courseDescription,I.id,I.Name,C.noOfStudents,C.rating,C.price  "
				+ " FROM course C "
				+ " JOIN  coursecategory CC ON C.categoryID = CC.categoryId "
				+ " JOIN  instructor I ON C.instructorId = 	I.id "
				+ " WHERE C.courseId ='"+cId+"'";
		 
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			details.courseId = rs.getInt(1);
			details.courseName=rs.getString(2);
			details.categoryId=rs.getInt(3);
			details.categoryName = rs.getString(4);
			details.description =rs.getString(5);
			details.instructorId=rs.getString(6);
			details.instructorName=rs.getString(7);
			details.noOfStudents= rs.getInt(8);
			details.rating = rs.getFloat(9);
			details.price = rs.getInt(10);
			return details;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	public List<Review> viewReview(String Id, int choice)
	{
		List<Review> review  = new LinkedList<>();
		String query;
		if(choice==0)
		{
			query = " SELECT  C.courseName,S.name, CS.rating, CS.review " + " FROM  student_and_course CS "
					+ " JOIN  student S ON S.id = CS.studentId " + " JOIN   course C ON CS.courseId =C.courseId "
					+ " WHERE C.courseId = '"+Id+"'AND CS.review IS NOT NULL ";
		}
		else {
			query =" SELECT C.courseName, S.name, CS.rating, CS.review " + " FROM  student_and_course CS "
					+ " JOIN  student S ON S.id = CS.studentId " + " JOIN   course C ON CS.courseId =C.courseId "
					+ " WHERE C.instructorId ='"+Id+"' AND CS.review IS NOT NULL ORDER BY C.courseName";
		}
			
		try {
			Statement st = Com.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next())
			{
				Review review1  = new Review();
				review1.courseName=rs.getString(1);
				review1.Sname= rs.getString(2);
				review1.rating =rs.getInt(3);
				review1.comments=rs.getString(4);
				review.add(review1);
			}
			return review;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
