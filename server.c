//Übungsgruppe:Qianli und Nazar
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

#define FileName "test.txt"
#define MAX_SIZE 256

int main() {
	int fd;
	char buffer[MAX_SIZE];
	printf("Input?\n");
	fgets(buffer,MAX_SIZE-1,stdin);

	struct flock lock;
	lock.l_type = F_WRLCK;   
	lock.l_whence = SEEK_SET; 
	lock.l_start = 0;         
	lock.l_len = 0;          
	lock.l_pid = getpid();   
	if ((fd = open(FileName, O_RDWR | O_CREAT, 0666)) ==-1){  
		fprintf(stderr,"Can't be opened!\n");
		exit(-1);
	}
	if (fcntl(fd, F_SETLK, &lock) < 0){ 
		fprintf(stderr,"Can't not be locked!\n");
		exit(-1);
	}else {
		write(fd,buffer, strlen(buffer));
		fprintf(stdout, "Process %d\n", lock.l_pid);
	}
	lock.l_type = F_UNLCK;
	if (fcntl(fd, F_SETLK, &lock) < 0){
		fprintf(stderr,"Can't be unlocked!\n");
		exit(-1);
	}
	close(fd); 
	return 0; 
}

