package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
	public static final int portNumber = 6013;
	public static void main(String[] args) throws IOException {
		String server;
		if (args.length == 0){
			server = "127.0.0.1"; //IP address of server
		}
		else {
			server = args[0]; //Take in the given address as the server
		}

		try {
			Socket socket = new Socket(server, portNumber); //creating socket connection using portNumber
			InputStream input = socket.getInputStream(); //input from the user
			Reader inputStreamReader = new InputStreamReader(input); //reader to read the input
			int nextByte = inputStream.read(); //input holder
			char c;
			while (nextByte != -1){ //while there is input
				c = (char)nextByte; //define the input as a character
				System.out.println(c); //print out what is input
				nextByte = inputStream.read(); //keep reading
			}
			inputStreamReader.close();
			socket.close();
		}
		catch (ConnectException ce){
			System.out.println("We were unable to connect to " + server);
			System.out.println("You should make sure the server is running.");
		}
		catch (IOException ioe){
			System.out.println("We caught an unexpected exception");
			System.err.println(ioe);
		}
	}
}
