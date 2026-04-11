#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void vector_add(int * a, int * b, int * result, int n)
{
    for(int i = 0; i < n; i++)
    {
        result[i] = a[i] + b[i];
    }
}

int main() 
{
    int n = 0;
    scanf("%d", &n);
    int a[n];
    int b[n];
    int result[n];
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &b[i]);
    }
    
    vector_add(a, b, result, n);
    
    for(int i = 0; i < n; i++)
    {
        printf("%d ", result[i]);
    }
    return 0;
}
