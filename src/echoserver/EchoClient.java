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
			//DataInputStream input = new DataInputStream(System.in); //receiving from System.in
			//DataOutputStream output = new DataOutputStream(socket.getOutputStream()); //writing to the server
			InputStream input = socket.getInputStream(); //Input stream from the server, so it's showing what the server sends
			OutputStream output = socket.getOutputStream(); //Output stream going to the server


			int nextByte; //gives the ASCII value of the characters in the input
			char c;

			while ((nextByte = System.in.read()) != -1){ //while there is input
				c = (char)nextByte; //casting to a character so it returns what you actually input instead of your input's ASCII value
				output.write(c); //write the byte to the output which will send to the server
				output.flush(); //send the output to the server
				System.out.write(input.read()); //server writing what it needs to send back to the client
								//System.out.write deals with a stream of bytes
				System.out.flush(); //flush the info from the server to the client 
			}
			//DataInputStream input = new DataInputStream(socket.getInputStream());
			//DataOutputStream output = new DataOutputStream(System.in);

			//input.close();
			//output.close();
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
