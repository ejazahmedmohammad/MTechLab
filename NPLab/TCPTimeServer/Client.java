import java.io.*;
import java.util.*;
import java.net.*;

class Client {

  Socket socket;
  BufferedReader remoteIn;

  Client(String address,int port) {
    try {
      socket = new Socket(address , port);
      System.out.println("Connected");
      remoteIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      System.out.println(remoteIn.readLine());
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args ){
    Client s = new Client("127.0.0.1",5000);
  }
  
}
