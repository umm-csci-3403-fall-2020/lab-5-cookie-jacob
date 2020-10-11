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
			DataInputStream input = new DataInputStream(System.in); //receiving from System.in
			DataOutputStream output = new DataOutputStream(socket.getOutputStream()); //writing to the server
			
			int nextByte = input.read(); //input holder
			char c;

			while (nextByte != -1){ //while there is input
				c = (char)nextByte; //define the input as a character
				output.write(nextByte); //write the byte to the output which will send to the server
				output.flush();
				nextByte = input.read(); //keep reading the next byte
			}

			input.close();
			output.close();
			socket.close();
		}
		catch (ConnectException ce){
			System.out.println("We were unable to connect to " + server);
			System.out.println("You should make sure the server is running.");
		}
		catch (IOException ioe){
			System.out.println("We caught an unexpected exception");
		}
	}
}
