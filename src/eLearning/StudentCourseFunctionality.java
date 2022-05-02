package eLearning;

import java.util.List;
import java.util.Scanner;

public class StudentCourseFunctionality {
	 Scanner input = new Scanner(System.in);
	 DataBaseAccessor access = new DataBaseAccessor();
	void purchaseCourse(String sId,String courseId)
	{
		DataBaseAccessor access = new DataBaseAccessor();
		access.connect();
		boolean status =access.purchaseCourse(sId,courseId);
		if(status)
		 {
			 System.out.println("Purchased"); 
		 }
		
	}
	void addReview(String sId)
	{
		Review review = new Review();
		int courseId =  new ExceptionClass().intException("Enter Course Id");
		review.studentId=sId;
		review.courseId =courseId;
		review.rating = new ExceptionClass().intException("Your rating out of 5");
		int choice = new ExceptionClass().intException("Do Your Like to Add a Comment\nYes -1\nNo -2");
		if(choice==1)
		{
			System.out.println("Enter Your Comment");
			input.nextLine();
			review.comments= input.nextLine();
		}
		access.connect();
		boolean status =access.addReview(review);
		if(status)
		{
			System.out.println("Review Added"); 
		}
		else {
				System.out.println("Something Went Wrong"); 
		}
		
		
		
		
	}
	void viewDetails(String sid)
	{
		System.out.println("Enter Course Id"); 
		String courseId = input.next();
		DataBaseAccessor access = new DataBaseAccessor();
		access.connect();
		CourseDetailsTemplate details =access.viewCourseDetails(courseId);
		try {
		if(details!=null)
		{
		System.out.println("Course Id       :"+details.courseId);
		System.out.println("Course Name     :"+details.courseName);
		System.out.println("Category Id     :"+details.categoryId);
		System.out.println("Category Name   :"+details.categoryName);
		System.out.println("Description     :"+details.description);
		System.out.println("Instructor ID   :"+details.instructorId);
		System.out.println("Instructor Name :"+details.instructorName);
		System.out.println("No Of Students  :"+details.noOfStudents);
		System.out.println("Rating          :"+details.rating);
		System.out.println("Price           :"+details.price);
		}
		}
		catch(Exception e) {
			System.out.println("Enter a valid Couse ID");
			return;
		}
		
		boolean loopFlag =true;
		while (loopFlag) {
			System.out.println("View Reviews      - 1");
			System.out.println("Purchase Course   - 2");
			System.out.println("Back              - 3");
			int choice =  new ExceptionClass().intException("Enter Your Choice");
			switch(choice) {
			case 1:
				List<Review> reviews=access.viewReview(courseId, 0);
				try {
				if(reviews.get(0).comments==null)
					System.out.println("No reviews as yet\n");
				for(Review review:reviews)
				{
					System.out.println("Student Name : "+review.Sname);
					System.out.println("Review       : "+review.comments);
					
				}
				}catch(Exception e) {
					System.out.println("\n...No reviews as yet...\n");
				}
				
				break;
			case 2:
				this.purchaseCourse(sid, courseId);
				break;
			case 3:
				loopFlag =false;
				break;
			default:
				System.out.println("Enter a Valid option");
				
				
			}
				
			
		}
		
		
		
		
		
	}
	void accessFavCourse(String sId,int fav)
	{
		System.out.println("Enter Course Id"); 
		String courseId = input.next();
		DataBaseAccessor access = new DataBaseAccessor();
		access.connect();
		boolean status =access.favouriteCourse(sId,courseId,fav );
		if(status && fav ==1)
		{
			System.out.println(courseId +"Successfully Added to Favourite List"); 
		}
		else if(status && fav ==0) {
			System.out.println(courseId +"Successfully Removed from your Favourite List"); 
		}
		else {
			System.out.println("Something Went Wrong");
		}
			
	}
	

}
