#include <stdio.h>
#include <sys/ipc.h>
#include <sys/msg.h>

struct mesg_buffer {
	long mesg_type;
	char mesg_text[100];
} message;

int main() {
  key_t key;
  int msgid;


  // ftok to generate unique key
  key = ftok("progfile", 65);

  // msgget creates a message queue
  // and returns identifier
  msgid = msgget(key, 0666 | IPC_CREAT);

  // msgrcv to receive message
  msgrcv(msgid, &message, sizeof(message), 1, 0);

  printf("Data Received is : %s \n",
					message.mesg_text);
  	msgctl(msgid, IPC_RMID, NULL);
  return 0;
}
