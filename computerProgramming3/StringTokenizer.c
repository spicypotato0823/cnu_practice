#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    char str[100];

    scanf("%s", str);
    
    int i = 0;
    
    while (str[i] != '\0')
    {
        if(str[i] == '_')
        {
            printf("\n");
        }
        else
        {
            printf("%c", str[i]);
        }
        i++;
    }
    


    return 0;
}