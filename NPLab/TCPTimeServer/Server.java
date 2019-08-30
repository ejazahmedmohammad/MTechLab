import java.io.*;
import java.net.*;
import java.util.*;

class Server {

     Socket socket;
     ServerSocket serverSocket;
     DataOutputStream remoteOut;

     Server(int port) {
try{
       serverSocket = new ServerSocket(port);

       socket = serverSocket.accept();
       remoteOut = new DataOutputStream(socket.getOutputStream());

       remoteOut.writeBytes(new Date().toString()  );


    }
    catch(Exception e){

    }
     }


     public static void main(String[] args ){

       Server s = new Server(5000);
     }

}
