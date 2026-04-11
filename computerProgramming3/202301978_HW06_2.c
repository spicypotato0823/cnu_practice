#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>



int main() 
{
    char input[100];
    scanf("%[^\n]s", input);
    int i = 0;
    int t = 0;
    int start = 0;
    int end = 0;
    char word[20][20];
    while (input[i] != '\0')
    {
        if(input[i] == ' ')
        {
            end = i - 1;   
            for(int j = start; j < end; j++)
            {
                word[t][j - start] = input[j];
            }
            t++;
            start = i;
        }
        i++;
    }

    for(int j = t + 1; j>=0; j--)
    {
        printf("%s", word[j]);
    }
    return 0;
}
