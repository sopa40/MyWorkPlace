#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

#define FileName "test.txt"

int main() {
	struct flock lock;
	lock.l_type = F_WRLCK;   
	lock.l_whence = SEEK_SET; 
	lock.l_start = 0;         
	lock.l_len = 0;           
	lock.l_pid = getpid();   

	int fd; 
	if ((fd = open(FileName, O_RDONLY)) < 0)  
		fprintf(stderr,"Can't be opened!\n");

	fcntl(fd, F_GETLK, &lock);
	if (lock.l_type != F_UNLCK)
		fprintf(stderr,"Write locked!\n");

	lock.l_type = F_RDLCK; 
	if (fcntl(fd, F_SETLK, &lock) < 0)
		fprintf(stderr,"Can't get a read-only lock!\n");

	int c; 
	while (read(fd, &c, 1) > 0)    
		write(STDOUT_FILENO, &c, 1); 
	lock.l_type = F_UNLCK;
	if (fcntl(fd, F_SETLK, &lock) < 0)
		fprintf(stderr,"Can't be unlocked!\n");
	close(fd);
	return 0;
}
