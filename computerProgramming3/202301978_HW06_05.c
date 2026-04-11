#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    char num[10];

    scanf("%s", num);
    
    int sum = 0;
    int i = 0;
    while(num[i] != '\0')
    {
        sum += num[i] - 48;
        i++;
    }
    
    printf("%d", sum);
    return 0;
}
