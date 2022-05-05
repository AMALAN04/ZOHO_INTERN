package frontEnd;

import java.util.Scanner;

import backEnd.Insert;
import backEnd.StudentTemplate;
import backEnd.Verifier;

public class StudentRegistration extends StudentTemplate implements User {
	private String Id;
	private int noOfCoursesOpted;

	public void setDetails() {
		Scanner input = new Scanner(System.in);
		this.Id = ("S" + (Verifier.lastInsertedId("student") + 1));
		System.out.print("\nEnter your name : ");
		this.name = input.nextLine();
		String mail = new ExceptionClass().emailException("Enter your Mail Id :");
		this.emailId = mail.toLowerCase();
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
		boolean currentStatus = true;
		int choice = -1;
		while (currentStatus) {
			choice = new ExceptionClass().intException(
					"Enter Additional Details - 1\n" + "To Skipp                 - 2\nEnter Your Choice : ", 1, 2);
			if (choice >= 1 && choice <= 2)
				currentStatus = false;
		}
		if (choice == 1) {
			this.contactNo = new ExceptionClass().phoneNoException("\nEnter Contact Number : ");
			this.dob = new ExceptionClass().dobException("Enter Your DOB(yyyy-MM-DD) : ");
			int genderChoice = new ExceptionClass().intException(
					"Enter Gender" + "\nMale   -1" + "\nFemale -2\nSkip   -3\nEnter Your Choice : ", 1, 3);
			if (genderChoice == 1) {
				this.gender = "MALE";
			} else if (genderChoice == 2) {
				this.gender = "FEMALE";
			} else
				this.gender = null;
			System.out.print("\nEnter your Educational Qualification : ");
			this.eQualification = input.next();
		}
		boolean status = Insert.addStudent(this);
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
			System.out.println("\nSorry something went wrong");
			return;
		}

	}

	public String getId() {
		return this.Id;
	}

	public int getNoOfCoursesOpted() {
		return this.noOfCoursesOpted;
	}

	public String getPassword() {
		return this.password;
	}

}
