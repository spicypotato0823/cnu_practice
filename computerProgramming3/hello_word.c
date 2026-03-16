#include <stdio.h>

int main(void)
{
    char a[] = {100, 200, 300};
    int min = -1;

    if(sizeof(a) > min)
    {
        printf("first element is %d\n", a[0]);
    }
    else
    {
        printf("too small array!\n");
    }
    return 0;
}