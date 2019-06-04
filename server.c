#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

#define FileName "data.dat"

int main() {
	char buffer[256];
	printf("Input?\n");
	scanf("%s",buffer);
	struct flock lock;
	lock.l_type = F_WRLCK;   
	lock.l_whence = SEEK_SET; 
	lock.l_start = 0;         
	lock.l_len = 0;          
	lock.l_pid = getpid();   

	int fd;
	if ((fd = open(FileName, O_RDWR | O_CREAT, 0666)) < 0){  // -1 signals an error 
		fprintf(stderr,"open failed...");
		exit(-1);
	}
	if (fcntl(fd, F_SETLK, &lock) < 0){ 
		fprintf(stderr,"fcntl failed to get lock...");
		exit(-1);
	}else {
		write(fd,buffer, strlen(buffer));
		fprintf(stderr, "Process %d has written to data file...\n", lock.l_pid);
	}
	lock.l_type = F_UNLCK;
	if (fcntl(fd, F_SETLK, &lock) < 0){
		fprintf(stderr,"explicit unlocking failed...");
		exit(-1);
	}
	close(fd); 
	return 0; 
}
