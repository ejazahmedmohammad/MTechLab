#!/usr/bin/python3
import socket
sock =  socket.socket(socket.AF_INET,socket.SOCK_STREAM)
sock.bind(('localhost',5000))
sock.listen(1)
try:
  conn, addr = sock.accept()
  while True:
    conn.send(conn.recv(1024))
  conn.close()
except:
  print("fa")
