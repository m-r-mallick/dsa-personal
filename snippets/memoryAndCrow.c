#include<stdio.h>
int main() {
	int n, i, j;
	scanf("%d", &n);
	int b[n], a[n];
	for (i = 0;i < n;i++) {
		scanf("%d", &a[i]);
	}
	for (i = 0;i < n - 1;i++) {
		j = i + 1;
		b[i] = a[i] + a[j];
	}
	b[n - 1] = a[n - 1];
	for (i = 0;i < n;i++) {
		printf("%d ", b[i]);
	}
	printf("\n");
	return 0;
}
