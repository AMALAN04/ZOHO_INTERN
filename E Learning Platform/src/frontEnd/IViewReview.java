package frontEnd;

import java.util.List;

import backEnd.Displayers;
import backEnd.Review;

public class IViewReview implements IViewReviewFunctionality {
	// To view course wise review
	public void viewReview(String id) {
		List<Review> reviews = Displayers.viewReview(id, 1);
		try {
			if (reviews.get(0).courseName != null) {
				String preName = reviews.get(0).courseName;
				System.out.println("Course Name  : " + preName);
				for (Review review : reviews) {
					if (!(review.courseName).equals(preName)) {
						System.out.println("Course Name  : " + review.courseName);
						preName = review.courseName;
					}
					System.out.println("Student Name : " + review.Sname);
					System.out.println("Review       : " + review.comments);

				}
			} else
				System.out.println("\nsomething Went Wrong");
		} catch (Exception e) {
			System.out.println("\nNo Review As Yet");
		}

	}
}
