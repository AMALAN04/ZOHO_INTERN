package frontEnd;

import java.util.Scanner;

import backEnd.Review;
import backEnd.Update;
import backEnd.Verifier;

public class SAddReview implements SAddReviewFunctionality {
	public void addReview(String sId) {
		Scanner input = new Scanner(System.in);
		Review review = new Review();
		int courseId = new ExceptionClass().intException("Enter Course Id : ", 1, 100);
		review.studentId = sId;
		review.courseId = courseId;
		review.rating = new ExceptionClass().intException("Your rating out of 5 : ", 1, 5);
		int choice = new ExceptionClass().intException("Do Your Like to Add a Comment\nYes -1\nNo -2\nEnter Your Choice : ", 1, 2);
		if (choice == 1) {
			System.out.print("\nEnter Your Comment : ");
			review.comments = input.nextLine();
		}
		boolean status = Update.addReview(review);
		if (status) {
			System.out.println("Review Added");
		} else {
			System.out.println("\nSomething Went Wrong");
		}
	}

}
