package backEnd;

public class DatabaseAccessor {
	public static void connectToDatabase() { // function calls to connect to the database
		Verifier.connect();
		Insert.connect();
		Displayers.connect();
		Update.connect();
	}

	public static void disconnectFromDatabase() { // function calls to disconnect from database
		Verifier.disConnect();
		Insert.disConnect();
		Displayers.disConnect();
		Update.disConnect();

	}

}
