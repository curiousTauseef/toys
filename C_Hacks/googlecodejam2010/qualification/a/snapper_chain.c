#include <stdio.h>
/**
 * Supposing that each of the n snappers can be represented by a bit (ON(1) or OFF(0))
 * and each snap represents an increment on this number, that starts with zero and 
 * considering that the change of state of a snapper follow the same restriction 
 * of the increment of a binary number we just need to check if after k snaps, 
 * all the n bits are ON
 *
 * @author Felipe Ribeiro <felipernb@gmail.com>
 */

int isON(int snappers, int snaps);

int main(void) {
	int t; //Number of tests
	unsigned int n; //number of snappers
	unsigned int k; //number of snaps
	int i;

	scanf("%d",&t);
	for(i=0; i<t; i++) {
		scanf("%d",&n);
		scanf("%d",&k);
		printf("Case #%d: %s\n",i+1,isON(n,k)?"ON":"OFF");
	}
}

int isON(int n,int k) {
	int i, tmp_k, sum=0;
	for(i=0; i < n; i++) {
		sum += (k & 1);
		k = k >> 1;
	}
	return sum > 0 && sum == n;
}
