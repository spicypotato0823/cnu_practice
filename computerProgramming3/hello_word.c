#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void swap(int * a, int * b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main() 
{
    int num1 = 10;
    int num2 = 20;

    int * p = &num1;
    int ** dp = &p;

    swap(&num1, &num2);

    printf("%d %d\n", num1, num2);

    printf("dp : %p p : %p num1 : %p", &dp, &p, &num1);

    return 0;
}
