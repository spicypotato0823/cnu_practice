#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    int n = 0;
    scanf("%d", &n);
    int num [n];
    int t;
    for(int i = 0; i < n; i++)
    {
        int number;
        scanf("%d", &number);
        num[i] = number;
    }
    scanf("%d", &t);
    int i = 0;
    for(i = 0; i < n; i++)
    {
        if(num[i] == t)
        {
            printf("%d", i);
            break;
        }
    }
    if(i == n)
    {
        printf("-1");
    }
    return 0;
}
