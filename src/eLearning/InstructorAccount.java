package eLearning;

import java.util.List;

public class InstructorAccount extends InstructorCourseFunctionality implements InstructorFunctionality {

	@Override
	public void setCourse(String id) {
		super.createCourse(id);
		return;

	}

	@Override
	public void viewReview(String id) {
		DataBaseAccessor access = new DataBaseAccessor();
		access.connect();
		List<Review> reviews = access.viewReview(id, 1);
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
			System.out.println("something Went Wrong");
		}catch(Exception e)
		{
			System.out.println("No Review as ");
		}

	}

	public void updateProfile() {
		// TODO Auto-generated method stub

	}

}
