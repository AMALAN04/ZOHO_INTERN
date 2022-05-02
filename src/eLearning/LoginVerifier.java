package eLearning;

public class LoginVerifier implements Login {
	DataBaseAccessor access = new DataBaseAccessor();

	public String verifyLogin(String id, String Password) {
		if (id.startsWith("T")) {
			access.connect();
			String instructorName = access.verifyLoginDetails("instructor", id, Password);
			if (instructorName != null) {
				return instructorName;
			} else {
				return null;
			}
		} else if (id.startsWith("S")) {
			access.connect();
			String instructorName = access.verifyLoginDetails("student", id, Password);
			if (instructorName != null) {
				return instructorName;
			} else {
				return null;
			}
		}
		return null;
	}
}
