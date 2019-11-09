#include<stdio.h>
#include<stdlib.h>
 #include <unistd.h>
#include <sys/types.h>
       #include <sys/stat.h>
int main() {

	pid_t pid, sid;

        /* Fork off the parent process */       
        pid = fork();
        if (pid < 0) {
                exit(EXIT_FAILURE);
        }
        /* If we got a good PID, then
           we can exit the parent process. */
        if (pid > 0) {
                exit(EXIT_SUCCESS);
        }
	umask(0);

	sid = setsid();
	if(sid<0){
		exit(EXIT_FAILURE);
	}
	if((chdir("/"))<0)

		exit(EXIT_FAILURE);
	close(STDIN_FILENO);
	close(STDOUT_FILENO);
	close(STDERR_FILENO);

	while(1) {
               printf("Deamon started");
		sleep(30);
		printf("Deamon ended");
	}
	exit(EXIT_SUCCESS);
}
