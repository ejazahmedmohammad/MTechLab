#include <stdio.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <string.h>

struct mesg_buffer {
	long mesg_type;
	char mesg_text[100];
} message;

int main() {
  /* code */
  key_t key;
  int msgid;
  	message.mesg_type = 1;
strcpy(message.mesg_text,"hello");
  key = ftok("progfile",65);
  msgid = msgget(key,0666|IPC_CREAT);
  msgsnd(msgid,&message,sizeof(message),0);
	printf("Data is sent  ");
  return 0;
}
