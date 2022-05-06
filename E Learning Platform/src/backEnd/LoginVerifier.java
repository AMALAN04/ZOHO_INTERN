package backEnd;

public class LoginVerifier implements Login {
	Verifier access = new Verifier();

	// verify login details
	public String verifyLogin(String id, String Password) {
		if (id.startsWith("T")) {
			String instructorName = Verifier.verifyLoginDetails("instructor", id, Password);
			if (instructorName != null) {
				return instructorName;
			} else {
				return null;
			}
		} else if (id.startsWith("S")) {
			String instructorName = Verifier.verifyLoginDetails("student", id, Password);
			if (instructorName != null) {
				return instructorName;
			} else {
				return null;
			}
		}
		return null;
	}
}
