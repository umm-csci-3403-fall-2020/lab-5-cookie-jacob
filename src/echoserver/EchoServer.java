package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket sock = new ServerSocket(portNumber);

            while(true){
                Socket client = sock.accept();

                //Take in client input and send it back

                client.close();
            }

        } catch (IOException ioe) {
            System.out.println("ERROR: Unexpected exception on server side.");
            System.err.println(ioe);
        }

    }
}
