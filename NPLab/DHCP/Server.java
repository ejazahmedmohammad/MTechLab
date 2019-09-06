import java.io.*;
import java.net.*;

class Server {

  DatagramSocket serverSocket;

  Server(int port){
    try {
        serverSocket = new DatagramSocket(port);
    }
    catch(Exception e){

    }

  }
  void startServer() {
    DatagramPacket DpReceive;
    byte[] remoteInput = new byte[65535];
try {
    while (true)
       {
          DpReceive = new DatagramPacket(remoteInput, remoteInput.length);
          serverSocket.receive(DpReceive);
          String remii = data(remoteInput).toString();
          System.out.println("Client:-" +remii);
          // Exit the server if the client sends "bye"
          if (remii.equals("Discover"))
          {
              System.out.println("In Discovery ");
              Offer(DpReceive);

          }
           // Exit the server if the client sends "bye"
           if (remii.equals("Request"))
           {
               System.out.println("After request ");
              Acknowledge(DpReceive);
           }

           // Clear the buffer after every message.
           remoteInput = new byte[65535];
       }
     }
     catch(Exception e){
       System.out.println(e);
     }
  }
  void Offer(DatagramPacket rec) throws Exception {

    byte[] remoteOutput="This is your new ip".getBytes();

    DatagramPacket sendPacket = new DatagramPacket(remoteOutput, remoteOutput.length, rec.getAddress(),2121);
    serverSocket.send(sendPacket);

  }

  void Acknowledge(DatagramPacket rec) throws Exception {
      byte[]  remoteOutput="This is your Config Info".getBytes();

    DatagramPacket sendPacket = new DatagramPacket(remoteOutput, remoteOutput.length, rec.getAddress(),2121);
    serverSocket.send(sendPacket);

  }


  public static StringBuilder data(byte[] a)
     {
         if (a == null)
             return null;
         StringBuilder ret = new StringBuilder();
         int i = 0;
         while (a[i] != 0)
         {
             ret.append((char) a[i]);
             i++;
         }
         return ret;
     }

  public static void main(String[] args) {
    try {
    Server tmp = new Server(4445);
    tmp.startServer();
  }
  catch(Exception e){
    System.out.println(e);
  }
  }

}
