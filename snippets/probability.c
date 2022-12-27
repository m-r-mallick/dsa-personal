#include<stdio.h>
int main() {
	int a, i, d = 0;
	double e;
	scanf("%d", &a);
	for (i = 1;i <= a;i++) {
		if (i % 2 != 0) d++;
	}
//	e = (d * 1.0) / (a * 1.0);
	e = (float) d / (float) a;
	printf("%f", e);
	return 0;
}
