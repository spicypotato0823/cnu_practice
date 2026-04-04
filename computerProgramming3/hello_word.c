#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    char c = getchar();
    char str[100];
    char * p = str;
    *p = c;
    
    int i = 1;
    int count = 0;

    do
    {
        if(*(p + i - 1) == c)
        {
            count++;
        }
        else
        {
            *(p + i) = count + 48;
            count = 1;
            i++;
            *(p + i) = c;
            i++;
        }
        
    }while((c = getchar()) != EOF);
    
    *(p + i) = count + 48;
    i++;
    
    for(int j = 0; j < i; j++)
    {
        printf("%c", *(p + j));
    }
    
    return 0;
}
