#!/usr/bin/python3
import socket
sock =  socket.socket(socket.AF_INET,socket.SOCK_STREAM)
sock.bind(('localhost',5000))
sock.listen(1)
try:
  while True:
    conn, addr = sock.accept()
    conn.send(conn.recv(1024))
    conn.close()
except:
  print("fa")
