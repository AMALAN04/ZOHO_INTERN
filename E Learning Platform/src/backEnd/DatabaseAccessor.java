package backEnd;

public class DatabaseAccessor {
	public static void connectToDatabase() {
		Verifier.connect();
		Insert.connect();
		Displayers.connect();
		Update.connect();
	}

	public static void disconnectFromDatabase() {
		Verifier.disConnect();
		Insert.disConnect();
		Displayers.disConnect();
		Update.disConnect();

	}

}
