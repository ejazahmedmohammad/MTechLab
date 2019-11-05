#include <stdio.h> 
#include <stdlib.h> 
#include <pthread.h>


void *printHello(void *args){
 int index = *((int *)args);   
   printf("In function  %d \nthread id = %ld\n", index,pthread_self()); 
sleep(1 + rand() %5);
printf("THREAD %ld: Ended.\n", pthread_self());
}


int main(void ) {
pthread_t threads[5];
int thread_args[5];
int i;

for(i=0;i<5;i++){
    thread_args[i] = i; 
 	pthread_create(&threads[i], NULL, printHello,  &thread_args[i]);
}
for (i = 0; i < 5; i++) {
    pthread_join(threads[i], NULL);
    printf("IN MAIN: Thread %d has ended.\n", i);
  }

}
