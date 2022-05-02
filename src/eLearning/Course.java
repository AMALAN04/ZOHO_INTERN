package eLearning;

public class Course {
	private int courseId;
	String courseName;
	int categoryId;
	String description;
	private float rating;
	private int noOfStudents;
	int price;
	public Course() {
		DataBaseAccessor access = new DataBaseAccessor();
		access.connect();
		this.courseId= access.lastInsertedId("course")+1;
		this.rating=0;
		this.noOfStudents=0;
	}
	public int getcourseId()
	{
		return this.courseId;
	}
	public float getrating()
	{
		return this.rating;
	}
	public int getnoOfStudents()
	{
		return this.getnoOfStudents();
	}

}

