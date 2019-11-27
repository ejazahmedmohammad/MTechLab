#include <sys/mman.h>
     #include <string.h>
 #include <fcntl.h>           /* For O_* constants */
       #include <sys/stat.h>        /* For mode constants */
       #include <semaphore.h>
 #include <unistd.h>
       #include <sys/types.h>
int main() {
int fd = shm_open("progfile",O_RDWR|O_CREAT,0666);
ftruncate(fd,1024);
caddr_t mmptr = mmap(NULL,1024,PROT_READ|PROT_WRITE,MAP_SHARED,fd,0);
sem_t *semptr=sem_open("progfile.sem",O_CREAT,0644,0);
strcpy(mmptr,"helloworld");
sem_post(semptr);
sleep(12);
munmap(mmptr,1024);
close(fd);
sem_close(semptr);
shm_unlink("progfile");
return 0;
}

