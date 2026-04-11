#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    char * language[5] = {"C", "Java", "Kotlin", "Python", "Rust"};
    int m = 0;
    int n = 0;
    scanf("%d %d", &m, &n);
    char * p = language + m;
    language[m] = language[n];
    language[n] = p;
    
    for(int i = 0; i < 5; i++)
    {
        printf("%s\n", *(language + i));
    }
    
    
    return 0;
}