#include <sys/types.h>
#include <dirent.h>
#include<stdio.h>
int main() {

struct dirent *cp;

DIR *dir = opendir(".");
while((cp=readdir(dir))!=NULL){

printf("%s\n",cp->d_name);

}
closedir(dir);
return 0;

}
