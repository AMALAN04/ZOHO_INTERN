package frontEnd;

import java.util.Scanner;

import backEnd.Insert;
import backEnd.InstructorTemplate;
import backEnd.Verifier;

public class InstructorRegistration extends InstructorTemplate implements User {
	private String id;
	private int noOfCourseOffered = 0;
	private float instructorRating = 0;
                                                            //Instructor Registration
	public void setDetails() {
		this.id = ("T" + (Verifier.lastInsertedId("instructor") + 1));
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter your name : ");
		this.name = input.nextLine();
		String mail = new ExceptionClass().emailException("Enter your Mail Id : ");
		this.instructorEmail = mail.toLowerCase();
		String passWord = "";
		boolean passwordFlag = true;
		while (passwordFlag) {
			System.out.print("\nEnter Password : ");
			passWord = input.nextLine();
			System.out.print("\nConfirm Password : ");
			String confirmPassWord = input.nextLine();
			if (passWord.equals(confirmPassWord))
				passwordFlag = false;
			else
				System.out.println("\nPassword Mismatch, Enter again");
		}
		this.password = passWord;
		int choice = -1;
		choice = new ExceptionClass().intException(
				"Enter Additional Details - 1\n" + "To Skipp                 - 2\nEnter Your choice : ", 1, 2);
		if (choice == 1) {
			this.instructorContactNo = new ExceptionClass().phoneNoException("Enter Contact Number : ");
			this.dob = new ExceptionClass().dobException("Enter Your DOB(yyyy-MM-DD) : ");
			int genderChoice = new ExceptionClass().intException(
					"Enter Gender" + "\nMale   -1" + "\nFemale -2\nSkip   -3\nEnter Your Choice : ", 1, 3);
			if (genderChoice == 1) {
				this.gender = "MALE";
			} else if (genderChoice == 2) {
				this.gender = "FEMALE";
			} else
				this.gender = null;
			System.out.print("\nEnter your SkillSet :");
			this.skillSet = input.next();
		}
		boolean status = Insert.addInstructor(this);
		if (status) {
			for (int i = 0; i < 66; i += 1) {
				if (i < 40)
					System.out.print(" ");
				else
					System.out.print("-");
			}
			System.out.printf("\n%-40s|     %-20s|\n", " ", "Inserted Succesfully");
			System.out.printf("%-40s|     %-20s|\n", " ", "  Your Id " + this.id);
			for (int i = 0; i < 66; i += 1) {
				if (i < 40)
					System.out.print(" ");
				else
					System.out.print("-");
			}
			System.out.println();
		} else {
			System.out.println("\nSorry something went wrong");
			return;
		}
	}

	public String getId() {
		return this.id;
	}

	public int getNoOfCoursesOffered() {
		return this.noOfCourseOffered;
	}

	public float getRating() {
		return this.instructorRating;
	}

	public String getPassword() {
		return this.password;
	}
}
