#include <sys/mman.h>
     #include <string.h>
 #include <fcntl.h>           /* For O_* constants */
       #include <sys/stat.h>        /* For mode constants */
       #include <semaphore.h>
 #include <unistd.h>
       #include <sys/types.h>
int main() {
int i=0;
int fd = shm_open("progfile",O_RDWR,0644);
caddr_t mmptr = mmap(NULL,1024,PROT_READ|PROT_WRITE,MAP_SHARED,fd,0);
sem_t *semptr=sem_open("progfile.sem",O_CREAT,0644,0);
if(!sem_wait(semptr) ){
for(i=0;i<10;i++){
write(STDOUT_FILENO,mmptr+i,1);
}
sem_post(semptr);
}
close(fd);
sem_close(semptr);
munmap(mmptr,1024);
shm_unlink("progfile");
}

