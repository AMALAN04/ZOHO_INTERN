package eLearning;

import java.util.Scanner;

public class InstructorRegistration implements User {
	DataBaseAccessor access = new DataBaseAccessor();
	private String Id;
	public String name;
	public String emailId;
	public String password;
	public String contactNo;
	public int age;
	public String gender;
	public String skillSet;
	private int noOfCoursesOffered;
	private float rating;
	public InstructorRegistration() {
		access.connect();
		this.Id = ("T" + (access.lastInsertedId("instructor") + 1));
		this.noOfCoursesOffered = 0;
		this.rating = 0;
	}
	public void setDetails() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name");
		this.name = input.nextLine();
		String mail = new ExceptionClass().emailException("Enter your Mail Id");
		this.emailId = mail.toLowerCase();
		String passWord = "";
		boolean passwordFlag = true;
		while (passwordFlag) {
			System.out.println("Enter Password");
			passWord = input.nextLine();
			System.out.println("Confirm Password");
			String confirmPassWord = input.nextLine();
			if (passWord.equals(confirmPassWord))
				passwordFlag = false;
			else
				System.out.println("Password Mismatch, Enter again");
		}
		this.password = passWord;
		boolean currentStatus = true;
		int choice = -1;
		while (currentStatus) {
			choice = new ExceptionClass()
					.intException("Enter Additional Details - 1\n" + "To Skipp                 - 2");
			if (choice >= 1 && choice <= 2)
				currentStatus = false;
		}
		if (choice == 1) {
			this.contactNo = new ExceptionClass().phoneNoException("\nEnter Contact Number");
			this.age = new ExceptionClass().intException("Enter Your Age");
			int genderChoice = new ExceptionClass().intException("Enter Gender" + "\nMale   -1" + "\nFemale -2\nSkip   -3");
			if (genderChoice == 1) {
				this.gender = "MALE";
			} else if (genderChoice == 2) {
				this.gender = "FEMALE";
			} else
				this.gender = null;
			System.out.println("Enter your SkillSet");
			this.skillSet = input.next();
		}
		boolean status = access.addInstructor(this);
		if (status) {
			for (int i = 0; i < 66; i += 1) {
				if (i < 40)
					System.out.print(" ");
				else
					System.out.print("-");
			}
			System.out.printf("\n%-40s|     %-20s|\n", " ", "Inserted Succesfully");
			System.out.printf("%-40s|     %-20s|\n", " ", "  Your Id " + this.Id);
			for (int i = 0; i < 66; i += 1) {
				if (i < 40)
					System.out.print(" ");
				else
					System.out.print("-");
			}
			System.out.println();
		} else {
			System.out.println("Sorry something went wrong");
			return;
		}
	}
	public String getId() {
		return this.Id;
	}
	public int getNoOfCoursesOffered() {
		return this.noOfCoursesOffered;
	}

	public float getRating() {
		return this.rating;
	}
	public String getPassword() {
		return this.password;
	}
}
