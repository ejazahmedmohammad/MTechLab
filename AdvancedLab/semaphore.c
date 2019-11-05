#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>
#include<unistd.h>

sem_t mutex;
int count=0;

void *CS(void *args){
int index = *((int *)args);
while(count<10){
    
sem_wait(&mutex);

count++;
printf("Thead: %d count value : %d  \n",index,count);
sem_post(&mutex);
sleep(3);
}

}

int main() {
int thread_args[2];
thread_args[0]=1;
thread_args[1]=2;
sem_init(&mutex,0,1);
pthread_t t1,t2;
pthread_create(&t1,NULL,CS,&thread_args[0]);
pthread_create(&t2,NULL,CS,&thread_args[1]); 
pthread_join(t1,NULL); 
pthread_join(t2,NULL);

return 0;
}
