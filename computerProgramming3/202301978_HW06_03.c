#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
void divide(int a, int b, int *quot, int *rem)
{
    *quot = a / b;
    *rem = a % b;
}

int main() 
{

    int m = 0;
    int n = 0;
    scanf("%d %d", &m, &n);
    int p = 0;
    int q = 0;
    divide(m, n, &p, &q);
    
    printf("%d %d", p, q);
    
    
    return 0;
}
