package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket sock = new ServerSocket(portNumber); //a socket with the portnumber

            while(true){
                Socket client = sock.accept(); //waiting for client connection on the port
		InputStream input = client.getInputStream(); //input stream that it receives from the client
		OutputStream output = client.getOutputStream(); //output stream that it will return to the client
		
		int inputByte; //bytes of info in their ASCII values
		char c; 
		while ((inputByte = input.read())!= -1){ //while there is info being funneled in from the client
			c = (char)inputByte; //casting the int to a character to return the input instead of the ASCII value
			output.write(c); //writing to the output stream which will go to the client (PREPARE FOR TAKE OFF)
			output.flush(); //flushing the outputstream to the client (LAUNCH!)
		}

                client.close(); //closing connection with client
		sock.close(); //closing socket
            }

        } catch (IOException ioe) {
            System.out.println("ERROR: Unexpected exception on server side.");
            System.err.println(ioe);
        }
    }
}
