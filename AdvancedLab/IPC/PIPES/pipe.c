#include <stdio.h>
#include <string.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>


int main()
{
  int p[2];
  int pid;
  char arr1[19];

  if(pipe(p)<0){
    printf("Something wrong with pipe");
    return -1;
  }
  pid=fork();
  if(pid==0){
        write(p[1], "Hello from parent", 19);
  }
  else{
   		read(p[0], arr1, sizeof(arr1));
      printf("%s\n",arr1 );

  }

}
