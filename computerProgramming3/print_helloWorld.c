#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    char c = getchar();
    do
    {
        putchar(c);
    }
    while((c = getchar()) != EOF);
    
    return 0;
}
