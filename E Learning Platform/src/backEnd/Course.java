package backEnd;

public class Course {
	private int courseId;
	public String courseName;
	public int categoryId;
	public String description;
	private float rating;
	private int noOfStudents;
	public int price;

	public Course() {
		this.courseId = Verifier.lastInsertedId("course") + 1;
		this.rating = 0;
		this.noOfStudents = 0;
	}

	public int getcourseId() {
		return this.courseId;
	}

	public float getrating() {
		return this.rating;
	}

	public int getnoOfStudents() {
		return this.getnoOfStudents();
	}

}
