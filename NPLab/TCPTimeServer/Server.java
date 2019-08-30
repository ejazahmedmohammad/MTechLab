import java.io.*;
import java.net.*;
import java.util.*;

class Server {

     Socket socket;
     ServerSocket serverSocket;
     DataOutputStream remoteOut;

     Server(int port) {
       try  {
         serverSocket = new ServerSocket(port);
         System.out.println("Waiting for Connection");
         socket = serverSocket.accept();
         System.out.println("Client accepted");
         remoteOut = new DataOutputStream(socket.getOutputStream());
         remoteOut.writeBytes(new Date().toString());
       }
       catch(Exception e){
         System.out.println(e);
      }
     }

     public static void main(String[] args ) {
       Server s = new Server(5000);
     }

}
