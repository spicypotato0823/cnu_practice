#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    int x = 0;
    scanf("%d", &x);
    
    for(int i = 0; i < x; i++)
    {
        for(int j = 0; j <= i; j++)
        {
            printf("*");
        }

        printf("\n");
    }
    return 0;
}
