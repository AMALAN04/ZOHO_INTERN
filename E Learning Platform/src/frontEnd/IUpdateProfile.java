package frontEnd;

import java.util.Scanner;

import backEnd.*;

public class IUpdateProfile implements UpdateProfileFunctionality {
	// Update profile information
	public void updateProfile(String id) {
		Scanner input = new Scanner(System.in);
		boolean updateFlag = true;
		while (updateFlag) {
			System.out.println("Update Name        -1");
			System.out.println("Update Contact No  -2");
			System.out.println("Update DOB         -3");
			System.out.println("Update Gender      -4");
			System.out.println("Update Skill Set   -5");
			System.out.println("Change Password    -6");
			System.out.println("Back               -7");
			int choice = new ExceptionClass().intException("Enter Your choice : ", 1, 7);
			switch (choice) {
			case 1:
				System.out.print("\nEnter Name : ");
				String updatedName = input.nextLine();
				if (Update.updateProfile("instructor", "name", updatedName, id))
					System.out.println("\n...Updated...");
				else
					System.out.println("\nSomething Went Wrong");
				break;
			case 2:
				String updateContactNo = new ExceptionClass().phoneNoException("Enter Contact Number :");
				if (Update.updateProfile("instructor", "contactNo", updateContactNo, id))
					System.out.println("\n...Updated...");
				else
					System.out.println("\nSomething Went Wrong");
				break;
			case 3:
				String dob = new ExceptionClass().dobException("Enter Your DOB(yyyy-MM-DD) : ");
				String updateage = dob;
				if (Update.updateProfile("instructor", "DOB", updateage, id))
					System.out.println("\n...Updated...");
				else
					System.out.println("\nSomething Went Wrong");
				break;
			case 4:
				System.out.print("\nEnter your gender : ");
				String updateGender = input.nextLine();
				if (Update.updateProfile("instructor", "gender", updateGender, id))
					System.out.println("\n...Updated...");
				else
					System.out.println("\nSomething Went Wrong");
				break;
			case 5:
				System.out.print("\nEnter your SkillSet : ");
				String updateSkillSet = input.nextLine();
				if (Update.updateProfile("instructor", "skillset", updateSkillSet, id))
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
					System.out.println("Enter your new password : ");
					String updatePassword = input.nextLine();
					if (Update.updateProfile("instructor", "password", updatePassword, id))
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
