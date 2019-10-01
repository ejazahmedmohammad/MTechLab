import java.io.*;
import java.net.*;

class Client {
 private DatagramSocket socket;
 private InetAddress address;
 private DatagramSocket serverSocket;
 Client() {
  try {
   socket = new DatagramSocket();
   serverSocket = new DatagramSocket(2121);
   address = InetAddress.getByName("255.255.255.255");
  } catch (Exception e) {}
 }

 String SendMessage(String message) throws Exception {

  socket.setBroadcast(true);

  byte[] buffer = message.getBytes();
  DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4445);
  socket.send(packet);

  byte[] remoteInput = new byte[65535];
  DatagramPacket DpReceive = new DatagramPacket(remoteInput, remoteInput.length);

  serverSocket.receive(DpReceive);

  System.out.println("recived witg messgae " + message);

  System.out.println("endigin witg messgae " + message);
  return data(remoteInput).toString();
 }

 public static StringBuilder data(byte[] a) {
  if (a == null)
   return null;
  StringBuilder ret = new StringBuilder();
  int i = 0;
  while (a[i] != 0) {
   ret.append((char) a[i]);
   i++;
  }
  return ret;
 }


 public static void main(String[] args) {
  try {
   Client tmp = new Client();
   String disResp = tmp.SendMessage("Discover");
   System.out.println(disResp);
   System.out.println("Sending Rquest");
   String reqResponse = tmp.SendMessage("Request");

   System.out.println(reqResponse);
  } catch (Exception e) {
   System.out.println(e);
  }
 }
}