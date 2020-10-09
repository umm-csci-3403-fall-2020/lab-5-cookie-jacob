package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
	public static final int portNumber = 6013;

	public static void main(String[] args) throws IOException {
		String server;
		if (args.length == 0){
			server = "127.0.0.1";
		} else {
			server = args[0];
		}

		try {
			Socket socket = new Socket(server, portNumber);
			System.out.println("Connected to "+server+" on port "+portNumber);

			//Take in keyboard input and send it to the server
			DataInputStream input = new DataInputStream(System.in);

			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			//Print the server input


			input.close();
			output.close();
			socket.close();
		}
		catch (ConnectException ce) {
			System.out.println("Unable to connect to " + server);
			System.out.println("Make sure the server is running.");
		}
		catch (IOException ioe) {
			System.out.println("ERROR: Unexpected exception on client side.");
			System.err.println(ioe);
		}
	}
}
