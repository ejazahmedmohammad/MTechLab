import java.io.*;
import java.net.*;

class Client{


String Request() throws Exception {
  String broadcastMessage="Request";
  InetAddress address=InetAddress.getByName("255.255.255.255");
       DatagramSocket  socket = new DatagramSocket();
       socket.setBroadcast(true);

       byte[] buffer = broadcastMessage.getBytes();

       DatagramPacket packet
         = new DatagramPacket(buffer, buffer.length, address, 4445);
       socket.send(packet);
       socket.close();
         byte[] remoteInput = new byte[65535];
      DatagramPacket DpReceive = new DatagramPacket(remoteInput, remoteInput.length);
      DatagramSocket serverSocket = new DatagramSocket(2121);
       serverSocket.receive(DpReceive);
       serverSocket.close();
       socket.close();
      return data(remoteInput).toString();

  }



  String Discovery() throws Exception {
    String broadcastMessage="Discover";
         InetAddress address=InetAddress.getByName("255.255.255.255");
         DatagramSocket  socket = new DatagramSocket();
         socket.setBroadcast(true);

         byte[] buffer = broadcastMessage.getBytes();

         DatagramPacket packet
           = new DatagramPacket(buffer, buffer.length, address, 4445);
         socket.send(packet);
         socket.close();
        byte[] remoteInput = new byte[65535];
        DatagramPacket DpReceive = new DatagramPacket(remoteInput, remoteInput.length);
        DatagramSocket serverSocket = new DatagramSocket(2121);
         serverSocket.receive(DpReceive);
         socket.close();
         serverSocket.close();
         return data(remoteInput).toString();

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


 public static void main(String[] args){
try {
   Client tmp = new Client();

   String disResp = tmp.Discovery();
   System.out.println(disResp);
   String reqResponse = tmp.Request();
   System.out.println(reqResponse);
 }
 catch(Exception e) {
   System.out.println(e);
 }
 }
}
