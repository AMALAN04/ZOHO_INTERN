package frontEnd;

import java.util.Scanner;

import backEnd.Login;
import backEnd.LoginVerifier;
import backEnd.Update;

public class SUpdateProfile implements UpdateProfileFunctionality {
	public void updateProfile(String id) {
		Scanner input = new Scanner(System.in);
		boolean updateFlag = true;
		while (updateFlag) {
			System.out.println("Update Name                     -1");
			System.out.println("Update Contact No               -2");
			System.out.println("Age                             -3");
			System.out.println("Gender                          -4");
			System.out.println("Educational Qualificatin        -5");
			System.out.println("Password                        -6");
			System.out.println("Back                            -7");
			int choice = new ExceptionClass().intException("Enter Your choice", 1, 7);
			switch (choice) {
			case 1:
				System.out.print("\nEnter Name :");
				String updatedName = input.nextLine();
				if (Update.updateProfile("student", "name", updatedName, id))
					System.out.println("\n...Updated...");
				else
					System.out.println("Something Went Wrong");
				break;
			case 2:
				String updateContactNo = new ExceptionClass().phoneNoException("Enter Contact Number");
				if (Update.updateProfile("student", "contactNo", updateContactNo, id))
					System.out.println("\n...Updated...");
				else
					System.out.println("\nSomething Went Wrong");
				break;
			case 3:
				String dob = new ExceptionClass().dobException("Enter Your DOB(yyyy-MM-DD) : ");
				String updateage = dob ;
				if (Update.updateProfile("student", "DOB", updateage, id))
					System.out.println("\n...Updated...");
				else
					System.out.println("\nSomething Went Wrong");
				break;
			case 4:
				System.out.print("\nEnter your gender :");
				String updateGender = input.nextLine();

				if (Update.updateProfile(" student", "gender", updateGender, id))
					System.out.println("\n...Updated...");
				else
					System.out.print("\nSomething Went Wrong");
				break;
			case 5:
				System.out.print("\nEnter your Educational Qualification : ");
				String updateSkillSet = input.nextLine();
				if (Update.updateProfile("student", "eQualification", updateSkillSet, id))
					System.out.println("\n...Updated...");
				else
					System.out.println("\nSomething Went Wrong");
				break;
			case 6:
				System.out.print("\nEnter your old password : ");
				String Password = input.nextLine();
				Login login = new LoginVerifier();
				String name = login.verifyLogin(id, Password);
				if (name != null) {
					System.out.print("\nEnter your new password : ");
					String updatePassword = input.nextLine();
					if (Update.updateProfile("student", "password", updatePassword, id))
						System.out.println("\n...Updated...");
					else
						System.out.println("\nSomething Went Wrong");

					break;
				} else {
					System.out.println("\nPassword Mismatch");
					break;
				}
			case 7:
				updateFlag = false;

			}

		}

	}
}
