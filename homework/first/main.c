#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main() {

    char  value;
    char *Line;
    float sum = 0;
    char a[256];
    int i = 0;

    Line = malloc(sizeof(char));
    printf("Enter line: ");
    gets(Line);
    printf("Enter value: ");
    gets(a);

    while(strlen(a) != 1)
    {
        printf("Try again: ");
        gets(a);
        while(getchar() != '\n');
    }
    value = a[0];

    for(i=0; i<strlen(Line); i++)
    {
        if(Line[i] == value)
            sum++;
    }

    printf("Relative number of charcters: %.2f;\nHow much chars: %.0f;\n", sum/strlen(Line), sum);

    return 0;
}

